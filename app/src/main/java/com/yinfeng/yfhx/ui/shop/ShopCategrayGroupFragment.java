package com.yinfeng.yfhx.ui.shop;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.classic.common.MultipleStatusView;
import com.lgd.lgd_core.base.BaseFragment;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.ITTUtils;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.adapter.shop.ShopCategrayAdapter;
import com.yinfeng.yfhx.entity.common.CommonExternalBean;
import com.yinfeng.yfhx.entity.common.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.shop.ShopCategrayFragmentBean;
import com.yinfeng.yfhx.ui.details.CommodityDetailsActivity;

import org.json.JSONArray;

import java.util.LinkedHashMap;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.fragments.home
 * 类  名：GeneralPurposeFragment
 * 创建人：liuguodong
 * 创建时间：2019/9/20 15:39
 * ============================================
 **/
public class ShopCategrayGroupFragment extends BaseFragment implements View.OnClickListener {
    private RecyclerView mIncludeRecyclerview;
    private SmartRefreshLayout mRefreshLayout;
    private MultipleStatusView mMultipleStatusView;
    private ShopCategrayAdapter shopCategrayAdapter;

    private static String mRu_id = "";

    private TextView mIncludeSearchLayoutBtn;
    private EditText mIncludeSearchLayoutInput;
    private View view;

    public static ShopCategrayGroupFragment newInstance(String ru_id) {
        Bundle args = new Bundle();
        mRu_id = ru_id;
        ShopCategrayGroupFragment generalPurposeFragment = new ShopCategrayGroupFragment();
        generalPurposeFragment.setArguments(args);
        return generalPurposeFragment;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_shop_categray;
    }

    @Override
    protected void initView(View view) {
        mIncludeRecyclerview = (RecyclerView) view.findViewById(R.id.include_multiple_recyclerview);
        mRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.include_multiple_refreshLayout);
        mMultipleStatusView = (MultipleStatusView) view.findViewById(R.id.include_multiple_status_view);
        mRefreshLayout.setOnRefreshListener(onRefreshListener);
        mMultipleStatusView.setOnRetryClickListener(mRetryClickListener);
        mRefreshLayout.autoRefresh();


        mIncludeSearchLayoutBtn = (TextView) view.findViewById(R.id.include_search_layout_btn);
        mIncludeSearchLayoutBtn.setOnClickListener(this);
        mIncludeSearchLayoutInput = (EditText) view.findViewById(R.id.include_search_layout_input);
        mIncludeSearchLayoutInput.setOnClickListener(this);
    }

    @Override
    protected void initData() {


    }


    OnRefreshListener onRefreshListener = new OnRefreshListener() {
        @Override
        public void onRefresh(@NonNull RefreshLayout refreshLayout) {
            requestDate();
            mRefreshLayout.finishRefresh(1000);
        }
    };


    final View.OnClickListener mRetryClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mMultipleStatusView.showLoading();
            mRefreshLayout.autoRefresh();
        }
    };


    private void setAdapter(ShopCategrayFragmentBean bean) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(gridLayoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        //消除嵌套卡顿
//        mIncludeRecyclerview.setNestedScrollingEnabled(false);
        shopCategrayAdapter = new ShopCategrayAdapter(R.layout.ri_shop_categray_item, bean.getData());
        shopCategrayAdapter.openLoadAnimation();
        mIncludeRecyclerview.setAdapter(shopCategrayAdapter);
        shopCategrayAdapter.setOnItemChildClickListener(onItemChildClickListener);

    }

    private BaseQuickAdapter.OnItemChildClickListener onItemChildClickListener = new BaseQuickAdapter.OnItemChildClickListener() {
        @Override
        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
            switch (view.getId()) {

                case R.id.ri_shop_categray_item_group:
                    ShopCategrayFragmentBean.DataBean bean = shopCategrayAdapter.getData().get(position);
                    ITTUtils.Jump(CommodityDetailsActivity.class, bean.getGoods_id() + "");

                default:
            }
        }
    };


    private void requestDate() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("store_id", mRu_id);

        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.shop_shopgoodslist_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            ShopCategrayFragmentBean bean = GsonUS.getIns().getGosn(response, ShopCategrayFragmentBean.class);
                            if (bean != null && bean.getData().size() > 0) {
                                setAdapter(bean);
                            } else {
                                mMultipleStatusView.showEmpty();
                            }
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                CommonStatusErrorBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean.class);
                                ToastUS.Error(bean_e.getErrors().getMessage());
                                mMultipleStatusView.showEmpty();
                            }
                        }


                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                        mMultipleStatusView.showError();
                    }
                })
        ;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.include_search_layout_btn:

                String inptuStr = mIncludeSearchLayoutInput.getText().toString();



//                ITTUtils.Jump(SearchListActivity.class, "" +inptuStr);
                requestDateSearch(inptuStr);
                break;
        }
    }


    private void requestDateSearch(String jump_keywords) {
        LinkedHashMap<String, String> mParamsMapx = new LinkedHashMap<>();
        JSONArray jsonArray=new JSONArray();
        jsonArray.put(jump_keywords);
        mParamsMapx.put("keywords", jump_keywords);
        mParamsMapx.put("size", "10");
        mParamsMapx.put("page", "1");
        new OKBuilder(getContext())
                .setNetUrl(Api.shop_shopgoodslist_post)
                .setParamsMap(mParamsMapx)
//                .showLoading("loading...")
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            ShopCategrayFragmentBean bean = GsonUS.getIns().getGosn(response, ShopCategrayFragmentBean.class);
                            if (bean != null && bean.getData().size() > 0) {
                                setAdapter(bean);
                            } else {
                                mMultipleStatusView.showEmpty();
                            }
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                CommonStatusErrorBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean.class);
                                ToastUS.Error(bean_e.getErrors().getMessage());
                                mMultipleStatusView.showEmpty();
                            }
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                        mMultipleStatusView.showError();
                    }
                });
    }

}

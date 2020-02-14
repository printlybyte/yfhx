package com.yinfeng.yfhx.ui.shop;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.classic.common.MultipleStatusView;
import com.lgd.lgd_core.base.BaseFragment;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.adapter.shop.ShopCouponAdapter;
import com.yinfeng.yfhx.entity.common.CommonExternalBean;
import com.yinfeng.yfhx.entity.common.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.shop.ShopCouponFragmentBean;
import com.yinfeng.yfhx.ui.utils.CouponUtils;

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
public class ShopCouponFragment extends BaseFragment {
    private RecyclerView mIncludeRecyclerview;
    private SmartRefreshLayout mRefreshLayout;
    private MultipleStatusView mMultipleStatusView;
    private ShopCouponAdapter shopCouponAdapter;

    private static String mRu_id = "";


    public static ShopCouponFragment newInstance(String ru_id) {
        Bundle args = new Bundle();
        mRu_id = ru_id;
        ShopCouponFragment generalPurposeFragment = new ShopCouponFragment();
        generalPurposeFragment.setArguments(args);
        return generalPurposeFragment;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_shop_coupon;
    }

    @Override
    protected void initView(View view) {
        mIncludeRecyclerview = (RecyclerView) view.findViewById(R.id.include_multiple_recyclerview);
        mRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.include_multiple_refreshLayout);
        mMultipleStatusView = (MultipleStatusView) view.findViewById(R.id.include_multiple_status_view);
        mRefreshLayout.setOnRefreshListener(onRefreshListener);
        mMultipleStatusView.setOnRetryClickListener(mRetryClickListener);
        mRefreshLayout.autoRefresh();
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


    private void setAdapter(ShopCouponFragmentBean bean) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 1);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(gridLayoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        //消除嵌套卡顿
//        mIncludeRecyclerview.setNestedScrollingEnabled(false);
        shopCouponAdapter = new ShopCouponAdapter(R.layout.ri_shop_coupon_item, bean.getData());
        shopCouponAdapter.openLoadAnimation();
        mIncludeRecyclerview.setAdapter(shopCouponAdapter);
        shopCouponAdapter.setOnItemChildClickListener(onItemChildClickListener);

    }

    private BaseQuickAdapter.OnItemChildClickListener onItemChildClickListener = new BaseQuickAdapter.OnItemChildClickListener() {
        @Override
        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
            switch (view.getId()) {

                case R.id.ri_shop_coupon_item_group:
                    String couId = shopCouponAdapter.getData().get(position).getCou_id() + "";
                    CouponUtils.getInstance().coupon_receive(couId);
                    CouponUtils.getInstance().setOnValueChangeListener(new CouponUtils.OnReceiveChangeListener() {
                        @Override
                        public void OnReceiveChange(int status) {
                            if (status==1){
                                requestDate();
                            }
                        }
                    });

                default:
            }
        }
    };


    private void requestDate() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("ru_id", mRu_id);
        map.put("page", "1");
        map.put("size", "100");
        map.put("status", "0");
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.shop_coupon_post)
                .setParamsMap(map)
                .getStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            ShopCouponFragmentBean bean = GsonUS.getIns().getGosn(response, ShopCouponFragmentBean.class);
                            if (bean != null && bean.getData().size() > 0) {
                                setAdapter(bean);
                            } else {
                                mMultipleStatusView.showEmpty();
                            }
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                CommonStatusErrorBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean.class);
                                ToastUS.Error(bean_e.getErrors().getMessage());
                                mMultipleStatusView.showError();
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


}

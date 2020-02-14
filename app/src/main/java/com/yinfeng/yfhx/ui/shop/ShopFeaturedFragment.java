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
import com.lgd.lgd_core.entity.XBannerImageBean;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.ITTUtils;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.XbannerUtils;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.stx.xhb.xbanner.XBanner;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.adapter.shop.ShopFeaturedAdapter;
import com.yinfeng.yfhx.entity.common.CommonExternalBean;
import com.yinfeng.yfhx.entity.common.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.shop.ShopCategrayFragmentBean;
import com.yinfeng.yfhx.ui.details.CommodityDetailsActivity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.fragments.home
 * 类  名：GeneralPurposeFragment
 * 创建人：liuguodong
 * 创建时间：2019/9/20 15:39
 * ============================================
 **/
public class ShopFeaturedFragment extends BaseFragment {
    private RecyclerView mIncludeRecyclerview;
    private SmartRefreshLayout mRefreshLayout;
    private MultipleStatusView mMultipleStatusView;
    private ShopFeaturedAdapter shopFeaturedAdapter;


    private static String mRu_id = "";
    private static List<String> mList;
    private XBanner mFragmentShopFeaturedBanner;


    public static ShopFeaturedFragment newInstance(String ru_id, List<String> mListx) {
        Bundle args = new Bundle();
        mRu_id = ru_id;
        mList = mListx;
        ShopFeaturedFragment generalPurposeFragment = new ShopFeaturedFragment();
        generalPurposeFragment.setArguments(args);
        return generalPurposeFragment;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_shop_featured;
    }

    @Override
    protected void initView(View view) {
        mIncludeRecyclerview = (RecyclerView) view.findViewById(R.id.include_multiple_recyclerview);
        mRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.include_multiple_refreshLayout);
        mMultipleStatusView = (MultipleStatusView) view.findViewById(R.id.include_multiple_status_view);
        mRefreshLayout.setOnRefreshListener(onRefreshListener);
        mRefreshLayout.setNestedScrollingEnabled(false);
        mRefreshLayout.setEnableRefresh(false);

        mMultipleStatusView.setOnRetryClickListener(mRetryClickListener);
        mFragmentShopFeaturedBanner = (XBanner) view.findViewById(R.id.fragment_shop_featured_banner);
    }

    @Override
    protected void initData() {


        setBannerDate(mList);

        requestDate();

    }

    private void setBannerDate(List<String> mList) {
        if (mList != null && mList.size() > 0) {
            mFragmentShopFeaturedBanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
                @Override
                public void onItemClick(XBanner banner, Object model, View view, int position) {
//                    ToastUS.Error(mList.get(position).getUrl());
//                    ITTUtils.Jump(Main2Activity.class, "" + mList.get(position).getUrl());
                }
            });
            List<XBannerImageBean> data = new ArrayList<>();
            for (int i = 0; i < mList.size(); i++) {
                XBannerImageBean xBannerImageBean = new XBannerImageBean();
                xBannerImageBean.setPath(mList.get(i) + "");
                data.add(xBannerImageBean);
            }
            XbannerUtils.getIns().setXbanner(mFragmentShopFeaturedBanner, data);
        }
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
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext,2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(gridLayoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        //消除嵌套卡顿
//        mIncludeRecyclerview.setNestedScrollingEnabled(false);
        shopFeaturedAdapter = new ShopFeaturedAdapter(R.layout.ri_shop_featured_item, bean.getData());
        shopFeaturedAdapter.openLoadAnimation();
        mIncludeRecyclerview.setAdapter(shopFeaturedAdapter);
        shopFeaturedAdapter.setOnItemChildClickListener(onItemChildClickListener);

    }

    private BaseQuickAdapter.OnItemChildClickListener onItemChildClickListener = new BaseQuickAdapter.OnItemChildClickListener() {
        @Override
        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
            switch (view.getId()) {
                case R.id.ri_shop_featured_item_group:
                    ShopCategrayFragmentBean.DataBean bean = shopFeaturedAdapter.getData().get(position);
                    ITTUtils.Jump(CommodityDetailsActivity.class, bean.getGoods_id() + "");
                default:
            }
        }
    };



    private void requestDate() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("store_id", mRu_id);
        map.put("store_best", "1");
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
                            if (bean != null&&bean.getData().size()>0) {
                                setAdapter(bean);
                            }else {
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


}

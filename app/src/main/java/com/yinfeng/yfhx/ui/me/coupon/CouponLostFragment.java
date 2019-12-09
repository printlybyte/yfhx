package com.yinfeng.yfhx.ui.me.coupon;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.classic.common.MultipleStatusView;
import com.lgd.lgd_core.base.BaseFragment;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.adapter.me.MeCouponAdapter;
import com.yinfeng.yfhx.entity.CouponNotFragmentBean;

import java.util.ArrayList;

/**
 * ============================================
 * 描  述：优惠券-已过期
 * 包  名：com.yinfeng.yfhx.fragments.home
 * 类  名：GeneralPurposeFragment
 * 创建人：liuguodong
 * 创建时间：2019/9/20 15:39
 * ============================================
 **/
public class CouponLostFragment extends BaseFragment {
    private RecyclerView mIncludeRecyclerview;
    private SmartRefreshLayout mRefreshLayout;
    private MultipleStatusView mMultipleStatusView;
    public static CouponLostFragment newInstance() {
        Bundle args = new Bundle();
        CouponLostFragment generalPurposeFragment = new CouponLostFragment();
        generalPurposeFragment.setArguments(args);
        return generalPurposeFragment;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_me_coupon_lost;
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

    private void requestDate() {
        new OKBuilder(getActivity())
                .setNetUrl(Api.coupon_coupon_get + "?page=1&size=200&type=0")
                .get()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CouponNotFragmentBean bean = GsonUS.getIns().getGosn(response, CouponNotFragmentBean.class);
                        if (bean != null && bean.getData() != null && bean.getData().size() > 0) {
                            setAdapter(bean);

                        } else {
                            mMultipleStatusView.showEmpty();
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                        mMultipleStatusView.showError();
                    }
                });
    }

    private void setAdapter(CouponNotFragmentBean bean) {
        MeCouponAdapter meCouponAdapter = new MeCouponAdapter(generateData(bean),2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Latte.getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(linearLayoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        mIncludeRecyclerview.setAdapter(meCouponAdapter);
        meCouponAdapter.openLoadAnimation();
        meCouponAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                }
            }
        });
    }

    private ArrayList<MultiItemEntity> generateData(CouponNotFragmentBean response) {
        ArrayList<MultiItemEntity> res = new ArrayList<>();
        for (int i = 0; i < response.getData().size(); i++) {
            CouponNotFragmentBean.DataBean bean = response.getData().get(i);
            FoldLevel1 lv1 = new FoldLevel1();
            lv1.setCou_end_time(bean.getCou_end_time());
            lv1.setCou_start_time(bean.getCou_start_time());
            lv1.setCou_name(bean.getCou_name());
            lv1.setCou_money(bean.getCou_money());
            lv1.setCou_type_name(bean.getCou_type_name());

            FoldLevel2 lv2 = new FoldLevel2();
            lv2.setStore_name(bean.getStore_name());
            lv1.addSubItem(lv2);
            res.add(lv1);
        }
        return res;

    }
}

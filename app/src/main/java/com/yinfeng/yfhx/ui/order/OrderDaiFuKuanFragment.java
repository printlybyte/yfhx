package com.yinfeng.yfhx.ui.order;

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
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.adapter.order.OrderDaifukuanAdapter;
import com.yinfeng.yfhx.entity.common.CommonExternalBean;
import com.yinfeng.yfhx.entity.common.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.order.OrderActivityBean;

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
public class OrderDaiFuKuanFragment extends BaseFragment {
    private RecyclerView mIncludeRecyclerview;
    private SmartRefreshLayout mRefreshLayout;
    private MultipleStatusView mMultipleStatusView;
    private OrderDaifukuanAdapter orderDaifukuanAdapter;

    public static OrderDaiFuKuanFragment newInstance() {
        Bundle args = new Bundle();
        OrderDaiFuKuanFragment generalPurposeFragment = new OrderDaiFuKuanFragment();
        generalPurposeFragment.setArguments(args);
        return generalPurposeFragment;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (orderDaifukuanAdapter == null || orderDaifukuanAdapter.getData().size() == 0) {


            }
        }
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_daifukuan_layout;
    }

    @Override
    protected void initView(View view) {
        mIncludeRecyclerview = (RecyclerView) view.findViewById(R.id.include_multiple_recyclerview);
        mRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.include_multiple_refreshLayout);
        mMultipleStatusView = (MultipleStatusView) view.findViewById(R.id.include_multiple_status_view);
        mRefreshLayout.setOnRefreshListener(onRefreshListener);
        mRefreshLayout.setOnLoadMoreListener(onLoadMoreListener);

        mMultipleStatusView.setOnRetryClickListener(mRetryClickListener);    mRefreshLayout.autoRefresh();
    }

    @Override
    protected void initData() {


    }


    OnLoadMoreListener onLoadMoreListener = new OnLoadMoreListener() {
        @Override
        public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
            requestDate(true);

            mRefreshLayout.finishLoadMore(1000);
        }
    };
    OnRefreshListener onRefreshListener = new OnRefreshListener() {
        @Override
        public void onRefresh(@NonNull RefreshLayout refreshLayout) {
            requestDate(false);
            //初始化分页数据
            mPage = 1;
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


    private void setAdapter(OrderActivityBean bean) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 1);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(gridLayoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        //消除嵌套卡顿
//        mIncludeRecyclerview.setNestedScrollingEnabled(false);
        orderDaifukuanAdapter = new OrderDaifukuanAdapter(R.layout.ri_daifukuan_item, bean.getData().getList());
        orderDaifukuanAdapter.openLoadAnimation();
        mIncludeRecyclerview.setAdapter(orderDaifukuanAdapter);
        orderDaifukuanAdapter.setOnItemChildClickListener(onItemChildClickListener);

    }

    private BaseQuickAdapter.OnItemChildClickListener onItemChildClickListener = new BaseQuickAdapter.OnItemChildClickListener() {
        @Override
        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//            switch (view.getId()) {
//                case R.id.ri_daifukuan_item_cencel_order:
//                    ToastUS.Error("取消订单");
//                    break;
//                case R.id.ri_daifukuan_item_pay:
//                    ToastUS.Error("立即支付");
//
//                    break;
//                case R.id.ri_daifukuan_item_query_order:
//                    ToastUS.Error("查询订单");
//
//                    break;
//                default:
//
//
//            }
        }
    };


    private int mPage = 1;

    private void requestDate(boolean isLoading) {
        if (isLoading) {
            mPage++;
        }
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        //0全部 1待付款 2待收货 3待发货
        map.put("status", "1");
//        map.put("type", " ");//bargain砍价订单 team拼团订单 ，不需要传空
        map.put("page", mPage + "");
        map.put("size", "10");
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.order_list_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            OrderActivityBean bean = GsonUS.getIns().getGosn(response, OrderActivityBean.class);

                            if (bean != null && bean.getData().getList().size() > 0) {
                                if (isLoading) {
                                    orderDaifukuanAdapter.addData(bean.getData().getList());
                                } else {
                                    setAdapter(bean);
                                }

                            } else {
                                if (isLoading) {
                                    ToastUS.Warning("暂无更多数据");
                                    mPage--;
                                    mMultipleStatusView.showContent();
                                } else {
                                    mMultipleStatusView.showEmpty();
                                }
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

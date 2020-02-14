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
import com.yinfeng.yfhx.adapter.order.OrderDaishouhuoAdapter;
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
public class OrderDaiShouhuoFragment extends BaseFragment {
    private RecyclerView mIncludeRecyclerview;
    private SmartRefreshLayout mRefreshLayout;
    private MultipleStatusView mMultipleStatusView;
    private OrderDaishouhuoAdapter orderDaishouhuoAdapter;

    public static OrderDaiShouhuoFragment newInstance() {
        Bundle args = new Bundle();
        OrderDaiShouhuoFragment generalPurposeFragment = new OrderDaiShouhuoFragment();
        generalPurposeFragment.setArguments(args);
        return generalPurposeFragment;
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
        orderDaishouhuoAdapter = new OrderDaishouhuoAdapter(R.layout.ri_daishouhuo_item, bean.getData().getList());
        orderDaishouhuoAdapter.openLoadAnimation();
        mIncludeRecyclerview.setAdapter(orderDaishouhuoAdapter);
        orderDaishouhuoAdapter.setOnItemChildClickListener(onItemChildClickListener);

    }

    private BaseQuickAdapter.OnItemChildClickListener onItemChildClickListener = new BaseQuickAdapter.OnItemChildClickListener() {
        @Override
        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//            switch (view.getId()) {
//                case R.id.ri_daishouhuo_item_request:
//                    ToastUS.Error("申请售后");
//                    break;
//                case R.id.ri_daishouhuo_item_confirm:
//                    ToastUS.Error("确认收货");
//                    break;
//
//                case R.id.ri_daishouhuo_item_query_order:
//                    ToastUS.Error("查看订单");
//                    break;
//                default:
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
        map.put("status", "2");
//        map.put("type", "0");//bargain砍价订单 team拼团订单 ，不需要传空
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
                                if (bean != null && bean.getData().getList().size() > 0) {
                                    if (isLoading) {
                                        orderDaishouhuoAdapter.addData(bean.getData().getList());
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

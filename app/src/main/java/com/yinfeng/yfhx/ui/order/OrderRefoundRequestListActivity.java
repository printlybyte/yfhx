package com.yinfeng.yfhx.ui.order;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.classic.common.MultipleStatusView;
import com.lgd.lgd_core.base.BaseActivity;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.IntentUtilsConstant;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.adapter.order.OrdeRefoundRequestListAdapter;
import com.yinfeng.yfhx.entity.common.CommonExternalBean;
import com.yinfeng.yfhx.entity.common.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.order.OrderRefoundRequestListActivityBean;

import java.util.LinkedHashMap;

/**
 * ============================================
 * 描  述：单个店铺多个商品申请售后列表
 * 包  名：com.yinfeng.yfhx.fragments.home
 * 类  名：GeneralPurposeFragment
 * 创建人：liuguodong
 * 创建时间：2019/9/20 15:39
 * ============================================
 **/
public class OrderRefoundRequestListActivity extends BaseActivity {
    private RecyclerView mIncludeRecyclerview;
    private SmartRefreshLayout mRefreshLayout;
    private MultipleStatusView mMultipleStatusView;
    private OrdeRefoundRequestListAdapter ordeRefoundAdapter;
    /**
     * 2019051311484825270
     */
    private TextView mRiRefoundRequstlistItemOrderSn;
    /**
     * 申请时间：2019-05-13 11：40：56
     */
    private TextView mRiRefoundRequstlistItemOrderTime;


    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_refound_request_list_layout;
    }

    private String mOrder_id = "";

    @Override
    protected void initView() {

        Intent intent = getIntent();
        String flags = intent.getStringExtra(IntentUtilsConstant.INTENT_PARAMS_1);
        if (!TextUtils.isEmpty(flags)) {
            mOrder_id = flags;
        }


        mIncludeRecyclerview = (RecyclerView) findViewById(R.id.include_multiple_recyclerview);
        mRefreshLayout = (SmartRefreshLayout) findViewById(R.id.include_multiple_refreshLayout);
        mMultipleStatusView = (MultipleStatusView) findViewById(R.id.include_multiple_status_view);
        mRefreshLayout.setOnRefreshListener(onRefreshListener);
        mMultipleStatusView.setOnRetryClickListener(mRetryClickListener);


        mRiRefoundRequstlistItemOrderSn = (TextView) findViewById(R.id.ri_refound_requstlist_item_order_sn);
        mRiRefoundRequstlistItemOrderTime = (TextView) findViewById(R.id.ri_refound_requstlist_item_order_time);
    }


    @Override
    protected void initData() {
        setTitle("申请售后");
        requestDate();

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


    private void setAdapter(OrderRefoundRequestListActivityBean bean) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 1);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(gridLayoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        //消除嵌套卡顿
//        mIncludeRecyclerview.setNestedScrollingEnabled(false);
        ordeRefoundAdapter = new OrdeRefoundRequestListAdapter(R.layout.ri_refound_request_list_item, bean.getData().getGoods(),bean.getData().getOrder_id()+"");

        ToastUS.Error(bean.getData().getOrder_id()+"");

        ordeRefoundAdapter.openLoadAnimation();
        mIncludeRecyclerview.setAdapter(ordeRefoundAdapter);
        ordeRefoundAdapter.setOnItemChildClickListener(onItemChildClickListener);

    }

    private BaseQuickAdapter.OnItemChildClickListener onItemChildClickListener = new BaseQuickAdapter.OnItemChildClickListener() {
        @Override
        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
            switch (view.getId()) {
//                case R.id.ri_daifahuo_item_query_order:
////                        String mGoods_id = orderChildAdapter.getData().get(position).getGoods_id() + "";
////                        ITTUtils.Jump(CommodityDetailsActivity.class, mGoods_id);
//
//                    ToastUS.Error("查看订单");
//                    break;
//                case R.id.ri_daifahuo_item_request:
//
//                    ToastUS.Error("申请售后");
//
//                    break;


                default:
            }
        }
    };


    private void requestDate() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("order_id", mOrder_id);
        map.put("page", "1");
        map.put("size", "10");
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.refound_returngoods_post)
                .setParamsMap(map)
                .getStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            OrderRefoundRequestListActivityBean bean = GsonUS.getIns().getGosn(response, OrderRefoundRequestListActivityBean.class);
                            if (bean != null && bean.getData() != null) {
                                setAdapter(bean);
                                mMultipleStatusView.showContent();

                                mRiRefoundRequstlistItemOrderSn.setText(bean.getData().getOrder_sn()+"");
                                mRiRefoundRequstlistItemOrderTime.setText("申请时间："+bean.getData().getFormated_add_time()+"");
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


}

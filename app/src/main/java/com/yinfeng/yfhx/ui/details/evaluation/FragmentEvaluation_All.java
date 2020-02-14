package com.yinfeng.yfhx.ui.details.evaluation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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
import com.yinfeng.yfhx.adapter.details.Evaluation_All_Adapter;
import com.yinfeng.yfhx.entity.common.CommonExternalBean;
import com.yinfeng.yfhx.entity.common.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.details.FragmentEvaluation_AllBean;

import java.util.LinkedHashMap;

/**
 * ============================================
 * 描  述：评价  全部
 * 包  名：com.yinfeng.yfhx.ui.details
 * 类  名：FragmentEvaluationList
 * 创建人：liuguodong
 * 创建时间：2019/11/15 10:15
 * ============================================
 **/
public class FragmentEvaluation_All extends BaseFragment {
    private RecyclerView mIncludeRecyclerview;
    private SmartRefreshLayout mRefreshLayout;
    private MultipleStatusView mMultipleStatusView;

    private static String mGoods_id="";
    public static FragmentEvaluation_All newInstance(String good_id) {
        Bundle args = new Bundle();
        mGoods_id=good_id;
        FragmentEvaluation_All generalPurposeFragment = new FragmentEvaluation_All();
        generalPurposeFragment.setArguments(args);
        return generalPurposeFragment;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_evaluation_all;
    }

    @Override
    protected void initView(View view) {
        mIncludeRecyclerview = (RecyclerView) view.findViewById(R.id.include_multiple_recyclerview);
        mRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.include_multiple_refreshLayout);
        mMultipleStatusView = (MultipleStatusView) view.findViewById(R.id.include_multiple_status_view);
//        mRefreshLayout.setOnRefreshListener(onRefreshListener);
        mMultipleStatusView.setOnRetryClickListener(mRetryClickListener);
        mRefreshLayout.setEnableLoadMore(false);
        mRefreshLayout.setEnableRefresh(false);
    }

    @Override
    protected void initData() {
        requestDate( );
    }

    OnRefreshListener onRefreshListener = new OnRefreshListener() {
        @Override
        public void onRefresh(@NonNull RefreshLayout refreshLayout) {
            mRefreshLayout.finishRefresh(1000);
        }
    };


    final View.OnClickListener mRetryClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mMultipleStatusView.showLoading();
            requestDate();
        }
    };

    private void requestDate( ) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("goods_id", mGoods_id);
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.cart_comment_goods_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success") ) {
                            FragmentEvaluation_AllBean bean = GsonUS.getIns().getGosn(response, FragmentEvaluation_AllBean.class);
                            if (bean != null&&bean.getData()!=null&&bean.getData().size()>0) {
                                setAdapter(bean);
                            }else {
                                mMultipleStatusView.showEmpty();
                            }
                        } else if (beanx.getStatus().equals("failed")) {
                            mMultipleStatusView.showEmpty();
                            if (beanx != null) {
                                CommonStatusErrorBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean.class);
                                ToastUS.Error(bean_e.getErrors().getMessage());
                            }
                        }


                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {

                    }
                })
        ;
    }

    private void setAdapter(FragmentEvaluation_AllBean bean) {
        Evaluation_All_Adapter evaluation_all_adapter = new Evaluation_All_Adapter(getActivity(),R.layout.item_f_evaluation_all_layout, bean.getData());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Latte.getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(linearLayoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        mIncludeRecyclerview.setAdapter(evaluation_all_adapter);
        evaluation_all_adapter.openLoadAnimation();


    }

}

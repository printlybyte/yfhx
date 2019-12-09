package com.yinfeng.yfhx.ui.me;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.classic.common.MultipleStatusView;
import com.kongzue.dialog.interfaces.OnDialogButtonClickListener;
import com.kongzue.dialog.util.BaseDialog;
import com.kongzue.dialog.v3.MessageDialog;
import com.lgd.lgd_core.base.BaseActivity;
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
import com.yinfeng.yfhx.adapter.me.HistoryIndexAdapter;
import com.yinfeng.yfhx.adapter.me.MeAddressAdapter;
import com.yinfeng.yfhx.entity.CommonExternalBean;
import com.yinfeng.yfhx.entity.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.me.HistoryIndexActivityBean;
import com.yinfeng.yfhx.ui.details.CommodityDetailsActivity;

import java.util.LinkedHashMap;
import java.util.List;

public class HistoryIndexActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView mIncludeRecyclerview;
    private SmartRefreshLayout mRefreshLayout;
    private MultipleStatusView mMultipleStatusView;
    private TextView mActivityHistoryIndexContent;
    /**
     * 清空
     */
    private TextView mActivityHistoryIndexClean;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_history_index;
    }

    @Override
    protected void initView() {
        mIncludeRecyclerview = (RecyclerView) findViewById(R.id.include_multiple_recyclerview);
        mRefreshLayout = (SmartRefreshLayout) findViewById(R.id.include_multiple_refreshLayout);
        mMultipleStatusView = (MultipleStatusView) findViewById(R.id.include_multiple_status_view);
        mRefreshLayout.setOnRefreshListener(onRefreshListener);
        mMultipleStatusView.setOnRetryClickListener(mRetryClickListener);
        mRefreshLayout.autoRefresh();

        mActivityHistoryIndexContent = (TextView) findViewById(R.id.activity_history_index_content);
        mActivityHistoryIndexClean = (TextView) findViewById(R.id.activity_history_index_clean);
        mActivityHistoryIndexClean.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        setTitle("我的足迹");
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
        new OKBuilder(this)
                .setNetUrl(Api.history_index_get)
                .showLoading()
                .get()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        HistoryIndexActivityBean bean = GsonUS.getIns().getGosn(response, HistoryIndexActivityBean.class);
                        if (bean != null && bean.getData() != null && bean.getData().size() > 0) {
                            mActivityHistoryIndexContent.setText("足迹 " + bean.getData().size() + "条");
                            setAdapter(bean);
                            mActivityHistoryIndexClean.setEnabled(true);
                            mMultipleStatusView.showContent();
                        } else {
                            mMultipleStatusView.showEmpty();
                            mActivityHistoryIndexClean.setEnabled(false);
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                        mMultipleStatusView.showError();
                    }
                });

    }

    private void setAdapter(HistoryIndexActivityBean bean) {


        HistoryIndexAdapter historyIndexAdapter = new HistoryIndexAdapter(R.layout.ri_me_history_index_item, bean.getData());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Latte.getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(linearLayoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        mIncludeRecyclerview.setAdapter(historyIndexAdapter);
        historyIndexAdapter.openLoadAnimation();
        historyIndexAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                List<HistoryIndexActivityBean.DataBean> datas = adapter.getData();
                HistoryIndexActivityBean.DataBean bean = (HistoryIndexActivityBean.DataBean) adapter.getData().get(position);
                switch (view.getId()) {
                    case R.id.ri_history_index_item_group:
                        ITTUtils.Jump(CommodityDetailsActivity.class, bean.getId() + "");
                        break;
                }


            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
            case R.id.activity_history_index_clean:

                MessageDialog.show(HistoryIndexActivity.this, "提示", "确定清空浏览记录？", "是", "否", "")
                        .setButtonOrientation(LinearLayout.VERTICAL).setOnOkButtonClickListener(new OnDialogButtonClickListener() {
                    @Override
                    public boolean onClick(BaseDialog baseDialog, View view) {

                        requestDateDel();
                        return false;
                    }
                });


                break;
        }
    }

    private void requestDateDel() {
        LinkedHashMap<String, String> mParamsMapx = new LinkedHashMap<>();
        new OKBuilder(this)
                .setNetUrl(Api.history_mdestroy_delected)
                .setParamsMap(null)
                .showLoading("清理中...")
                .deleteStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {

                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                CommonStatusErrorBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean.class);
                                ToastUS.Error(bean_e.getErrors().getMessage());
                            }
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                    }
                });
    }
}

package com.yinfeng.yfhx.ui.me;

import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.classic.common.MultipleStatusView;
import com.lgd.lgd_core.base.BaseActivity;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.ITTUtils;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.adapter.me.HistoryIndexAdapter;
import com.yinfeng.yfhx.adapter.me.MeCelledGoodsAdapter;
import com.yinfeng.yfhx.entity.me.HistoryIndexActivityBean;
import com.yinfeng.yfhx.entity.me.MeCelledGoodsActivityBean;
import com.yinfeng.yfhx.ui.details.CommodityDetailsActivity;

import java.util.LinkedHashMap;
import java.util.List;

public class MeCelledGoodsActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView mIncludeRecyclerview;
    private SmartRefreshLayout mRefreshLayout;
    private MultipleStatusView mMultipleStatusView;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_megoods_index;
    }

    @Override
    protected void initView() {
        mIncludeRecyclerview = (RecyclerView) findViewById(R.id.include_multiple_recyclerview);
        mRefreshLayout = (SmartRefreshLayout) findViewById(R.id.include_multiple_refreshLayout);
        mMultipleStatusView = (MultipleStatusView) findViewById(R.id.include_multiple_status_view);
        mRefreshLayout.setOnRefreshListener(onRefreshListener);
        mMultipleStatusView.setOnRetryClickListener(mRetryClickListener);
        mRefreshLayout.autoRefresh();

    }

    @Override
    protected void initData() {
        setTitle("收藏商品");
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

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("page", "1");
        map.put("size", "1000");
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.collect_goods_get)
                .setParamsMap(map)
                .getStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        MeCelledGoodsActivityBean bean = GsonUS.getIns().getGosn(response, MeCelledGoodsActivityBean.class);
                        if (bean != null && bean.getData() != null && bean.getData().size() > 0) {
                            setAdapter(bean);
                            mMultipleStatusView.showContent();
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

    private void setAdapter(MeCelledGoodsActivityBean bean) {


        MeCelledGoodsAdapter meCelledGoodsAdapter = new MeCelledGoodsAdapter(R.layout.ri_me_celled_goods_item, bean.getData());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Latte.getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(linearLayoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        mIncludeRecyclerview.setAdapter(meCelledGoodsAdapter);
        meCelledGoodsAdapter.openLoadAnimation();
        meCelledGoodsAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                List<MeCelledGoodsActivityBean.DataBean> datas = adapter.getData();
                MeCelledGoodsActivityBean.DataBean bean = (MeCelledGoodsActivityBean.DataBean) adapter.getData().get(position);
                switch (view.getId()) {
                    case R.id.ri_me_celled_goods_item_group:
                        ITTUtils.Jump(CommodityDetailsActivity.class,   bean.getGoods_id() + "");
                        break;
                }


            }
        });
    }





}

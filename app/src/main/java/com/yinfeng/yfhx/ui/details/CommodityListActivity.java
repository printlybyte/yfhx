package com.yinfeng.yfhx.ui.details;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.classic.common.MultipleStatusView;
import com.lgd.lgd_core.base.BaseActivity;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.ITTUtils;
import com.lgd.lgd_core.ui.utils.IntentUtilsConstant;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.adapter.details.CommodityListAdapter;
import com.yinfeng.yfhx.entity.CommodityListActivityBean;
import com.yinfeng.yfhx.ui.utils.ShopCarUtils;

import java.util.LinkedHashMap;

/**
 * ============================================
 * 描  述：商品列表
 * 包  名：com.yinfeng.yfhx.ui.details
 * 类  名：CommodityListActivity
 * 创建人：liuguodong
 * 创建时间：2019/10/9 10:36
 * ============================================
 **/
public class CommodityListActivity extends BaseActivity {
    private RecyclerView mIncludeRecyclerview;
    private SmartRefreshLayout mRefreshLayout;
    private MultipleStatusView mMultipleStatusView;

    private String jump_cat_id = "";

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_commodity_list;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        jump_cat_id = intent.getStringExtra(IntentUtilsConstant.INTENT_PARAMS_1);
        if (TextUtils.isEmpty(jump_cat_id)) {
            ToastUS.Error("请携带查询参数");
            return;
        }

        mIncludeRecyclerview = (RecyclerView) findViewById(R.id.include_multiple_recyclerview);
        mRefreshLayout = (SmartRefreshLayout) findViewById(R.id.include_multiple_refreshLayout);
        mMultipleStatusView = (MultipleStatusView) findViewById(R.id.include_multiple_status_view);
        mRefreshLayout.setOnRefreshListener(onRefreshListener);
        mMultipleStatusView.setOnRetryClickListener(mRetryClickListener);
        mRefreshLayout.autoRefresh();
    }

    @Override
    protected void initData() {
        setTitle("商品分类");
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
        LinkedHashMap<String, String> mParamsMapx = new LinkedHashMap<>();
        mParamsMapx.put("cat_id", jump_cat_id);
        mParamsMapx.put("size", "10");
        mParamsMapx.put("page", "1");
        new OKBuilder(this)
                .setNetUrl(Api.goodslist_post)
                .setParamsMap(mParamsMapx)
//                .showLoading("loading...")
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommodityListActivityBean bean = GsonUS.getIns().getGosn(response, CommodityListActivityBean.class);
                        if (bean != null && bean.getData().size() > 0) {
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

    private void setAdapter(CommodityListActivityBean bean) {
        CommodityListAdapter commodityListAdapter = new CommodityListAdapter(R.layout.ri_details_commodilylist_item, bean.getData());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Latte.getApplicationContext(), 2);
        mIncludeRecyclerview.setLayoutManager(gridLayoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        mIncludeRecyclerview.setAdapter(commodityListAdapter);
        commodityListAdapter.openLoadAnimation();
        commodityListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.ri_details_commodilylist_item_group:
                        ITTUtils.Jump(CommodityDetailsActivity.class, commodityListAdapter.getData().get(position).getGoods_id() + "");
                        break;
                    case R.id.ri_details_commodilylist_item_add_shop:
                        String Goods_id = commodityListAdapter.getData().get(position).getGoods_id() + "";
                        String mProd = commodityListAdapter.getData().get(position).getProd() + "";
                        if (!TextUtils.isEmpty(mProd)) {
                            if (mProd.equals("1")) {
                                ShopCarUtils.getInstance().add(Goods_id, null,false);
                            }else {
                                ITTUtils.Jump(CommodityDetailsActivity.class, commodityListAdapter.getData().get(position).getGoods_id() + "");
                            }
                        }else {
                            ToastUS.Warning("err err");
                        }
                        break;
                }
            }
        });
    }

}

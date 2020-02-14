package com.yinfeng.yfhx.ui.me.savecard;

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
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.adapter.me.MeSaveCardYesAdapter;
import com.yinfeng.yfhx.entity.common.CommonExternalBean;
import com.yinfeng.yfhx.entity.common.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.me.SaveCardNotFragmentBean;

import java.util.LinkedHashMap;

/**
 * ============================================
 * 描  述：储值卡-未使用
 * 包  名：com.yinfeng.yfhx.fragments.home
 * 类  名：GeneralPurposeFragment
 * 创建人：liuguodong
 * 创建时间：2019/9/20 15:39
 * ============================================
 **/
public class SaveCardYesFragment extends BaseFragment {
    private RecyclerView mIncludeRecyclerview;
    private SmartRefreshLayout mRefreshLayout;
    private MultipleStatusView mMultipleStatusView;
    private int mPage = 1;

    public static SaveCardYesFragment newInstance() {
        Bundle args = new Bundle();
        SaveCardYesFragment generalPurposeFragment = new SaveCardYesFragment();
        generalPurposeFragment.setArguments(args);
        return generalPurposeFragment;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_me_savecard_not;
    }

    @Override
    protected void initView(View view) {
        mIncludeRecyclerview = (RecyclerView) view.findViewById(R.id.include_multiple_recyclerview);
        mRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.include_multiple_refreshLayout);
        mMultipleStatusView = (MultipleStatusView) view.findViewById(R.id.include_multiple_status_view);
        mRefreshLayout.setOnRefreshListener(onRefreshListener);
        mRefreshLayout.setOnLoadMoreListener(onLoadMoreListener);
        mMultipleStatusView.setOnRetryClickListener(mRetryClickListener);
        mRefreshLayout.autoRefresh();

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


    public void requestDate(boolean isLoading) {
        if (isLoading) {
            mPage++;
        }
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("type", "3");
        map.put("size", "10");
        map.put("page", mPage + "");
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.valuecard_post)
                .setParamsMap(map)
                .getStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            SaveCardNotFragmentBean bean_e = GsonUS.getIns().getGosn(response, SaveCardNotFragmentBean.class);

                            if (bean_e != null && bean_e.getData().getEnbale().size() > 0) {
                                if (isLoading) {
                                    yesAdapter.addData(bean_e.getData().getEnbale());
                                } else {
                                    setAdapter(bean_e);
                                }
                            } else {
                                if (isLoading) {
                                    ToastUS.Warning("暂无更多数据");
                                    mPage--;
                                } else {
                                    mMultipleStatusView.showEmpty();
                                }
                            }
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

    private MeSaveCardYesAdapter yesAdapter;

    private void setAdapter(SaveCardNotFragmentBean bean) {
        yesAdapter = new MeSaveCardYesAdapter(R.layout.ri_me_save_card_not_item, bean.getData().getEnbale());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Latte.getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(linearLayoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        mIncludeRecyclerview.setAdapter(yesAdapter);
        yesAdapter.openLoadAnimation();
    }


}

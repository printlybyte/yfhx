package com.yinfeng.yfhx.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lgd.lgd_core.base.BaseFragment;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.ITTUtils;
import com.lgd.lgd_core.ui.utils.LogUS;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.Main2Activity;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.adapter.home.HomeIndexAdapter;
import com.yinfeng.yfhx.entity.MultipleTabHomeItem;
import com.yinfeng.yfhx.entity.TabFragment1Bean;
import com.yinfeng.yfhx.entity.home.NoticelistBeanandAdListBean;
import com.yinfeng.yfhx.ui.webview.BrowserActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================
 * 描  述：首页-
 * 包  名：com.yinfeng.yfhx.fragments.home
 * 类  名：IndexFragment
 * 创建人：liuguodong
 * 创建时间：2019/9/9 9:52
 * ============================================
 **/
public class IndexFragment extends BaseFragment {
    private List<MultipleTabHomeItem> mParserList = null;
    private RecyclerView mIncludeRecyclerview;
    private HomeIndexAdapter homeIndexAdapter;
    private SmartRefreshLayout mRefreshLayout;


    public static IndexFragment newInstance() {
        Bundle args = new Bundle();
        IndexFragment sampleFragment = new IndexFragment();
        sampleFragment.setArguments(args);
        return sampleFragment;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_index;
    }

    @Override
    protected void initView(View view) {
        mIncludeRecyclerview = (RecyclerView) view.findViewById(R.id.include_recyclerview);
        mRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        mRefreshLayout.setOnRefreshListener(onRefreshListener);
        mRefreshLayout.autoRefresh();
    }

    @Override
    protected void initData() {
        String path = "https://t12.baidu.com/it/u=541581695,4055461334&fm=763";
//        GlideUS.loadHeader(path, mFragmentTab1Img);
//        GlideUS.loadPhoto(path, mFragmentTab1Imgheader);


    }


    OnRefreshListener onRefreshListener = new OnRefreshListener() {
        @Override
        public void onRefresh(@NonNull RefreshLayout refreshLayout) {
            requestDate();
            mRefreshLayout.finishRefresh(1000);
        }
    };

    /**
     * 请求首页数据
     */
    private void requestDate() {
        new OKBuilder(getActivity())
                .setNetUrl(Api.shop_get)
                .showLoading("loading...")
                .get()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        TabFragment1Bean bean = GsonUS.getIns().getGosn(response, TabFragment1Bean.class);
                        if (bean != null) {
                            mParserList = parserMultipleItemData(bean);
                            LogUS.I("mParserList.size: " + mParserList.size());
                            if (mParserList == null) {
                                ToastUS.Error("暂未请求到数据");
                                return;
                            }
                            setAdapter();
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                    }
                });
    }


    private void setAdapter() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(layoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        //消除嵌套卡顿
        mIncludeRecyclerview.setNestedScrollingEnabled(false);
        homeIndexAdapter = new HomeIndexAdapter(mParserList, getActivity());
        homeIndexAdapter.openLoadAnimation();
        mIncludeRecyclerview.setAdapter(homeIndexAdapter);
        homeIndexAdapter.setOnItemChildClickListener(onItemChildClickListener);
    }

    public List<MultipleTabHomeItem> parserMultipleItemData(TabFragment1Bean response) {
        List<MultipleTabHomeItem> list = new ArrayList<>();
        if (response.getData().getBanners() != null) {
            list.add(new MultipleTabHomeItem(MultipleTabHomeItem.banners, MultipleTabHomeItem.TEXT_SPAN_SIZE, response.getData().getBanners()));
        }

        if (response.getData().getNavs() != null) {
            list.add(new MultipleTabHomeItem(MultipleTabHomeItem.navs, MultipleTabHomeItem.TEXT_SPAN_SIZE, response.getData().getNavs()));
        }
        if (response.getData().getTopic() != null) {
            list.add(new MultipleTabHomeItem(MultipleTabHomeItem.topic, MultipleTabHomeItem.TEXT_SPAN_SIZE, response.getData().getTopic()));
        }
        if (response.getData().getNoticelist() != null && response.getData().getHdlist() != null) {
            List<NoticelistBeanandAdListBean> mList = new ArrayList<>();
            for (int i = 0; i < response.getData().getNoticelist().size(); i++) {
                NoticelistBeanandAdListBean bean = new NoticelistBeanandAdListBean();
                bean.setmUrl(response.getData().getNoticelist().get(i).getUrl());
                bean.setTitle(response.getData().getNoticelist().get(i).getTitle());
                mList.add(bean);
            }
            for (int i = 0; i < response.getData().getHdlist().size(); i++) {
                NoticelistBeanandAdListBean bean = new NoticelistBeanandAdListBean();
                bean.setmUrl(response.getData().getHdlist().get(i).getUrl());
                bean.setTitle(response.getData().getHdlist().get(i).getTitle());
                mList.add(bean);
            }
            list.add(new MultipleTabHomeItem(MultipleTabHomeItem.noticelist, MultipleTabHomeItem.TEXT_SPAN_SIZE, mList));
        }
        if (response.getData().getSeckills() != null) {
            list.add(new MultipleTabHomeItem(MultipleTabHomeItem.seckills, MultipleTabHomeItem.TEXT_SPAN_SIZE, response.getData().getSeckills()));
        }
        if (response.getData().getAds() != null) {
            list.add(new MultipleTabHomeItem(MultipleTabHomeItem.ads, MultipleTabHomeItem.TEXT_SPAN_SIZE, response.getData().getAds()));
        }
        if (response.getData().getStores() != null) {
            list.add(new MultipleTabHomeItem(MultipleTabHomeItem.stores, MultipleTabHomeItem.TEXT_SPAN_SIZE, response.getData().getStores()));
        }

        if (response.getData().getStores() != null) {
            list.add(new MultipleTabHomeItem(MultipleTabHomeItem.newgoods, MultipleTabHomeItem.TEXT_SPAN_SIZE, response.getData().getNewgoods()));
        }
        return list;
    }


    private BaseQuickAdapter.OnItemChildClickListener onItemChildClickListener = new BaseQuickAdapter.OnItemChildClickListener() {
        @Override
        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
            switch (view.getId()) {
                case R.id.item_fragment_tab1_topic_layout_img:
                    List<TabFragment1Bean.DataBean.TopicBean> mListTopic = homeIndexAdapter.getData().get(position).getBean();
                    ITTUtils.Jump(Main2Activity.class, mListTopic.get(0).getUrl());
                    break;
                default:
            }
        }
    };

}

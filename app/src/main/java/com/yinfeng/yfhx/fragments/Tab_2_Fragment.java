package com.yinfeng.yfhx.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.FragmentUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lgd.lgd_core.base.BaseFragment;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.LogUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.adapter.categray.GroupAdapter;
import com.yinfeng.yfhx.entity.TabFragment2Bean_Group;
import com.yinfeng.yfhx.ui.category.ChildFragment;
import com.yinfeng.yfhx.ui.search.SearchActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.fragments
 * 类  名：Tab_1_Fragment
 * 创建人：liuguodong
 * 创建时间：2019/9/2 16:51
 * ============================================
 **/
public class Tab_2_Fragment extends BaseFragment implements View.OnClickListener {
    private RecyclerView mIncludeRecyclerview;

    private ArrayList<Fragment> mFragments = null;
    private View view;
    /**
     * 商品搜索
     */
    private TextView mIncludeSearchLayoutOc;


    public static Tab_2_Fragment newInstance() {
        Bundle args = new Bundle();
        Tab_2_Fragment sampleFragment = new Tab_2_Fragment();
        sampleFragment.setArguments(args);
        return sampleFragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUS.I("onResume2");
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_tab_2;
    }

    @Override
    protected void initView(View view) {
        mIncludeRecyclerview = (RecyclerView) view.findViewById(R.id.include_recyclerview);
        mIncludeSearchLayoutOc = (TextView) view.findViewById(R.id.include_search_layout_oc);
        mIncludeSearchLayoutOc.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        requestDate();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            //TODO now visible to user
        } else {
            //TODO now invisible to user
        }
    }

    private void requestDate() {

        new OKBuilder(getActivity())
                .setNetUrl(Api.catalog_list_get)
                .get()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        TabFragment2Bean_Group bean = GsonUS.getIns().getGosn(response, TabFragment2Bean_Group.class);
                        if (bean != null) {
                            setFragmentDate(bean);
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {

                    }
                })
        ;
    }

    private void setFragmentDate(TabFragment2Bean_Group bean) {
        if (mFragments == null) {
            mFragments = new ArrayList<>();
        }
        for (int i = 0; i < bean.getData().size(); i++) {
            TabFragment2Bean_Group.DataBean dataBean = bean.getData().get(i);
            String catName = bean.getData().get(i).getCat_name() + "";
            String catId = bean.getData().get(i).getCat_id() + "";
            if (!TextUtils.isEmpty(catName)) {
                mFragments.add(ChildFragment.newInstance(catName, catId));
                if (i == 0) {
                    dataBean.setSelected(true);
                } else {
                    dataBean.setSelected(false);
                }
            }
        }
        setAdapter(bean);
    }

    private GroupAdapter groupAdapter;

    private void setAdapter(TabFragment2Bean_Group bean) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(layoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        //消除嵌套卡顿
//        mIncludeRecyclerview.setNestedScrollingEnabled(false);
        groupAdapter = new GroupAdapter(R.layout.ri_group_item, bean.getData());
        groupAdapter.openLoadAnimation();
        mIncludeRecyclerview.setAdapter(groupAdapter);
        groupAdapter.setOnItemChildClickListener(onItemChildClickListener);
        selectFragment(0);
    }

    private BaseQuickAdapter.OnItemChildClickListener onItemChildClickListener = new BaseQuickAdapter.OnItemChildClickListener() {
        @Override
        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
            switch (view.getId()) {
                case R.id.ri_group_item_group:
                    List<TabFragment2Bean_Group.DataBean> datas = adapter.getData();
                    TabFragment2Bean_Group.DataBean bean = (TabFragment2Bean_Group.DataBean) adapter.getData().get(position);
                    for (TabFragment2Bean_Group.DataBean data : datas) {
                        data.setSelected(false);
                    }
                    bean.setSelected(true);
                    groupAdapter.notifyDataSetChanged();
                    selectFragment(position);
                    break;
                default:
            }
        }
    };


    private void selectFragment(int position) {
        for (int i = 0; i < mFragments.size(); i++) {
            if (position == i) {
                if (!mFragments.get(i).isAdded() && null == mFragmentManager.findFragmentByTag(position + "tag")) {
                    FragmentUtils.add(mFragmentManager, mFragments.get(i), R.id.fragment_tab_2_container, position + "tag");
                } else {
                    FragmentUtils.show(mFragments.get(i));
                }
            } else {
                FragmentUtils.hide(mFragments.get(i));
            }
        }
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.include_search_layout_oc:
                ActivityUtils.startActivity(SearchActivity.class);
                break;
        }
    }
}

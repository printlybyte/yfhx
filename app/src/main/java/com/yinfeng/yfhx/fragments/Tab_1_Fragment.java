package com.yinfeng.yfhx.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.flyco.tablayout.SlidingTabLayout;
import com.lgd.lgd_core.base.BaseFragment;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.TabFragment1Bean;
import com.yinfeng.yfhx.ui.home.GeneralPurposeFragment;
import com.yinfeng.yfhx.ui.home.IndexFragment;
import com.yinfeng.yfhx.ui.search.SearchActivity;

import java.util.ArrayList;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.fragments
 * 类  名：Tab_1_Fragment
 * 创建人：liuguodong
 * 创建时间：2019/9/2 16:51
 * ============================================
 **/
public class Tab_1_Fragment extends BaseFragment implements View.OnClickListener {

    private ArrayList<Fragment> mFragments = null;

    private ViewPager mFragmentTab1Viewpager;
    private SlidingTabLayout mTabLayout;
    private ArrayList<String> mTitles = null;
    private View view;
    /**
     * 商品搜索
     */
    private TextView mIncludeSearchLayoutOc;

    public static Tab_1_Fragment newInstance() {
        Bundle args = new Bundle();
        Tab_1_Fragment sampleFragment = new Tab_1_Fragment();
        sampleFragment.setArguments(args);
        return sampleFragment;
    }


    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_tab_1;
    }

    @Override
    protected void initView(View view) {
        mTabLayout = view.findViewById(R.id.include_tablayout);
        mFragmentTab1Viewpager = (ViewPager) view.findViewById(R.id.fragment_tab_1_viewpager);
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


    @Override
    public void onResume() {
        super.onResume();
    }

    private void requestDate() {
        new OKBuilder(getActivity())
                .setNetUrl(Api.shop_get)
                .get()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        TabFragment1Bean bean = GsonUS.getIns().getGosn(response, TabFragment1Bean.class);
                        if (bean != null) {
                            setTitleDate(bean);
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {

                    }
                })
        ;
    }

    private void setTitleDate(TabFragment1Bean bean) {
        if (mFragments == null) {
            mFragments = new ArrayList<>();
        }
        if (mTitles == null) {
            mTitles = new ArrayList<>();
        }
        for (int i = 0; i < bean.getData().getCategories().size(); i++) {
            String catName = bean.getData().getCategories().get(i).getCat_alias_name() + "";
            String catId = bean.getData().getCategories().get(i).getCat_id() + "";
            Log.i("testre", "catId: " + catId);

            if (!TextUtils.isEmpty(catName)) {
                if (i == 0) {
                    mFragments.add(IndexFragment.newInstance());
                    mTitles.add("首页");
                } else {
                    mFragments.add(GeneralPurposeFragment.newInstance(catId));
                    mTitles.add(catName);
                }
            }
        }
        mAdapter = new MyPagerAdapter(getChildFragmentManager());
        mFragmentTab1Viewpager.setAdapter(mAdapter);
        mTabLayout.setViewPager(mFragmentTab1Viewpager);
        mFragmentTab1Viewpager.setCurrentItem(0);
    }

    private MyPagerAdapter mAdapter;


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

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

}

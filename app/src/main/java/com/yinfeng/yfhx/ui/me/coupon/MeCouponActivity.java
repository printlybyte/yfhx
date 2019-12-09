package com.yinfeng.yfhx.ui.me.coupon;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.classic.common.MultipleStatusView;
import com.flyco.tablayout.SlidingTabLayout;
import com.lgd.lgd_core.base.BaseActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.fragments.Tab_1_Fragment;
import com.yinfeng.yfhx.ui.home.IndexFragment;

import java.util.ArrayList;

/**
 * ============================================
 * 描  述：优惠券
 * 包  名：com.yinfeng.yfhx.ui.me
 * 类  名：MeCouponActivity
 * 创建人：liuguodong
 * 创建时间：2019/10/16 10:03
 * ============================================
 **/
public class MeCouponActivity extends BaseActivity {
    private ArrayList<Fragment> mFragments = null;
    private ViewPager mFragmentTab1Viewpager;
    private TabLayout mTabLayout;
    private ArrayList<String> mTitles = null;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_coupon;
    }

    @Override
    protected void initView() {
        mTabLayout = findViewById(R.id.activity_coupon_tablayout);
        mFragmentTab1Viewpager = (ViewPager) findViewById(R.id.activity_coupon_viewpager);

    }

    @Override
    protected void initData() {
        setTitle("我的优惠券");
        if (mFragments == null) {
            mFragments = new ArrayList<>();
        }
        if (mTitles == null) {
            mTitles = new ArrayList<>();
        }
        mFragments.add(CouponNotFragment.newInstance());
        mFragments.add(CouponYesFragment.newInstance());
        mFragments.add(CouponLostFragment.newInstance());
        mTitles.add("未使用");
        mTitles.add("已使用");
        mTitles.add("已过期");
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mFragmentTab1Viewpager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mFragmentTab1Viewpager);
        mFragmentTab1Viewpager.setCurrentItem(0);
    }

    private MyPagerAdapter mAdapter;

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

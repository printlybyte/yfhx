package com.yinfeng.yfhx.ui.me.redpack;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.lgd.lgd_core.base.BaseActivity;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.ui.me.coupon.CouponYesFragment;
import com.yinfeng.yfhx.ui.me.savecard.SaveCardNotFragment;

import java.util.ArrayList;

/**
 * ============================================
 * 描  述：储值卡
 * 包  名：com.yinfeng.yfhx.ui.me
 * 类  名：MeCouponActivity
 * 创建人：liuguodong
 * 创建时间：2019/10/16 10:03
 * ============================================
 **/
public class MeReadPackActivity extends BaseActivity {
    private ArrayList<Fragment> mFragments = null;
    private ViewPager mFragmentTab1Viewpager;
    private TabLayout mTabLayout;
    private ArrayList<String> mTitles = null;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_redpack;
    }

    @Override
    protected void initView() {
        mTabLayout = findViewById(R.id.activity_redpack_tablayout);
        mFragmentTab1Viewpager = (ViewPager) findViewById(R.id.activity_redpack_viewpager);

    }

    @Override
    protected void initData() {
        setTitle("我的红包");
        if (mFragments == null) {
            mFragments = new ArrayList<>();
        }
        if (mTitles == null) {
            mTitles = new ArrayList<>();
        }
        mFragments.add(MeRedPackFragmentYes.newInstance());
        mFragments.add(MeRedPackFragmentNot.newInstance());
        mTitles.add("可用");
        mTitles.add("不可用");
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

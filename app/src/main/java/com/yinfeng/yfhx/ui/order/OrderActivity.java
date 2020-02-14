package com.yinfeng.yfhx.ui.order;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.lgd.lgd_core.base.BaseActivity;
import com.yinfeng.yfhx.R;

import java.util.ArrayList;

public class OrderActivity extends BaseActivity implements View.OnClickListener {
    private ArrayList<Fragment> mFragments = null;

    private ViewPager mFragmentTab1Viewpager;
    private TabLayout mTabLayout;
    private ArrayList<String> mTitles = null;


    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_order;
    }


    @Override
    protected void initView() {
//        Intent intent = getIntent();
//        ru_id = intent.getStringExtra(IntentUtilsConstant.INTENT_PARAMS_1);
//        if (TextUtils.isEmpty(ru_id)) {
//            ToastUS.Error("请携带查询参数");
//            return;
//        }
        mTabLayout = findViewById(R.id.activity_order_tablayout);
        mFragmentTab1Viewpager = (ViewPager) findViewById(R.id.activity_order_vp);

    }

    @Override
    protected void initData() {
        setTitle("订单列表");
        setTitleDate();
    }

    String ru_id = "1";

    private void setTitleDate( ) {
        if (mFragments == null) {
            mFragments = new ArrayList<>();
        }
        if (mTitles == null) {
            mTitles = new ArrayList<>();
        }
        mTitles.add("全部订单");
        mTitles.add("待付款");
        mTitles.add("待发货");
        mTitles.add("待收货");


        mFragments.add(OrderAllFragment.newInstance( ));
        mFragments.add(OrderDaiFuKuanFragment.newInstance( ));
        mFragments.add(OrderDaiFahuoFragment.newInstance( ));
        mFragments.add(OrderDaiShouhuoFragment.newInstance( ));

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

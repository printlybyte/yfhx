package com.yinfeng.yfhx;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.RequiresPermission;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.blankj.utilcode.util.FragmentUtils;
import com.chaychan.library.BottomBarItem;
import com.chaychan.library.BottomBarLayout;
import com.lgd.lgd_core.base.BaseActivity;
import com.yinfeng.yfhx.fragments.Tab_1_Fragment;
import com.yinfeng.yfhx.fragments.Tab_2_Fragment;
import com.yinfeng.yfhx.fragments.Tab_3_Fragment;
import com.yinfeng.yfhx.fragments.Tab_4_Fragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.Manifest.permission.READ_PHONE_STATE;

public class MainActivity extends BaseActivity {

    private List<Fragment> mFragmentList = new ArrayList<>();
    private BottomBarLayout mBottomBar;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        getFragments();
        mBottomBar = (BottomBarLayout) findViewById(R.id.bottomBar);
        mBottomBar.setOnItemSelectedListener(new BottomBarLayout.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final BottomBarItem bottomBarItem, int previousPosition, final int currentPosition) {
                selectFragment(currentPosition);
            }
        });


//        mBottomBarLayout.setUnread(0, 20);//设置第一个页签的未读数为20
//        mBottomBarLayout.setUnread(1, 1001);//设置第二个页签的未读数
//        mBottomBarLayout.showNotify(2);//设置第三个页签显示提示的小红点
//        mBottomBarLayout.setMsg(3, "NEW");//设置第四个页签显示NEW提示文字
    }


    @RequiresPermission(READ_PHONE_STATE)
    @Override
    protected void initData() {

        selectFragment(0);
    }

    private void selectFragment(int position) {
        for (int i = 0; i < mFragmentList.size(); i++) {
            if (position == i) {
                if (!mFragmentList.get(i).isAdded()) {
                    FragmentUtils.add(mFragmentManager, mFragmentList.get(i), R.id.contentContainer);
                } else {
                    FragmentUtils.show(mFragmentList.get(i));
                }
            } else {
                FragmentUtils.hide(mFragmentList.get(i));
            }
        }
    }

    private void getFragments() {
        mFragmentList.add(Tab_1_Fragment.newInstance());
        mFragmentList.add(Tab_2_Fragment.newInstance());
        mFragmentList.add(Tab_3_Fragment.newInstance());
        mFragmentList.add(Tab_4_Fragment.newInstance());
    }

    private void initTimePrompt() {
        IntentFilter timeFilter = new IntentFilter();
        timeFilter.addAction(Intent.ACTION_TIME_TICK);
        registerReceiver(mTimeReceiver, timeFilter);
    }

    private BroadcastReceiver mTimeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Calendar cal = Calendar.getInstance();
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int min = cal.get(Calendar.MINUTE);
            int ss = cal.get(Calendar.SECOND);
            Log.i("TESTRE", "  " + min + "  =   " + hour + "  =   " + ss);
        }
    };
}

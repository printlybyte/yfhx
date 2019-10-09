package com.yinfeng.yfhx.fragments;

import android.os.Bundle;
import android.view.View;

import com.lgd.lgd_core.base.BaseFragment;
import com.yinfeng.yfhx.R;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.fragments
 * 类  名：Tab_1_Fragment
 * 创建人：liuguodong
 * 创建时间：2019/9/2 16:51
 * ============================================
 **/
public class Tab_3_Fragment extends BaseFragment {

    public static Tab_3_Fragment newInstance() {
        Bundle args = new Bundle();
        Tab_3_Fragment sampleFragment = new Tab_3_Fragment();
        sampleFragment.setArguments(args);
        return sampleFragment;
    }


    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_tab_3;
    }

    @Override
    protected void initView(View root) {
    }

    @Override
    protected void initData() {
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
}

package com.yinfeng.yfhx.ui.fragments.home;

import android.os.Bundle;
import android.view.View;

import com.lgd.lgd_core.base.BaseFragment;
import com.yinfeng.yfhx.R;

/**
 * ============================================
 * 描  述：首页-通用fragment
 * 包  名：com.yinfeng.yfhx.ui.fragments.home
 * 类  名：GeneralPurposeFragment
 * 创建人：liuguodong
 * 创建时间：2019/9/20 15:39
 * ============================================
 **/
public class GeneralPurposeFragment extends BaseFragment {
    public static GeneralPurposeFragment newInstance() {
        Bundle args = new Bundle();
        GeneralPurposeFragment generalPurposeFragment = new GeneralPurposeFragment();
        generalPurposeFragment.setArguments(args);
        return generalPurposeFragment;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_general_purpose;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }
}

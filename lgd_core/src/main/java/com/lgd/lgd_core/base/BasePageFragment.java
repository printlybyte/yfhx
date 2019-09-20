package com.lgd.lgd_core.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.blankj.utilcode.util.ToastUtils;


/**
 * ============================================
 * 描  述：
 * 包  名：com.wlkj.tanyanmerchants.module.activity.home
 * 类  名：BasePageFragment
 * 创建人：lgd
 * 创建时间：2018/11/13 9:27
 * ============================================
 **/
public abstract class BasePageFragment extends Fragment {

    protected boolean isViewInitiated;
    protected boolean isVisibleToUser;
    protected boolean isDataInitiated;
    public Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext=getActivity();
        isViewInitiated = true;
        prepareFetchData();
    }



    public abstract void fetchData();

    public boolean prepareFetchData() {
        return prepareFetchData(false);
    }

    public boolean prepareFetchData(boolean forceUpdate) {
        if (isVisibleToUser && isViewInitiated && (!isDataInitiated || forceUpdate)) {
            fetchData();
            isDataInitiated = true;
            return true;
        }
        return false;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        prepareFetchData();
    }

}


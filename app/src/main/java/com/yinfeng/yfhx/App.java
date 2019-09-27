package com.yinfeng.yfhx;

import android.util.Log;

import com.lgd.lgd_core.base.BaseApplication;
import com.lgd.lgd_core.ui.utils.LogUS;
import com.tencent.smtt.sdk.QbSdk;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx
 * 类  名：App
 * 创建人：liuguodong
 * 创建时间：2019/9/2 18:29
 * ============================================
 **/
public class App extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();


        initTbs();
    }


    private void initTbs() {
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                LogUS.I("x5內核初始化完成的回调:" + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }

        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }
}

package com.yinfeng.yfhx.ui.login;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.lgd.lgd_core.base.AppManager;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.orhanobut.hawk.Hawk;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.yinfeng.yfhx.Apc;
import com.yinfeng.yfhx.MainActivity;

public class SplashActivity extends AppCompatActivity {
    protected RxPermissions mRxPermissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenUtils.setFullScreen(this);
        BarUtils.setNavBarVisibility(this, false);
        mRxPermissions = new RxPermissions(this);
        init();

    }

    private void init() {
        mRxPermissions
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE)
                .subscribe(granted -> {
                    if (granted) {
                        String isLoginStatus = Hawk.get(Apc.Apc_already_login_yfhx, "");
                        if (!TextUtils.isEmpty(isLoginStatus)) {
                            ActivityUtils.startActivity(MainActivity.class);
                        } else {
                            ActivityUtils.startActivity(LoginActivity.class);
                        }
                        finish();
                    } else {
                        init();
                        ToastUS.Warning("请申请权限");
                    }
                });
    }
}

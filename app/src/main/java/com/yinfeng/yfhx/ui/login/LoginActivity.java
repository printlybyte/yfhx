package com.yinfeng.yfhx.ui.login;

import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.ActivityUtils;
import com.lgd.lgd_core.base.BaseActivity;
import com.lgd.lgd_core.ui.loadingview.MT;
import com.yinfeng.yfhx.MainActivity;
import com.yinfeng.yfhx.R;

public class LoginActivity extends BaseActivity implements View.OnClickListener {


    /**
     * 登 录
     */
    private Button mBtLogin;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

        mBtLogin = (Button) findViewById(R.id.btLogin);
        mBtLogin.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btLogin:
                ActivityUtils.startActivity(MainActivity.class);
                break;
        }
    }
}

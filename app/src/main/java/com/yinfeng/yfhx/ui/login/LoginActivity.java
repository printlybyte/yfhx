package com.yinfeng.yfhx.ui.login;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.lgd.lgd_core.base.BaseActivity;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.LogUS;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.orhanobut.hawk.Hawk;
import com.yinfeng.yfhx.Apc;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.MainActivity;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.CommonExternalBean;
import com.yinfeng.yfhx.entity.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.login.LoginBean;

import java.util.LinkedHashMap;

public class LoginActivity extends BaseActivity implements View.OnClickListener {


    /**
     * 登 录
     */
    private Button mBtLogin;
    /**
     * 获取验证码
     */
    private TextView mActivityLoginGetvercode;
    /**
     * 输入注册手机号
     */
    private EditText mActivityLoginPhone;
    /**
     * 输入注册手机号
     */
    private EditText mActivityLoginRegistCode;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

        mBtLogin = (Button) findViewById(R.id.btLogin);
        mBtLogin.setOnClickListener(this);
        mActivityLoginGetvercode = (TextView) findViewById(R.id.activity_login_getvercode);
        mActivityLoginGetvercode.setOnClickListener(this);
        mActivityLoginPhone = (EditText) findViewById(R.id.activity_login_phone);
        mActivityLoginRegistCode = (EditText) findViewById(R.id.activity_login_regist_code);
        verifyCodeManager = new VerifyCodeManager(LoginActivity.this, mActivityLoginPhone, mActivityLoginGetvercode);
    }

    @Override
    protected void initData() {
        mActivityLoginPhone.setText(Hawk.get(Apc.Apc_login_phone, ""));
    }

    private VerifyCodeManager verifyCodeManager;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btLogin:
//                ActivityUtils.startActivity(MainActivity.class);

                String phone = mActivityLoginPhone.getText().toString();
                String rec_code = mActivityLoginRegistCode.getText().toString();
                if (TextUtils.isEmpty(phone)) {
                    ToastUS.Warning("手机号码不能为空");
                    return;
                }
                if (!RegexUtils.isMobileSimple(phone)) {
                    ToastUS.Warning("手机号码格式不正确");
                    return;
                }
                if (TextUtils.isEmpty(rec_code)) {
                    ToastUS.Warning("验证码不能为空");
                    return;
                }
                if (rec_code.length() < 6) {
                    ToastUS.Warning("验证码错误");
                    return;
                }

                postLogin(phone, rec_code);

                break;
            case R.id.activity_login_getvercode:
                verifyCodeManager.getVerifyCode(0);
                break;
        }
    }

    private void postLogin(String mobile, String code) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("mobile", mobile);
        map.put("code", code);
        map.put("client", "client");
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.user_mobileLogin_post)
                .setParamsMap(map)
                .showLoading("登录中...")
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            LoginBean bean_s = GsonUS.getIns().getGosn(response, LoginBean.class);
                            ToastUS.Success("登录成功");
                            Hawk.put(Apc.Apc_login_phone, mobile);
                            Hawk.put(Apc.Apc_already_login_yfhx, "1");
                            Hawk.put(Apc.Apc_token, "" + bean_s.getData());
                            ActivityUtils.startActivity(MainActivity.class);

                            LogUS.I(""+"" + bean_s.getData());
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                CommonStatusErrorBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean.class);
                                ToastUS.Error(bean_e.getErrors().getMessage());
                            }
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {

                    }
                });
    }

}

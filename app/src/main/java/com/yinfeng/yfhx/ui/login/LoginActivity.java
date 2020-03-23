package com.yinfeng.yfhx.ui.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.lgd.lgd_core.base.BaseActivity;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.InstallAppUtils;
import com.lgd.lgd_core.ui.utils.LogUS;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.orhanobut.hawk.Hawk;
import com.yinfeng.yfhx.Apc;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.MainActivity;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.common.CommonExternalBean;
import com.yinfeng.yfhx.entity.common.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.common.CommonStatusErrorBean2;
import com.yinfeng.yfhx.entity.login.LoginBean;
import com.yinfeng.yfhx.entity.pay.WxUserInfoBean;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.friends.Wechat;

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
    private ImageView mIvWxLogin;

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
        mIvWxLogin = (ImageView) findViewById(R.id.ivWxLogin);
        mIvWxLogin.setOnClickListener(this);
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
            case R.id.ivWxLogin:
                wx_loginAccount();
                break;
        }
    }

    private void postLogin(String mobile, String code) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("mobile", mobile);
        map.put("code", code);
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

                            LogUS.I("" + "" + bean_s.getData());


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


    /**
     * 微信授权
     */
    private void wx_loginAccount() {
        if (InstallAppUtils.isWeixinAvilible(LoginActivity.this)) {
            ToastUS.Normal("正在打开微信...");
            final Platform wechat = ShareSDK.getPlatform(Wechat.NAME);
            /*final Platform qq = ShareSDK.getPlatform(QQ.NAME);*/
            /*final Platform sinaweibo = ShareSDK.getPlatform(SinaWeibo.NAME);*/
            if (!wechat.isClientValid()) {
                //客户端可用
                ToastUS.Normal("客户端不可用...");
            }
            if (wechat.isAuthValid()) {
                wechat.removeAccount(true);
            }
            wechat.setPlatformActionListener(new PlatformActionListener() {
                @Override
                public void onComplete(Platform platform, int i, final HashMap<String, Object> hashMap) {
                    /*platform.getDb().exportData()获取用户数据*/
                    Log.i("ShareSDK", "onComplete ---->  登录成功" + platform.getDb().exportData());
                    String mUserId = platform.getDb().getUserId();
                    String mUserName = platform.getDb().getUserName();
                    String mUserIcon = platform.getDb().getUserIcon();
                    String getToken = platform.getDb().getToken();
                    String unionid = wechat.getDb().get("unionid");
                    String openid = wechat.getDb().get("openid");
                    LogUS.I("getToken: " + getToken + " openid: " + openid);
                    if (TextUtils.isEmpty(unionid)) {
                        return;
                    }
                    wx_getUserInfo(getToken, openid);
                }

                @Override
                public void onError(Platform platform, int i, Throwable throwable) {
                    Log.i("ShareSDK", "onError ---->  登录失败" + throwable.toString());
                    Log.i("ShareSDK", "onError ---->  登录失败" + throwable.getStackTrace().toString());
                    Log.i("ShareSDK", "onError ---->  登录失败" + throwable.getMessage());
                }

                @Override
                public void onCancel(Platform platform, int i) {
                    Log.i("ShareSDK", "onCancel ---->  登录取消");
                }
            });
            wechat.SSOSetting(false);
            wechat.showUser(null);
        } else {
            ToastUS.Normal("检测到当前手机未安装微信客户端，请前往应用商店下载最新版");
        }

    }

    private void wx_postLogin(String wxuser) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("wxuser", wxuser);
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.usert_wxLogin_post)
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
                            Hawk.put(Apc.Apc_already_login_yfhx, "1");
                            Hawk.put(Apc.Apc_token, "" + bean_s.getData());
                            ActivityUtils.startActivity(MainActivity.class);
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                CommonStatusErrorBean2 bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean2.class);
                                if (bean_e.getCode() == 102) {//等于102为未绑定  跳转绑定页面
                                    ToastUS.Normal("绑定");
                                } else {
                                    ToastUS.Error(bean_e.getErrors().getMessage());
                                }
                            }
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {

                    }
                });
    }

    private void wx_getUserInfo(String access_token, String openid) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("access_token", access_token);
        map.put("openid", openid);
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.getwx_login_userinfo_get)
                .setParamsMap(map)
                .showLoading("登录中...")
                .getStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        WxUserInfoBean bean = GsonUS.getIns().getGosn(response, WxUserInfoBean.class);
                        try {
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("openid", bean.getOpenid() + "");
                            jsonObject.put("nickname", bean.getNickname() + "");
                            jsonObject.put("sex", bean.getSex() + "");
                            jsonObject.put("province", bean.getProvince() + "");
                            jsonObject.put("city", bean.getCity() + "");
                            jsonObject.put("country", bean.getCity() + "");
                            jsonObject.put("privilege", bean.getPrivilege() + "");
                            jsonObject.put("headimgurl", bean.getHeadimgurl() + "");
                            jsonObject.put("unionid", bean.getUnionid() + "");
                            wx_postLogin(jsonObject.toString());
                        } catch (Exception e) {
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                        ToastUS.Normal("获取微信个人信息失败");
                    }
                });
    }
}

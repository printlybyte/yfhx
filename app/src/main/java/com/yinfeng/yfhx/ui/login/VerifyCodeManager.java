package com.yinfeng.yfhx.ui.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.RegexUtils;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.maning.mndialoglibrary.MToast;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.entity.CommonExternalBean;
import com.yinfeng.yfhx.entity.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.login.SendMsgBean;

import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.TimerTask;


public class VerifyCodeManager {

    private Context mContext;
    private int recLen = 60;
    private Timer timer = new Timer();
    private Handler mHandler = new Handler();
    private String phone;

    private EditText phoneEdit;
    private TextView getVerifiCodeButton;

    public VerifyCodeManager(Context context, EditText editText, TextView btn) {
        this.mContext = context;
        this.phoneEdit = editText;
        this.getVerifiCodeButton = btn;
    }

    public void getVerifyCode(int type) {
        // 获取验证码之前先判断手机号
        phone = phoneEdit.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            MToast.makeTextLong(mContext, "手机号码不能为空");
            return;
        } else if (phone.length() < 11) {
            MToast.makeTextLong(mContext, "手机号码不足11位");
            return;
        } else if (!RegexUtils.isMobileSimple(phone)) {
            MToast.makeTextLong(mContext, "手机号码格式不正确");
            return;
        }
        requst(phone);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        setButtonStatusOff();
                        if (recLen < 1) {
                            setButtonStatusOn();
                        }
                    }
                });
            }
        };
        timer = new Timer();
        timer.schedule(task, 0, 1000);

    }
    @SuppressLint("StringFormatMatches")
    private void setButtonStatusOff() {
        getVerifiCodeButton.setText("剩余" + String.format("%ss", recLen--));
        getVerifiCodeButton.setClickable(false);
        getVerifiCodeButton.setTextColor(Color.parseColor("#cfd3e3"));
    }

    private void setButtonStatusOn() {
        timer.cancel();
        getVerifiCodeButton.setText("重新发送");
        getVerifiCodeButton.setTextColor(Color.parseColor("#b1b1b3"));
        recLen = 60;
        getVerifiCodeButton.setClickable(true);
    }

    /**
     * ============================================
     * 描  述：
     * 返回类型：
     * 创建人：lgd
     * 创建时间：2018/11/23 13:56
     * ============================================
     **/
    private void requst(String mobile) {
            LinkedHashMap<String, String> map = new LinkedHashMap<>();
            map.put("mobile",mobile);
            new OKBuilder(Latte.getApplicationContext())
                    .setNetUrl(Api.sms_send_post)
                    .setParamsMap(map)
                    .postStringFormBody()
                    .setOnCallBackResponse(new CallBackResponseListener() {
                        @Override
                        public void setOnCallBackResponseSuccess(String response) {
                            CommonExternalBean bean = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                            CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                            if (beanx.getStatus().equals("success")) {
                                SendMsgBean bean_s = GsonUS.getIns().getGosn(response, SendMsgBean.class);
                                ToastUS.Success("发送成功");

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






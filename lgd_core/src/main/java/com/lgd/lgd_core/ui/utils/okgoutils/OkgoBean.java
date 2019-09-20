package com.lgd.lgd_core.ui.utils.okgoutils;

import com.blankj.utilcode.util.NetworkUtils;
import com.lgd.lgd_core.R;
import com.lgd.lgd_core.ui.utils.LogUS;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ============================================
 * 描  述：
 * 包  名：com.lgd.lgd_core.ui.utils.okgoutils
 * 类  名：OkgoBean
 * 创建人：liuguodong
 * 创建时间：2019/9/20 11:26
 * ============================================
 **/
public class OkgoBean {
    private CallBackResponseListener backResponseListener;
    private String mNetUrl;
    private JSONArray mJsonArray;
    private JSONObject mJsonObject;
    private Map mParamsMap;


    public void setNetUrl(String mNetUrl) {
        this.mNetUrl = mNetUrl;
    }

    public void setJsonArray(JSONArray jsonArray) {
        this.mJsonArray = jsonArray;
    }

    public void setJSONObject(JSONObject jsonObject) {
        this.mJsonObject = jsonObject;
    }

    public void setParamsMap(LinkedHashMap map) {
        this.mParamsMap = map;
    }

    public void setOnCallBackResponse(CallBackResponseListener callBackResponse) {
        this.backResponseListener = callBackResponse;
    }



    public void postJsonArray() {
        postJsonArrayx();

    }

    public void postJsonObject() {
        postJsonObjectx();

    }

    public void postStringFormBody() {
        postStringFormBodyx();

    }

    public void get() {
        getx();

    }


    private void postJsonArrayx() {
        if (!NetworkUtils.isConnected()) {
            ToastUS.Warning(R.string.net_err);
            return;
        }
        if (mJsonArray == null) {
            ToastUS.Warning(R.string.post_json_arr_empty);
            return;
        }
        LogUS.I("请求方式 postJsonArray :" + '\n' + "请求参数 ：" + mJsonArray.toString() + '\n' + "请求地址 " + mNetUrl);
        OkGo.<String>post(mNetUrl)
                .tag(this)
                .upJson(mJsonArray)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        LogUS.I("请求结果: 成功" + '\n' + "响应码" + response.code() + '\n' + "请求结果 " + response.body());
                        if (backResponseListener != null) {
                            backResponseListener.setOnCallBackResponseSuccess(response.body());
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        checkErrorCode(response.code());
                        LogUS.E("请求结果: 失败" + '\n' + "响应码" + response.code() + '\n' + "请求结果 " + response.body());
                        if (backResponseListener != null) {
                            backResponseListener.setOnCallBackResponseError(response.body());
                        }
                    }
                });

    }


    private void postJsonObjectx() {
        if (!NetworkUtils.isConnected()) {
            ToastUS.Warning(R.string.net_err);
            return;
        }
        if (mJsonObject == null) {
            ToastUS.Warning(R.string.post_json_obj_empty);
            return;
        }
        LogUS.I("请求方式 postJsonObject :" + '\n' + "请求参数 ：" + mJsonObject.toString() + '\n' + "请求地址 " + mNetUrl);

        OkGo.<String>post(mNetUrl)
                .tag(this)
                .upJson(mJsonObject)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        LogUS.I("请求结果: 成功" + '\n' + "响应码" + response.code() + '\n' + "请求结果 " + response.body());

                        if (backResponseListener != null) {
                            backResponseListener.setOnCallBackResponseSuccess(response.body());
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        checkErrorCode(response.code());
                        LogUS.E("请求结果: 失败" + '\n' + "响应码" + response.code() + '\n' + "请求结果 " + response.body());

                        if (backResponseListener != null) {
                            backResponseListener.setOnCallBackResponseError(response.body());
                        }
                    }
                });

    }

    private void postStringFormBodyx() {
        if (!NetworkUtils.isConnected()) {
            ToastUS.Warning(R.string.net_err);
            return;
        }
        if (mParamsMap == null) {
            ToastUS.Warning(R.string.post_params_empty);
            return;
        }
        LogUS.I("请求方式 postFormBody :" + '\n' + "请求参数 ：" + mParamsMap.toString() + '\n' + "请求地址 " + mNetUrl);
        OkGo.<String>post(mNetUrl)
                .tag(this)
                .params(mParamsMap)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        LogUS.I("请求结果: 成功" + '\n' + "响应码" + response.code() + '\n' + "请求结果 " + response.body());
                        if (backResponseListener != null) {
                            backResponseListener.setOnCallBackResponseSuccess(response.body());
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        checkErrorCode(response.code());
                        LogUS.E("请求结果: 失败" + '\n' + "响应码" + response.code() + '\n' + "请求结果 " + response.body());
                        if (backResponseListener != null) {
                            backResponseListener.setOnCallBackResponseError(response.body());
                        }
                    }
                });

    }

    public void getx() {
        if (!NetworkUtils.isConnected()) {
            ToastUS.Warning(R.string.net_err);
            return;
        }
        LogUS.I("请求方式 get :" + '\n' + "请求参数 ：没有参数" + '\n' + "请求地址 " + mNetUrl);
        OkGo.<String>get(mNetUrl)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        LogUS.I("请求结果: 成功" + '\n' + "响应码" + response.code() + '\n' + "请求结果 " + response.body());

                        if (backResponseListener != null) {
                            backResponseListener.setOnCallBackResponseSuccess(response.body());
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        LogUS.E("请求结果: 失败" + '\n' + "响应码" + response.code() + '\n' + "请求结果 " + response.body());

                        checkErrorCode(response.code());
                        if (backResponseListener != null) {
                            backResponseListener.setOnCallBackResponseError(response.body());
                        }
                    }
                });

    }

    private void checkErrorCode(int errCode) {
        if (errCode == err_code_403) {
        }
        ToastUS.Error(errCode + "");
    }

    private int err_code_403 = 403;
}

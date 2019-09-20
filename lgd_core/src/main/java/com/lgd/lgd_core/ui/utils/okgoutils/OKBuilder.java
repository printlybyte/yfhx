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

/**
 * ============================================
 * 描  述：
 * 包  名：com.lgd.lgd_core.ui.utils.okgoutils
 * 类  名：OKBuilder
 * 创建人：liuguodong
 * 创建时间：2019/9/20 11:27
 * ============================================
 **/
public class OKBuilder extends Builder {


    OkgoBean okgoBean = new OkgoBean();


    public OKBuilder(){

    }

    @Override
    public Builder setNetUrl(String mNetUrl) {
        okgoBean.setNetUrl(mNetUrl);
        return this;
    }

    @Override
    public Builder setJsonArray(JSONArray jsonArray) {
        okgoBean.setJsonArray(jsonArray);
        return this;
    }

    @Override
    public Builder setJSONObject(JSONObject jsonObject) {
        okgoBean.setJSONObject(jsonObject);
        return this;
    }

    @Override
    public Builder setParamsMap(LinkedHashMap map) {
        okgoBean.setParamsMap(map);
        return this;
    }

    @Override
    public Builder get() {

        okgoBean.getx();
        return this;

    }

    @Override
    public Builder postJsonArray() {
        okgoBean.postJsonArray();
        return this;
    }

    @Override
    public Builder postJsonObject() {
        okgoBean.postJsonObject();
        return this;
    }

    @Override
    public Builder postStringFormBody() {
        okgoBean.postStringFormBody();
        return this;
    }


    @Override
    public Builder setOnCallBackResponse(CallBackResponseListener callBackResponse) {
        okgoBean.setOnCallBackResponse(callBackResponse);
        return this;
    }




    @Override
    public OkgoBean build() {
        return okgoBean;
    }


}

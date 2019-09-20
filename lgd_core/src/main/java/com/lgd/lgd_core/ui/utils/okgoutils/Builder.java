package com.lgd.lgd_core.ui.utils.okgoutils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedHashMap;

/**
 * ============================================
 * 描  述：
 * 包  名：com.lgd.lgd_core.ui.utils.okgoutils
 * 类  名：Builder
 * 创建人：liuguodong
 * 创建时间：2019/9/20 11:27
 * ============================================
 **/
public abstract class Builder {
    public abstract Builder setNetUrl(String mNetUrl);

    public abstract Builder setJsonArray(JSONArray jsonArray);

    public abstract Builder setJSONObject(JSONObject jsonObject);

    public abstract Builder setParamsMap(LinkedHashMap map);

    public abstract Builder get();

    public abstract Builder postJsonArray();

    public abstract Builder postJsonObject();

    public abstract Builder postStringFormBody();


    public abstract Builder setOnCallBackResponse(CallBackResponseListener callBackResponse);

    public abstract OkgoBean build();
}

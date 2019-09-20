package com.lgd.lgd_core.ui.utils.okgoutils;

/**
 * ============================================
 * 描  述：
 * 包  名：com.lgd.lgd_core.ui.utils.okgoutils
 * 类  名：CallBackResponseListener
 * 创建人：liuguodong
 * 创建时间：2019/9/20 11:28
 * ============================================
 **/
public interface CallBackResponseListener {
    void setOnCallBackResponseSuccess(String response);

    void setOnCallBackResponseError(String response);
}

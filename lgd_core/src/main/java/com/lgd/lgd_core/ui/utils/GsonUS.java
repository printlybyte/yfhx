package com.lgd.lgd_core.ui.utils;

import com.google.gson.Gson;

/**
 * ============================================
 * 描  述：
 * 包  名：com.lgd.lgd_core.ui.utils
 * 类  名：GsonUS
 * 创建人：liuguodong
 * 创建时间：2019/9/6 13:40
 * ============================================
 **/
public class GsonUS {
    private GsonUS() {
    }

    private static class getInstance {
        private static GsonUS INSTANCE = new GsonUS();
    }

    public static GsonUS getIns() {
        return getInstance.INSTANCE;
    }

    public <T> T getGosn(String response, Class<T> tClass) {
        Gson gson = new Gson();
        try {
            return (T) gson.fromJson(response, tClass);
        } catch (Exception e) {

            ToastUS.Error(e.getMessage() + '\n' + tClass.getName());
            LogUS.E(e.getMessage());
            return null;
        }
    }

}

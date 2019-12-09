package com.lgd.lgd_core.ui.utils;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.JsonArray;

import org.json.JSONArray;

import java.util.Map;

/**
 * ============================================
 * 描  述：
 * 包  名：com.lgd.lgd_core.ui.utils
 * 类  名：CommonUtils
 * 创建人：liuguodong
 * 创建时间：2019/10/12 10:26
 * ============================================
 **/
public class CommonUtils {
    /**
     * 1 man 2 girl 果是奇数性别为男，偶数则为女。
     */
    public static int isSex(String idCard) {
        if (!TextUtils.isEmpty(idCard) && idCard.length() == 18) {
            if (Integer.parseInt(idCard.substring(16, 17)) % 2 == 0) {
                return 2;
            } else {
                return 1;
            }
        }
        return 0;
    }

    /**
     * 1 man 2 girl 果是奇数性别为男，偶数则为女。
     */
    public static String getSex(String idCard) {
        if (!TextUtils.isEmpty(idCard) && idCard.length() == 18) {
            if (Integer.parseInt(idCard.substring(16, 17)) % 2 == 0) {
                return "女";
            } else {
                return "男";
            }
        }
        return "未知";
    }

    public static int dp2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


    /**
     * html特殊转义
     */
    public static String replaceHtmlCotnent(String content) {
        if (!TextUtils.isEmpty(content)) {
            content = content.replace("&#039;", "'");
            content = content.replace("&quot;", "\"");
            content = content.replace("&lt;", "<");
            content = content.replace("&gt;", ">");
            content = content.replace("&amp;", "&");
        }
        return content;
    }




    public static <T> JSONArray getMapValueToJsonArray(Map<T, T> mapX) {
        StringBuilder stringBuilder = new StringBuilder();
        JSONArray jsonArray=new JSONArray();
        for (Map.Entry<T, T> entry : mapX.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            stringBuilder.append(" " + entry.getValue());
            jsonArray.put(entry.getValue());
        }
        LogUS.I("getMapValueToJsonArray: "+jsonArray.toString());
        return  jsonArray;
    }

    /**
     * 获取map结合value
     */

    public static <T> String getMapValue(Map<T, T> mapX) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<T, T> entry : mapX.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            stringBuilder.append(" " + entry.getValue());
        }
        LogUS.I("getMapValue: "+stringBuilder.toString());
        return "" + stringBuilder.toString();
    }

    /**
     * 获取map结合key
     */
    public static <T> String getMapKey(Map<T, T> mapX) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<T, T> entry : mapX.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            stringBuilder.append(" " + entry.getKey());
        }
        LogUS.I("getMapKey: "+stringBuilder.toString());
        return "" + stringBuilder.toString();
    }
}

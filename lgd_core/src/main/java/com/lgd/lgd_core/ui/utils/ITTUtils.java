package com.lgd.lgd_core.ui.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.lgd.lgd_core.event.Latte;

/**
 * ============================================
 * 描  述：
 * 包  名：com.lgd.lgd_core.ui.utils
 * 类  名：ITTUtils
 * 创建人：liuguodong
 * 创建时间：2019/9/26 15:34
 * ============================================
 **/
public class ITTUtils {
    private static Context context = Latte.getApplicationContext();

    public static void Jump(Class<?> cla, String params) {
        if (TextUtils.isEmpty(params)) {
            ToastUS.Warning("请输入携带参数");
            return;
        }
        Intent intent = new Intent(context, cla);
        intent.putExtra(IntentUtilsConstant.INTENT_PARAMS_1, params);
        context.startActivity(intent);
    }

    public static void Jump(Class<?> cla, String params, String params2) {
        if (TextUtils.isEmpty(params) || TextUtils.isEmpty(params2)) {
            ToastUS.Warning("请输入携带参数");
            return;
        }
        Intent intent = new Intent(context, cla);
        intent.putExtra(IntentUtilsConstant.INTENT_PARAMS_1, params);
        intent.putExtra(IntentUtilsConstant.INTENT_PARAMS_2, params2);
        context.startActivity(intent);
    }

    public static void Jump(Class<?> cla, String params, String params2, String params3) {
        if (TextUtils.isEmpty(params) || TextUtils.isEmpty(params2) || TextUtils.isEmpty(params3)) {
            ToastUS.Warning("请输入携带参数");
            return;
        }
        Intent intent = new Intent(context, cla);
        intent.putExtra(IntentUtilsConstant.INTENT_PARAMS_1, params);
        intent.putExtra(IntentUtilsConstant.INTENT_PARAMS_2, params2);
        intent.putExtra(IntentUtilsConstant.INTENT_PARAMS_3, params3);
        context.startActivity(intent);
    }
}

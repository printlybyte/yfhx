package com.lgd.lgd_core.ui.utils;


import com.orhanobut.logger.Logger;

/**
 * ============================================
 * 描  述：LOGUTILS
 * 包  名：com.lgd.lgd_core.ui.utils
 * 类  名：LogUS
 * 创建人：liuguodong
 * 创建时间：2019/9/3 17:56
 * ============================================
 **/
public final class LogUS {
    public static void I(String msg) {
        Logger.i(msg + "");
    }

    public static void E(String msg) {
        Logger.e(msg + "");
    }
}

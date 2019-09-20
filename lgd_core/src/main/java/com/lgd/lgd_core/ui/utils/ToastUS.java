package com.lgd.lgd_core.ui.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.lgd.lgd_core.R;
import com.lgd.lgd_core.base.BaseActivity;
import com.lgd.lgd_core.event.Latte;

import es.dmoral.toasty.Toasty;

/**
 * ============================================
 * 描  述：
 * 包  名：com.lgd.lgd_core.ui.utils
 * 类  名：ToastUS
 * 创建人：liuguodong
 * 创建时间：2019/9/2 18:14
 * ============================================
 **/
public final class ToastUS {

    private static Context mContext = Latte.getApplicationContext();

    public static void Error(String msg) {
        Toasty.error(mContext, msg, Toasty.LENGTH_SHORT, true).show();
    }

    public static void Error(int msgId) {
        Toasty.error(mContext, mContext.getResources().getString(msgId) + "", Toasty.LENGTH_SHORT, true).show();
    }

    public static void Success(String msg) {
        Toasty.success(mContext, msg, Toasty.LENGTH_SHORT, true).show();
    }

    public static void Success(int msgId) {
        Toasty.success(mContext, mContext.getResources().getString(msgId) + "", Toasty.LENGTH_SHORT, true).show();
    }

    public static void Normal(String msg) {
        Toasty.normal(mContext, msg, Toasty.LENGTH_SHORT).show();
    }

    public static void Normal(int msgId) {
        Toasty.normal(mContext, mContext.getResources().getString(msgId) + "", Toasty.LENGTH_SHORT).show();
    }

    public static void Warning(String msg) {
        Toasty.warning(mContext, msg, Toasty.LENGTH_SHORT, true).show();
    }

    public static void Warning(int msgId) {
        Toasty.warning(mContext, mContext.getResources().getString(msgId)+"" , Toasty.LENGTH_SHORT, true).show();
    }
//    public static void Icon(String msg) {
//        Drawable icon = mContext.getResources().getDrawable(R.drawable.ic_pets_white_48dp);
//        Toasty.normal(mContext, msg, icon).show();
//    }

}

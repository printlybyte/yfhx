package com.lgd.lgd_core.ui.loadingview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lgd.lgd_core.R;
import com.maning.mndialoglibrary.config.MDialogConfig;
import com.maning.mndialoglibrary.utils.MSizeUtils;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by maning on 2017/8/9.
 * 进度Dialog
 */

public class MT {

    private static final String LoadingDefaultMsg = "";

    private static Dialog mDialog;
    private static MDialogConfig mDialogConfig;

    //布局
    private static RelativeLayout dialog_window_background;
    private static RelativeLayout dialog_view_bg;
    private static TextView tv_show;

    static AVLoadingIndicatorView avLoadingIndicatorView;

    private static void initDialog(Context mContext) {
        try {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            View mProgressDialogView = inflater.inflate(R.layout.mn_progress_dialog_layout_costom, null);


            mDialog = new Dialog(mContext, R.style.MNCustomDialog);
            mDialog.setCancelable(false);
            mDialog.setCanceledOnTouchOutside(false);
            mDialog.setContentView(mProgressDialogView);

            //设置整个Dialog的宽高
            WindowManager.LayoutParams layoutParams = mDialog.getWindow().getAttributes();
            layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
            layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
            layoutParams.gravity = Gravity.CENTER;
            mDialog.getWindow().setAttributes(layoutParams);

            //布局相关
            avLoadingIndicatorView = mProgressDialogView.findViewById(R.id.loading_content_avloading);
            avLoadingIndicatorView.show();

            dialog_window_background = (RelativeLayout) mProgressDialogView.findViewById(R.id.dialog_window_background);
            dialog_view_bg = (RelativeLayout) mProgressDialogView.findViewById(R.id.dialog_view_bg);
            tv_show = (TextView) mProgressDialogView.findViewById(R.id.tv_show);

            configView(mContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void checkDialogConfig() {
        if (mDialogConfig == null) {
            mDialogConfig = new MDialogConfig.Builder().build();
        }
    }

    private static void configView(Context mContext) {
        checkDialogConfig();
        try {
            //设置动画
            if (mDialogConfig != null && mDialogConfig.animationID != 0 && mDialog.getWindow() != null) {
                mDialog.getWindow().setWindowAnimations(mDialogConfig.animationID);
            }
        } catch (Exception e) {

        }

        //点击外部可以取消
        mDialog.setCanceledOnTouchOutside(mDialogConfig.canceledOnTouchOutside);
        //返回键取消
        mDialog.setCancelable(mDialogConfig.cancelable);
        //window背景色
        dialog_window_background.setBackgroundColor(mDialogConfig.backgroundWindowColor);
        //弹框背景
        GradientDrawable myGrad = new GradientDrawable();
        myGrad.setColor(mDialogConfig.backgroundViewColor);
        myGrad.setStroke(MSizeUtils.dp2px(mContext, mDialogConfig.strokeWidth), mDialogConfig.strokeColor);
        myGrad.setCornerRadius(MSizeUtils.dp2px(mContext, mDialogConfig.cornerRadius));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            dialog_view_bg.setBackground(myGrad);
        } else {
            dialog_view_bg.setBackgroundDrawable(myGrad);
        }
        dialog_view_bg.setPadding(
                MSizeUtils.dp2px(mContext, mDialogConfig.paddingLeft),
                MSizeUtils.dp2px(mContext, mDialogConfig.paddingTop),
                MSizeUtils.dp2px(mContext, mDialogConfig.paddingRight),
                MSizeUtils.dp2px(mContext, mDialogConfig.paddingBottom)
        );

        //文字颜色设置
        tv_show.setTextColor(mDialogConfig.textColor);
        tv_show.setTextSize(mDialogConfig.textSize);

        //点击事件
        dialog_window_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取消Dialog
                if (mDialogConfig != null && mDialogConfig.canceledOnTouchOutside) {
                    hide();
                }
            }
        });

        //全屏模式
        if (mDialogConfig.windowFullscreen) {
            mDialog.getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    public static void show(Context context) {
        show(context, LoadingDefaultMsg);
    }

    public static void show(Context context, String msg) {
        show(context, msg, null);
    }

    public static void show(Context context, MDialogConfig mDialogConfig) {
        show(context, LoadingDefaultMsg, mDialogConfig);
    }

    public static void show(Context context, String msg, MDialogConfig dialogConfig) {
        try {
            hide();
            //设置配置
            if (dialogConfig == null) {
                dialogConfig = new MDialogConfig.Builder().build();
            }
            mDialogConfig = dialogConfig;

            initDialog(context);
            if (mDialog != null && tv_show != null) {
                if (TextUtils.isEmpty(msg)) {
                    tv_show.setVisibility(View.GONE);
                } else {
                    tv_show.setVisibility(View.VISIBLE);
                    tv_show.setText(msg);
                }
                mDialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hide() {
        try {
            if (mDialog != null && mDialog.isShowing()) {
                //判断是不是有监听
                if (mDialogConfig.onDialogDismissListener != null) {
                    mDialogConfig.onDialogDismissListener.onDismiss();
                    mDialogConfig.onDialogDismissListener = null;
                }
                avLoadingIndicatorView.hide();
                mDialogConfig = null;
                dialog_window_background = null;
                dialog_view_bg = null;
                tv_show = null;
                mDialog.dismiss();
                mDialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isShowing() {
        if (mDialog != null) {
            return mDialog.isShowing();
        }
        return false;
    }

}

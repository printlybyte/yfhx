package com.lgd.lgd_core.base;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.BarUtils;
import com.lgd.lgd_core.R;
import com.lgd.lgd_core.event.ActResultRequest;
import com.lgd.lgd_core.listener.PlaceHolderView;
import com.lgd.lgd_core.ui.utils.ScreenUtilsx;
import com.noober.background.BackgroundLibrary;
import com.tbruyelle.rxpermissions2.RxPermissions;


public abstract class BaseActivity extends SwipeBackActivity {

    //    public final RelativeLayout.LayoutParams mLayoutParams = new RelativeLayout.LayoutParams(
//            RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
    protected RxPermissions mRxPermissions;
    protected PlaceHolderView mPlaceHolderView;
    protected BaseActivity mContext;
    protected FragmentManager mFragmentManager;
    protected TextView mTitle;
    protected LinearLayout mBack;
    protected TextView mTitletBtn;
    protected RelativeLayout mActivbarGroup;
    private static long lastClickTime;
    public ActResultRequest actResultRequest;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // 在 super.onCreate(savedInstanceState) 之前调用该方法
        BackgroundLibrary.inject(this);
        super.onCreate(savedInstanceState);
        // 在界面未初始化之前调用的初始化窗口
        initWidows();
        if (initArgs(getIntent().getExtras())) {
            // 得到界面Id并设置到Activity界面中
            int layId = getContentLayoutId();
            setContentView(layId);
            initSystemBar();
            initBefore();
            initView();
            initData();

        } else {
            finish();
        }
    }


    protected void initWidows() {
        //设置屏幕适配 360为设计图尺寸px/2
        if (ScreenUtilsx.isPortrait()) {
            ScreenUtilsx.adaptScreen4VerticalSlide(this, 360);
        } else {
            ScreenUtilsx.adaptScreen4HorizontalSlide(this, 640);
        }
    }

    public void setIntentFinsh(String msg, int resultCode) {
        Intent intent = new Intent();
        intent.putExtra("JUMP_INTENT_KEY", msg);
        setResult(resultCode, intent);
        finish();
    }

    public void setIntentFinsh(String arg1, String arg2, int resultCode) {
        Intent intent = new Intent();
        intent.putExtra("JUMP_INTENT_KEY", arg1);
        intent.putExtra("JUMP_INTENT_KEY_TWO", arg2);
        setResult(resultCode, intent);
        finish();
    }

    public void setIntentFinsh(int msg, int resultCode) {
        Intent intent = new Intent();
        intent.putExtra("JUMP_INTENT_KEY", msg);
        setResult(resultCode, intent);
        finish();
    }


    /**
     * 通用findViewById,减少重复的类型转换
     *
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    public final <E extends View> E getView(int id) {
        try {
            return (E) findViewById(id);
        } catch (ClassCastException ex) {
            throw ex;
        }
    }

    private void initSystemBar() {
        AppManager.getInstance().addActivity(this); //添加到栈中
    }

//    public void showProgress() {
//        LoadingFragment.getInstance().show(getSupportFragmentManager(), "android");
//    }
//
//    public void dismisProgress() {
//        LoadingFragment.getInstance().dismiss();
//    }

    public void setTitle(String titlemsg) {
        if (mTitle == null) {
            mTitle = findViewById(R.id.main_action_bar_title);
        }
        mTitle.setText(titlemsg + "");
    }

    /**
     * 初始化控件调用之前
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void initBefore() {
        mContext = this;
        ScreenUtilsx.setPortrait(this);
        actResultRequest = new ActResultRequest(this);
        mRxPermissions = new RxPermissions(this);
        mFragmentManager = getSupportFragmentManager();
        mTitle = findViewById(R.id.main_action_bar_title);
        mTitletBtn = findViewById(R.id.include_actionbar_back_btn);
        mActivbarGroup = findViewById(R.id.main_action_bar_group);
        //返回
        mBack = findViewById(R.id.main_action_bar_back);
        mBack.setVisibility(View.VISIBLE);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        BarUtils.setNavBarColor(this, getResources().getColor(R.color.black));

    }
    /**
     * 初始化窗口 在界面为初始化之前调用
     */


    /**
     * 初始化相关参数
     *
     * @param bundle 参数Bundle
     * @return 如果参数正确返回True，错误返回False
     */
    protected boolean initArgs(Bundle bundle) {
        return true;
    }

    /**
     * 得到当前界面的资源文件Id
     *
     * @return 资源文件Id
     */
    protected abstract int getContentLayoutId();

    /**
     * 初始化控件
     */

    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    @Override
    public boolean onSupportNavigateUp() {
        // 当点击界面导航返回时，Finish当前界面
        finish();
        return super.onSupportNavigateUp();
    }

    /**
     * 设置占位布局
     *
     * @param placeHolderView 继承了占位布局规范的View
     */
    public void setPlaceHolderView(PlaceHolderView placeHolderView) {
        this.mPlaceHolderView = placeHolderView;
    }


    /**
     * ============================================
     * 描  述：防止快速点击多次打开activity
     * 包  名：
     * 类  名：BaseActivity
     * 创建人：zhangjiye
     * 创建时间：2019/4/2 9:23
     * ============================================
     **/
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 500) {
            return true;
        }
        lastClickTime = time;
        return false;

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            if (isFastDoubleClick()) {
                return true;
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
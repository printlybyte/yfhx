package com.yinfeng.yfhx;

import android.content.MutableContextWrapper;
import android.util.Log;
import android.webkit.WebView;

import com.lgd.lgd_core.base.BaseApplication;
import com.lgd.lgd_core.ui.utils.LogUS;
import com.tencent.smtt.sdk.QbSdk;
import com.yinfeng.yfhx.ui.utils.BGAGlideImageLoader490;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import cn.bingoogolapple.photopicker.imageloader.BGAImage;
import okhttp3.OkHttpClient;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx
 * 类  名：App
 * 创建人：liuguodong
 * 创建时间：2019/9/2 18:29
 * ============================================
 **/
public class App extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        initOkHttpClient();

        BGAImage.setImageLoader(new BGAGlideImageLoader490());


        /**
         * 说明， WebView 初处初始化耗时 250ms 左右。
         * 提前初始化WebView ，好处可以提升页面初始化速度，减少白屏时间，
         * 坏处，拖慢了App 冷启动速度，如果 WebView 配合 VasSonic 使用，
         * 建议不要在此处提前初始化 WebView 。
         */
        new WebView(new MutableContextWrapper(this));

        initTbs();
    }


    private void initOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }
    private void initTbs() {
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                LogUS.I("x5內核初始化完成的回调:" + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }

        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }
}

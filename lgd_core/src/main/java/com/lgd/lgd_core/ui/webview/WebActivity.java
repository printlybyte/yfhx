package com.lgd.lgd_core.ui.webview;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.lgd.lgd_core.R;
import com.lgd.lgd_core.base.BaseActivity;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class WebActivity extends BaseActivity implements View.OnClickListener {
    private X5WebView mWebView;
    private ViewGroup mViewParent;
    private String mHomeUrl = "https://www.baidu.com";
    private String mHomeFlag = "";

    //    private String mHomeBlog = "";
//private ImageView mActivityMemberManagementShared;
//private TextView mActivityMemberManagementSharedTitle;
//    private ImageButton mActivityMemberManagementBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        try {
            if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 11) {
                getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED, android.view.WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
            }
        } catch (Exception e) {
        }
        init();
    }

    @Override
    protected void initData() {
        mTitletBtn.setVisibility(View.GONE);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWebView != null && mWebView.canGoBack()) {
                mWebView.goBack();
                if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 16)
//                    changGoForwardButton(mWebView);11111
                {
                    return true;
                }
            } else {
                return super.onKeyDown(keyCode, event);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {

        if (mWebView != null) {
            mWebView.destroy();
        }
        super.onDestroy();
    }

    private void init() {

//        Intent intent = getIntent();
//        if (intent != null) {
//            mHomeUrl = intent.getStringExtra("jumpUrl");
//            mHomeFlag = intent.getStringExtra("jumpType");
//            if (!TextUtils.isEmpty(mHomeFlag)) {
//                if (mHomeFlag.equals("historyDetails")) {
//                    mActivityMemberManagementShared.setVisibility(View.GONE);
//                    mActivityMemberManagementSharedTitle.setText("邀请记录详情");
//                }
//            }
////            mHomeBlog = intent.getStringExtra("jumpBlog");
//        }

        mViewParent = (ViewGroup) findViewById(R.id.base_webView);
        mWebView = new X5WebView(this, null);
        mViewParent.addView(mWebView, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.FILL_PARENT));
        mWebView.addJavascriptInterface(new toJavaScriptinterface(), "share");
        mWebView.getSettings().setMixedContentMode(android.webkit.WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                setTitle(view.getTitle() + "");
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsConfirm(WebView arg0, String arg1, String arg2,
                                       JsResult arg3) {
                return super.onJsConfirm(arg0, arg1, arg2, arg3);
            }

            View myVideoView;
            View myNormalView;
            IX5WebChromeClient.CustomViewCallback callback;

            /**
             * 全屏播放配置
             */
            @Override
            public void onShowCustomView(View view,
                                         IX5WebChromeClient.CustomViewCallback customViewCallback) {
                FrameLayout normalView = (FrameLayout) findViewById(R.id.web_filechooser);
                ViewGroup viewGroup = (ViewGroup) normalView.getParent();
                viewGroup.removeView(normalView);
                viewGroup.addView(view);
                myVideoView = view;
                myNormalView = normalView;
                callback = customViewCallback;
            }

            @Override
            public void onHideCustomView() {
                if (callback != null) {
                    callback.onCustomViewHidden();
                    callback = null;
                }
                if (myVideoView != null) {
                    ViewGroup viewGroup = (ViewGroup) myVideoView.getParent();
                    viewGroup.removeView(myVideoView);
                    viewGroup.addView(myNormalView);
                }
            }

            @Override
            public boolean onJsAlert(WebView arg0, String arg1, String arg2, JsResult arg3) {
                /**
                 * 这里写入你自定义的window alert
                 */
                return super.onJsAlert(null, arg1, arg2, arg3);
            }
        });

        mWebView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String arg0, String arg1, String arg2,
                                        String arg3, long arg4) {
                new AlertDialog.Builder(mContext)
                        .setTitle("allow to download？")
                        .setPositiveButton("yes",
                                new DialogInterface.OnClickListener() {
                                    @SuppressLint("WrongConstant")
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(mContext, "fake message: i'll download...", 1000).show();
                                    }
                                })
                        .setNegativeButton("no",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // TODO Auto-generated method stub
                                        Toast.makeText(mContext, "fake message: refuse download...", Toast.LENGTH_SHORT).show();
                                    }
                                })
                        .setOnCancelListener(
                                new DialogInterface.OnCancelListener() {
                                    @Override
                                    public void onCancel(DialogInterface dialog) {
                                        // TODO Auto-generated method stub
                                        Toast.makeText(mContext, "fake message: refuse download...", Toast.LENGTH_SHORT).show();
                                    }
                                }).show();
            }
        });

        WebSettings webSetting = mWebView.getSettings();
        webSetting.setAllowFileAccess(true);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSetting.setSupportZoom(true);
        webSetting.setBuiltInZoomControls(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setSupportMultipleWindows(false);
        // webSetting.setLoadWithOverviewMode(true);
        webSetting.setAppCacheEnabled(true);
        // webSetting.setDatabaseEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setJavaScriptEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
        webSetting.setAppCachePath(this.getDir("appcache", 0).getPath());
        webSetting.setDatabasePath(this.getDir("databases", 0).getPath());
        webSetting.setGeolocationDatabasePath(this.getDir("geolocation", 0).getPath());
        // webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
        // webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
        // webSetting.setPreFectch(true);
        long time = System.currentTimeMillis();


//        //添加请求头

//        final String tokenValue = LattePreference.getCustomAppProfile(ConstantUtils.TOKEN_VALUE);
//
//        final String mUrl = "http://fdt1.bjzztz.com/login/Default?token=" + tokenValue;
//
//        Log.i("qweqweasd", "token :" + token + "   tokenValue: " + tokenValue + "   mUrl:" + mUrl);
//

//        if (!TextUtils.isEmpty(mHomeFlag)) {
//            if (mHomeFlag.equals("h5")) {
//                String id = Hawk.get("msgid", "");
//                String merchantId = Hawk.get("merchantId", "2");
//                String type = "";
//                if (!TextUtils.isEmpty(mHomeBlog)) {
//                    if (mHomeBlog.equals("msg")) {
//                        type = "merMessageRead";
//                    }if (mHomeBlog.equals("notice")) {
//                        type = "merNoticeRead";
//                    }
//                }
//                mHomeUrl2 = "http://192.168.1.11:8088/merchant/" + type + "/page/info?id=" + id + "&merchantId=" + merchantId;
//                String token = Hawk.get("Authorization");
//                final Map<String, String> map = new HashMap<String, String>();
//                map.put("Authorization", token);
//                mWebView.loadUrl(mHomeUrl2, map);
//                Log.i("mHomeUrl2", "" + mHomeUrl2);
//            } else {
//                mWebView.loadUrl(mHomeUrl);
//            }
//        }
        mWebView.loadUrl(mHomeUrl);

        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().sync();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
//            case R.id.activity_member_management_shared:
//                shareMob();
//                break;
//            case R.id.activity_member_management_back:
//                finish();
        }
    }


    /**
     * @author liuguodong
     * @datetime 2018/9/18 16:a11
     * @parmes 分享
     */

    public class toJavaScriptinterface {
        @JavascriptInterface
        public void share() {

        }
    }
}

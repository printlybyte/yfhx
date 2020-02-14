package com.yinfeng.yfhx;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.DefaultWebClient;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebViewClient;
import com.lgd.lgd_core.ui.utils.ITTUtils;
import com.lgd.lgd_core.ui.utils.IntentUtilsConstant;
import com.lgd.lgd_core.ui.utils.LogUS;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.orhanobut.hawk.Hawk;
import com.yinfeng.yfhx.ui.alculation.CalculationActivity;
import com.yinfeng.yfhx.ui.search.SearchActivity;


public class Main2Activity extends AppCompatActivity {

    private LinearLayout mActivityMain2Webview;
    private AgentWeb mAgentWeb;

    private String mHomeUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        Intent intent = getIntent();
        mHomeUrl = intent.getStringExtra(IntentUtilsConstant.INTENT_PARAMS_1);
        initWebview();
        writeData();
        writeDatax();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123) {
            mAgentWeb.getWebCreator().getWebView().loadUrl(mHomeUrl);
        }

    }

    private void initWebview() {
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent((LinearLayout) mActivityMain2Webview, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setWebChromeClient(mWebChromeClient)
                .setWebViewClient(mWebViewClient)
                .createAgentWeb()
                .ready()
                .go(mHomeUrl);

    }

    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            //do you  work
        }
    };
    private WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            //do you work
        }
    };

    private void initView() {
        mActivityMain2Webview = (LinearLayout) findViewById(R.id.activity_main2_webview);

    }

    @Override
    protected void onPause() {

        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }

// @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//
//        if (mAgentWeb.handleKeyEvent(keyCode, event)) {
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }


    /**
     * 登录tocken写入 调用 Javascript 方法
     */
    public void writeData() {
        String key = "token";
        String val = Hawk.get(Apc.Apc_token);
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
//            mWebView.evaluateJavascript("window.localStorage.setItem('" + key + "','" + val + "');", null);
//        } else {
//            mWebView.loadUrl("javascript:localStorage.setItem('" + key + "','" + val + "');");
//        }
        mAgentWeb.getJsAccessEntrace().quickCallJs("window.localStorage.setItem('" + key + "','" + val + "');");
        LogUS.I("==========" + val);

    }

    /**
     * Javascript 调 Java
     */
    public void writeDatax() {
        mAgentWeb.getJsInterfaceHolder().addJavaObject("jsAndroid", new AndroidInterface(mAgentWeb, this));

    }

    public class AndroidInterface {
        public AndroidInterface(AgentWeb mAgentWeb, Main2Activity main2Activity) {
        }

        @JavascriptInterface
        public void seckill(String rec_type) {

            Intent intent = new Intent(Main2Activity.this, CalculationActivity.class);
            intent.putExtra(IntentUtilsConstant.INTENT_PARAMS_1,"6");
            startActivityForResult(intent, 123);

//            ITTUtils.Jump(CalculationActivity.class, rec_type);
//            ToastUS.Normal("seckill" + rec_type);
        }

        @JavascriptInterface
        public void navigate(String navigate) {
            if (!TextUtils.isEmpty(navigate)) {
                if (navigate.equals("cart")) {

                } else if (navigate.equals("home")) {

                } else if (navigate.equals("search")) {

                    Intent intent = new Intent(Main2Activity.this, SearchActivity.class);
                    startActivityForResult(intent, 123);

                } else if (navigate.equals("catalog")) {


                } else if (navigate.equals("user")) {

                }
            }

            ToastUS.Normal("navigate" + navigate);
        }

        @JavascriptInterface
        public void shopstore(String shop_id) {
            ToastUS.Normal(shop_id);
        }


    }

}

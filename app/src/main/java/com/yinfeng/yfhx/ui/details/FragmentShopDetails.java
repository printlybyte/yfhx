package com.yinfeng.yfhx.ui.details;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.lgd.lgd_core.base.BaseFragment;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.ui.webview.MyWebView;

import java.util.ArrayList;

/**
 * ============================================
 * 描  述：FragmentShopDetails商品详情 web
 * 包  名：com.yinfeng.yfhx.fragments.home
 * 类  名：GeneralPurposeFragment
 * 创建人：liuguodong
 * 创建时间：2019/9/20 15:39
 * ============================================
 **/
public class FragmentShopDetails extends BaseFragment implements MyWebView.MyWebViewListener{
    private MyWebView mWebView;
    private String content;
    private static  String html_S;

    public static FragmentShopDetails newInstance(String html) {
        html_S=html;
        Bundle args = new Bundle();
        FragmentShopDetails generalPurposeFragment = new FragmentShopDetails();
        generalPurposeFragment.setArguments(args);
        return generalPurposeFragment;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_shop_details;
    }

    @Override
    protected void initView(View view) {
        mWebView = view.findViewById(R.id.mWebView);
//        content = getArguments().getString(ServiceOptionDetailActivity.KEY_HTML_DATA);

        mWebView.setMyWebViewListener(this);
        content=html_S;
        Log.i("testre",""+content);
//        content="<div class=\"section s-img\"><div class=\"img\"><img src=\"http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/gallery_album/0/original_img/0_P_1559668016853.jpg\"></div></div>";
        mWebView.setHtmlContent(content, 0, 0);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onDestroy() {
        clearWebViewResource(mWebView);
        super.onDestroy();
    }

    public void clearWebViewResource(WebView webView) {
        if (webView != null) {
            webView.loadUrl("about:blank");
            webView.freeMemory();
            webView.pauseTimers();
            webView.removeAllViews();
            // in android 5.1(sdk:21) we should invoke this to avoid memory leak
            // see (https://coolpers.github.io/webview/memory/leak/2015/07/16/
            // android-5.1-webview-memory-leak.html)
            ((ViewGroup) webView.getParent()).removeView(webView);
            webView.setTag(null);
            webView.clearHistory();
            webView.clearCache(true);
            webView.destroy();
            webView = null;
        }
    }

    @Override
    public void pageFinished(WebView view, String tag, String url, ArrayList<String> imgList) {

    }

    @Override
    public void jsImgClick(String img, int position, ArrayList<String> imgList) {

    }

    @Override
    public void overrideUrlLoading(String url) {

    }
}

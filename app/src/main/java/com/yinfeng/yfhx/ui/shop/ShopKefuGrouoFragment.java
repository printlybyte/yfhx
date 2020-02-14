package com.yinfeng.yfhx.ui.shop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.lgd.lgd_core.base.BaseFragment;
import com.yinfeng.yfhx.R;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.ui.shop
 * 类  名：ShopKefuGrouoFragment
 * 创建人：liuguodong
 * 创建时间：2019/12/16 16:27
 * ============================================
 **/
public class ShopKefuGrouoFragment extends BaseFragment {
    private static String mRu_id = "";
    private WebView mFragmentShopGroupKefuWeb;

    public static ShopKefuGrouoFragment newInstance(String ru_id) {
        Bundle args = new Bundle();
        mRu_id = ru_id;
        ShopKefuGrouoFragment generalPurposeFragment = new ShopKefuGrouoFragment();
        generalPurposeFragment.setArguments(args);
        return generalPurposeFragment;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_shop_group_kefu;
    }

    private String murl="https://www.sobot.com/chat/h5/index.html?sysNum=962ec7bf5cc84b849bb68546a2221acd&source=1";
    @Override
    protected void initView(View view) {

        mFragmentShopGroupKefuWeb = (WebView) view.findViewById(R.id.fragment_shop_group_kefu_web);
        mFragmentShopGroupKefuWeb.loadUrl(murl);
    }

    @Override
    protected void initData() {

    }



}

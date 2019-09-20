package com.lgd.lgd_core.ui.utils;

import android.view.View;
import android.widget.ImageView;

import com.lgd.lgd_core.entity.XBannerImageBean;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.lgd.lgd_core.ui.utils
 * 类  名：XbannerUtils
 * 创建人：liuguodong
 * 创建时间：2019/9/6 17:46
 * ============================================
 **/
public class XbannerUtils {
    private XbannerUtils() {
    }

    private static class getInstance {
        private static XbannerUtils INSTANCE = new XbannerUtils();
    }

    public static XbannerUtils getIns() {
        return XbannerUtils.getInstance.INSTANCE;
    }

    public void setXbanner(XBanner mBanner,List<XBannerImageBean> data ) {
        if (mBanner == null) {
            ToastUS.Error("xbanner null");
            return;
        }  if (data == null) {
            ToastUS.Error("xbanner data null");
            return;
        }
        //加载广告图片
        mBanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                //在此处使用图片加载框架加载图片，demo中使用glide加载，可替换成自己项目中的图片加载框架
                GlideUS.loadPhoto(((XBannerImageBean) model).getPath(), (ImageView) view);
            }
        });

        mBanner.setAutoPlayAble(data.size() > 1);
        mBanner.setIsClipChildrenMode(true);
        //老方法，不推荐使用
        mBanner.setBannerData(data);
    }
}

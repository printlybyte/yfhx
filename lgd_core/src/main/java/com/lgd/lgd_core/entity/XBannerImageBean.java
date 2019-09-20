package com.lgd.lgd_core.entity;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity
 * 类  名：XBannerImageBean
 * 创建人：liuguodong
 * 创建时间：2019/9/6 14:19
 * ============================================
 **/
public class XBannerImageBean extends SimpleBannerInfo {
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    @Override
    public Object getXBannerUrl() {
        return getPath();
    }
}

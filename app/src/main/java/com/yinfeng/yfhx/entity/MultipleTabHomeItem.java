package com.yinfeng.yfhx.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * 首页多条目
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class MultipleTabHomeItem implements MultiItemEntity {
//    public static final int ads = 101;
    public static final int banners = 102;
//    public static final int categories = 103;
//    public static final int hdlist = 104;
//    public static final int navs = 105;
//    public static final int newgoods = 106;
//    public static final int noticelist = 107;
//    public static final int seckills = 108;
//    public static final int stores = 109;
//    public static final int topic = 110;
public static final int TEXT_SPAN_SIZE = 3;

    private int itemType;
    private int spanSize;

    public MultipleTabHomeItem(int itemType, int spanSize, TabFragment1Bean content) {
        this.itemType = itemType;
        this.spanSize = spanSize;
        this.bean = content;
    }

    public MultipleTabHomeItem(int itemType, int spanSize) {
        this.itemType = itemType;
        this.spanSize = spanSize;
    }

    public int getSpanSize() {
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    public TabFragment1Bean getBean() {
        return bean;
    }

    public void setBean(TabFragment1Bean bean) {
        this.bean = bean;
    }

    private TabFragment1Bean bean;


    @Override
    public int getItemType() {
        return itemType;
    }
}

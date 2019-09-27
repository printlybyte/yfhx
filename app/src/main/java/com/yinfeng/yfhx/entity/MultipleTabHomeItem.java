package com.yinfeng.yfhx.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * 首页多条目
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class MultipleTabHomeItem<T> implements MultiItemEntity {
        public static final int ads = 101;
    public static final int banners = 102;
        public static final int categories = 103;
//    public static final int hdlist = 104;
    public static final int navs = 110;
        public static final int newgoods = 106;
    public static final int noticelist = 107;
    public static final int seckills = 108;
    public static final int stores = 109;
    public static final int topic = 105;
    public static final int TEXT_SPAN_SIZE = 10;

    private int itemType;
    private int spanSize;

    public MultipleTabHomeItem(int itemType, int spanSize, List<T> content) {
        this.itemType = itemType;
        this.spanSize = spanSize;
        this.bean = content;
    }

    public   MultipleTabHomeItem(int itemType, int spanSize) {
        this.itemType = itemType;
        this.spanSize = spanSize;
    }

    public int getSpanSize() {
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    public List<T> getBean() {
        return bean;
    }

    public void setBean(List<T> bean) {
        this.bean = bean;
    }

    private List<T> bean;


    @Override
    public int getItemType() {
        return itemType;
    }
}

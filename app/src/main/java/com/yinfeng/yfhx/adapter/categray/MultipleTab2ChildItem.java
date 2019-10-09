package com.yinfeng.yfhx.adapter.categray;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class MultipleTab2ChildItem<T> implements MultiItemEntity {
    public static final int header = 201;
    public static final int contents = 202;
    public static final int TEXT_SPAN_SIZE = 10;

    private int itemType;
    private int spanSize;

    public MultipleTab2ChildItem(int itemType, int spanSize, List<T> content) {
        this.itemType = itemType;
        this.spanSize = spanSize;
        this.bean = content;
    }



    public MultipleTab2ChildItem(int itemType, int spanSize) {
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

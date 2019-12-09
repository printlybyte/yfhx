package com.yinfeng.yfhx.ui.me.coupon;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.yinfeng.yfhx.adapter.me.MeCouponAdapter;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.ui.me.coupon
 * 类  名：FoldLevel1
 * 创建人：liuguodong
 * 创建时间：2019/10/16 14:17
 * ============================================
 **/
public class FoldLevel2 extends AbstractExpandableItem<Person> implements MultiItemEntity {
    private String store_name;

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    @Override
    public int getItemType() {
        return MeCouponAdapter.TYPE_LEVEL_1;
    }

    @Override
    public int getLevel() {
        return 0;
    }
}

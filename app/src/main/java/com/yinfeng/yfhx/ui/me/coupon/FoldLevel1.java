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
public class FoldLevel1 extends AbstractExpandableItem<FoldLevel2> implements MultiItemEntity {
    private String cou_name;
    private int cou_start_time;
    private int cou_end_time;
    private String cou_type_name;

    public String getCou_money() {
        return cou_money;
    }

    public void setCou_money(String cou_money) {
        this.cou_money = cou_money;
    }

    private String cou_money;

    public String getCou_name() {
        return cou_name;
    }

    public void setCou_name(String cou_name) {
        this.cou_name = cou_name;
    }

    public int getCou_start_time() {
        return cou_start_time;
    }

    public void setCou_start_time(int cou_start_time) {
        this.cou_start_time = cou_start_time;
    }

    public int getCou_end_time() {
        return cou_end_time;
    }

    public void setCou_end_time(int cou_end_time) {
        this.cou_end_time = cou_end_time;
    }

    public String getCou_type_name() {
        return cou_type_name;
    }

    public void setCou_type_name(String cou_type_name) {
        this.cou_type_name = cou_type_name;
    }

    @Override
    public int getItemType() {
        return MeCouponAdapter.TYPE_LEVEL_0;
    }

    @Override
    public int getLevel() {
        return 0;
    }
}

package com.yinfeng.yfhx.entity.t3;

import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity
 * 类  名：Tab_3_FragmentBean
 * 创建人：liuguodong
 * 创建时间：2019/10/17 14:21
 * ============================================
 **/
public class T3_HeaderBean {
    private String store_name;
    private int store_id;
    private boolean checked;
    private int coupuns_num;
    private int user_id;

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getCoupuns_num() {
        return coupuns_num;
    }

    public void setCoupuns_num(int coupuns_num) {
        this.coupuns_num = coupuns_num;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
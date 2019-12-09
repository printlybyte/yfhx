package com.yinfeng.yfhx.entity.t3;

import com.chad.library.adapter.base.entity.SectionEntity;

import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class T3_Section extends SectionEntity<T3_ContentsBean> {
    private boolean isMore;


    public T3_Section(boolean isHeader, String header, boolean isMroe) {
        super(isHeader, header);
        this.isMore = isMroe;
    }

    public T3_Section(T3_ContentsBean t) {
        super(t);
    }


    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean mroe) {
        isMore = mroe;
    }


    private String store_name;
    private int store_id;
    private boolean checked;
    private int coupuns_num;
    private int user_id;

    private int tag=0;

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public List<Tab_3_FragmentBean.DataBean.GoodsBean> getList() {
        return list;
    }

    public void setList(List<Tab_3_FragmentBean.DataBean.GoodsBean> list) {
        this.list = list;
    }

    private List<Tab_3_FragmentBean.DataBean.GoodsBean> list;



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

package com.yinfeng.yfhx.adapter.me;

import android.support.annotation.NonNull;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.event.Latte;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.me.SaveCardNotFragmentBean;

import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.adapter.me
 * 类  名：MeInvoiceAdapter
 * 创建人：liuguodong
 * 创建时间：2019/10/12 10:54
 * ============================================
 **/

public class MeRedPackNotAdapter extends BaseQuickAdapter<SaveCardNotFragmentBean.DataBean.UnableBean, MeRedPackNotAdapter.MyHolder> {

    public MeRedPackNotAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(@NonNull MeRedPackNotAdapter.MyHolder helper, SaveCardNotFragmentBean.DataBean.UnableBean item) {

        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.ri_me_redpack_item_vc_value, item.getVc_value() == "" ? tipStr : "面值："+item.getVc_value());
        helper.setText(R.id.ri_me_redpack_item_bind_time, item.getBind_time() == "" ? tipStr : "发放时间：" + item.getBind_time());
        helper.setText(R.id.ri_me_redpack_item_end_time, item.getBind_time() == "" ? tipStr : "过期时间：" + item.getEnd_time());
        helper.setText(R.id.ri_me_redpack_item_card_money, item.getCard_money() == "" ? tipStr : "余额: " + item.getCard_money());


        if (item.isStatus()) {
            helper.setText(R.id.ri_me_redpack_item_invalid, "未过期");
        } else {
            helper.setText(R.id.ri_me_redpack_item_invalid, "已过期");
        }


    }

    class MyHolder extends BaseViewHolder {
        public MyHolder(View view) {
            super(view);
        }
    }
}

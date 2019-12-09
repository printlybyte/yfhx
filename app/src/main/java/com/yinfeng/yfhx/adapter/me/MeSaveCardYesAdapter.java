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

public class MeSaveCardYesAdapter extends BaseQuickAdapter<SaveCardNotFragmentBean.DataBean.EnbaleBean, MeSaveCardYesAdapter.MyHolder> {

    public MeSaveCardYesAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(@NonNull MeSaveCardYesAdapter.MyHolder helper, SaveCardNotFragmentBean.DataBean.EnbaleBean item) {
        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.ri_me_save_card_not_item_vc_value, item.getVc_value() == "" ? tipStr :"面值："+ item.getVc_value());
        helper.setText(R.id.ri_me_save_card_not_item_cardtype, item.getName() == "" ? tipStr : item.getName());
        helper.setText(R.id.ri_me_save_card_not_item_time, item.getBind_time() == "" ? tipStr : item.getBind_time() + "--" + item.getEnd_time());
        helper.setText(R.id.ri_me_save_card_not_item_cardsn, item.getValue_card_sn() == "" ? tipStr : "NO: "+item.getValue_card_sn());
        helper.setText(R.id.ri_me_save_card_not_item_card_money, item.getCard_money() == "" ? tipStr :"余额：" +item.getCard_money());



        if (item.isStatus()) {
            helper.setText(R.id.ri_me_save_card_not_item_invalid, "未过期");
        } else {
            helper.setText(R.id.ri_me_save_card_not_item_invalid, "已过期");
        }


    }

    class MyHolder extends BaseViewHolder {
        public MyHolder(View view) {
            super(view);
        }
    }
}

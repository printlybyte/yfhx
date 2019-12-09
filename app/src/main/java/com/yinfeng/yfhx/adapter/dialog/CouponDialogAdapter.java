package com.yinfeng.yfhx.adapter.dialog;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.event.Latte;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.BottomCouponDialogBean;
import com.yinfeng.yfhx.entity.TabFragment2Bean_Group;

import java.util.List;

/**
 * ============================================
 * 描  述：优惠券
 * 包  名：com.yinfeng.yfhx.fragments.adapter
 * 类  名：NavAdapter
 * 创建人：liuguodong
 * 创建时间：2019/9/24 17:42
 * ============================================
 **/
public class CouponDialogAdapter extends BaseQuickAdapter<BottomCouponDialogBean.DataBean, CouponDialogAdapter.MyHolder> {

    public CouponDialogAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(@NonNull MyHolder helper, BottomCouponDialogBean.DataBean item) {

//        GlideUS.loadPhoto(item.getPic(), helper.imageView);
        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.df_bottom_coupon_item_cou_money, item.getCou_money() == "" ? tipStr : item.getCou_money());
        helper.setText(R.id.df_bottom_coupon_item_cou_name, item.getCou_name() + "" == "" ? tipStr : item.getCou_name() + "");
        helper.setText(R.id.df_bottom_coupon_item_cou_title, item.getCou_title() + "" == "" ? tipStr : item.getCou_title() + "");
        helper.setText(R.id.df_bottom_coupon_item_cou_time, item.getCou_name() + "" == "" ? tipStr : item.getCou_add_time() + " - " + item.getCou_end_time());
        helper.addOnClickListener(R.id.df_bottom_coupon_item_group);
        helper.addOnClickListener(R.id.df_bottom_coupon_item_btn);


    }

    class MyHolder extends BaseViewHolder {
        public MyHolder(View view) {
            super(view);
        }
    }
}

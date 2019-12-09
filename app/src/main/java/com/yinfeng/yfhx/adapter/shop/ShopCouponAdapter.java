package com.yinfeng.yfhx.adapter.shop;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GlideUS;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.shop.ShopCategrayFragmentBean;
import com.yinfeng.yfhx.entity.shop.ShopCouponFragmentBean;

import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.fragments.adapter
 * 类  名：NavAdapter
 * 创建人：liuguodong
 * 创建时间：2019/9/24 17:42
 * ============================================
 **/
public class ShopCouponAdapter extends BaseQuickAdapter<ShopCouponFragmentBean.DataBean, ShopCouponAdapter.MyHolder> {

    public ShopCouponAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(@NonNull MyHolder helper, ShopCouponFragmentBean.DataBean item) {

        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.ri_shop_coupon_item_cou_money, item.getCou_money() == "" ? tipStr : item.getCou_money());
        helper.setText(R.id.ri_shop_coupon_item_cou_name, item.getCou_name() + "" == "" ? tipStr : item.getCou_name() + "");
        helper.setText(R.id.ri_shop_coupon_item_cou_type_name, item.getCou_type_name() + "" == "" ? tipStr : item.getCou_type_name() + "");
        helper.setText(R.id.ri_shop_coupon_item_cou_time, item.getCou_name() + "" == "" ? tipStr : item.getCou_add_time() + " - " + item.getCou_end_time());
        helper.addOnClickListener(R.id.ri_shop_coupon_item_group);

    }

    class MyHolder extends BaseViewHolder {

        public MyHolder(View view) {
            super(view);
        }
    }
}

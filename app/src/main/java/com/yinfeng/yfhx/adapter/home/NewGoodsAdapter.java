package com.yinfeng.yfhx.adapter.home;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GlideUS;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.TabFragment1Bean;

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
public class NewGoodsAdapter extends BaseQuickAdapter<TabFragment1Bean.DataBean.NewgoodsBean, NewGoodsAdapter.MyHolder> {

    public NewGoodsAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(@NonNull MyHolder helper, TabFragment1Bean.DataBean.NewgoodsBean item) {

        GlideUS.loadPhoto(item.getGoods_img(), helper.imageView_logo);

        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.ri_home_newgoods_item_name, item.getGoods_name() == "" ? tipStr : item.getGoods_name());
        helper.setText(R.id.ri_home_newgoods_item_price, item.getShop_price() == "" ? tipStr : "￥ " + item.getShop_price());
        helper.setText(R.id.ri_home_newgoods_item_price_old, item.getMarket_price() == "" ? tipStr : "￥ " + item.getMarket_price());
        helper.setText(R.id.ri_home_newgoods_item_buy_nums, item.getSales_volume() + "" == "" ? tipStr : item.getSales_volume() + "人购买");
        helper.textView_price_old.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
        helper.addOnClickListener(R.id.ri_home_newgoods_item_group);
        helper.addOnClickListener(R.id.ri_home_newgoods_item_add_shop);
    }

    class MyHolder extends BaseViewHolder {
        ImageView imageView_logo;
        TextView textView_price_old;

        public MyHolder(View view) {
            super(view);
            imageView_logo = view.findViewById(R.id.ri_home_newgoods_item_header);
            textView_price_old = view.findViewById(R.id.ri_home_newgoods_item_price_old);
        }
    }
}

package com.yinfeng.yfhx.adapter.home;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

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
public class StoresAdapter extends BaseQuickAdapter<TabFragment1Bean.StoresBean, StoresAdapter.MyHolder> {

    public StoresAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(@NonNull MyHolder helper, TabFragment1Bean.StoresBean item) {

        GlideUS.loadPhoto(item.getShop_logo(), helper.imageView_logo);
        GlideUS.loadPhoto(item.getGoods().get(0).getGoods_img(), helper.imageView_mark1);
        GlideUS.loadPhoto(item.getGoods().get(1).getGoods_img(), helper.imageView_mark2);
        GlideUS.loadPhoto(item.getGoods().get(2).getGoods_img(), helper.imageView_mark3);
        GlideUS.loadPhoto(item.getShop_logo(), helper.imageView_logo);

        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.ri_home_stores_item_shop_name, item.getShop_name() == "" ? tipStr : item.getShop_name());

        String markName1 = item.getGoods().get(0).getGoods_name();
        String markName2 = item.getGoods().get(1).getGoods_name();
        String markName3 = item.getGoods().get(2).getGoods_name();
        String markPrice1 = "￥" + item.getGoods().get(0).getShop_price();
        String markPrice2 = "￥" + item.getGoods().get(1).getShop_price();
        String markPrice3 = "￥" + item.getGoods().get(2).getShop_price();
        helper.setText(R.id.ri_home_stores_item_mark_name1, markName1 == "" ? tipStr : markName1);
        helper.setText(R.id.ri_home_stores_item_mark_name2, markName1 == "" ? tipStr : markName2);
        helper.setText(R.id.ri_home_stores_item_mark_name3, markName1 == "" ? tipStr : markName3);
        helper.setText(R.id.ri_home_stores_item_mark_peice1, markName1 == "" ? tipStr : markPrice1);
        helper.setText(R.id.ri_home_stores_item_mark_price2, markName1 == "" ? tipStr : markPrice2);
        helper.setText(R.id.ri_home_stores_item_mark_price3, markName1 == "" ? tipStr : markPrice3);

        helper.addOnClickListener(R.id.ri_home_stores_item_mark_group1);
        helper.addOnClickListener(R.id.ri_home_stores_item_mark_group2);
        helper.addOnClickListener(R.id.ri_home_stores_item_mark_group3);
        helper.addOnClickListener(R.id.ri_home_stores_item_group);

    }

    class MyHolder extends BaseViewHolder {
        ImageView imageView_logo, imageView_mark1, imageView_mark2, imageView_mark3;
        LinearLayout linearLayout_title_group;

        public MyHolder(View view) {
            super(view);
            imageView_logo = view.findViewById(R.id.ri_home_stores_item_shop_icon);
            imageView_mark1 = view.findViewById(R.id.ri_home_stores_item_mark_img1);
            imageView_mark2 = view.findViewById(R.id.ri_home_stores_item_mark_img2);
            imageView_mark3 = view.findViewById(R.id.ri_home_stores_item_mark_img3);
            linearLayout_title_group = view.findViewById(R.id.ri_home_stores_item_title_group);
        }
    }
}

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
public class ShopFeaturedAdapter extends BaseQuickAdapter<ShopCategrayFragmentBean.DataBean, ShopFeaturedAdapter.MyHolder> {

    public ShopFeaturedAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(@NonNull MyHolder helper, ShopCategrayFragmentBean.DataBean item) {

        GlideUS.loadPhoto(item.getGoods_img(), helper.imageView);
        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.ri_shop_featured_item_title, item.getGoods_name() == "" ? tipStr : item.getGoods_name());
        helper.setText(R.id.ri_shop_featured_item_price, item.getShop_price_formated()+"" == "" ? tipStr : item.getShop_price_formated()+"");
        helper.addOnClickListener(R.id.ri_shop_featured_item_group);

    }

    class MyHolder extends BaseViewHolder {
        ImageView imageView;

        public MyHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.ri_shop_featured_item_img);
        }
    }
}

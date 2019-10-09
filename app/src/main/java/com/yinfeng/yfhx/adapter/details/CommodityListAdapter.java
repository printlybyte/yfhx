package com.yinfeng.yfhx.adapter.details;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GlideUS;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.CommodityListActivityBean;
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
public class CommodityListAdapter extends BaseQuickAdapter<CommodityListActivityBean.DataBean, CommodityListAdapter.MyHolder> {

    public CommodityListAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(@NonNull MyHolder helper, CommodityListActivityBean.DataBean item) {

        GlideUS.loadPhoto(item.getGoods_img(), helper.imageView);
        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.ri_details_commodilylist_item_title, item.getGoods_bill_name() == "" ? tipStr : item.getGoods_bill_name());
        helper.setText(R.id.ri_details_commodilylist_item_price, item.getMarket_price() == "" ? tipStr : item.getMarket_price());
        helper.setText(R.id.ri_details_commodilylist_item_sales_volume, item.getSales_volume() + "" == "" ? tipStr : item.getSales_volume() + "人已购买");
        helper.addOnClickListener(R.id.ri_details_commodilylist_item_group);
        helper.addOnClickListener(R.id.ri_details_commodilylist_item_add_shop);

    }

    class MyHolder extends BaseViewHolder {
        ImageView imageView;

        public MyHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.ri_details_commodilylist_item_img);
        }
    }
}

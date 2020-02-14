package com.yinfeng.yfhx.adapter.home;

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
public class SeckillsAdapter extends BaseQuickAdapter<TabFragment1Bean.DataBean.SeckillsBean, SeckillsAdapter.MyHolder> {

    public SeckillsAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(@NonNull MyHolder helper, TabFragment1Bean.DataBean.SeckillsBean item) {

        GlideUS.loadPhoto(item.getGoods_thumb(), helper.imageView);
        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.item_fragment_tab1_seckills_item_price, item.getSec_price_formated() == "" ? tipStr : item.getSec_price_formated());
        helper.setText(R.id.item_fragment_tab1_seckills_item_price_old, item.getMarket_price_formated() == "" ? tipStr : item.getMarket_price_formated());
        helper.addOnClickListener(R.id.item_fragment_tab1_seckills_item_group1);

    }

    class MyHolder extends BaseViewHolder {
        ImageView imageView;

        public MyHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.item_fragment_tab1_seckills_item_img1);
        }
    }
}

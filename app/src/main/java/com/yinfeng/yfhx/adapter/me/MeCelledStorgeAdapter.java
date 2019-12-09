package com.yinfeng.yfhx.adapter.me;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GlideUS;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.me.MeCelledGoodsActivityBean;
import com.yinfeng.yfhx.entity.me.MeCelledStorgeActivityBean;

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

public class MeCelledStorgeAdapter extends BaseQuickAdapter<MeCelledStorgeActivityBean.DataBean, MeCelledStorgeAdapter.MyHolder> {

    public MeCelledStorgeAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(@NonNull MeCelledStorgeAdapter.MyHolder helper, MeCelledStorgeActivityBean.DataBean item) {

        GlideUS.loadPhoto(item.getShop_logo(), helper.imageView);
        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.ri_me_celled_storge_item_shop_name, item.getStore_name() == "" ? tipStr : item.getStore_name());
        helper.setText(R.id.ri_me_celled_storge_item_area_link, item.getCount_store() + "" == "" ? tipStr : "" + item.getCount_store() + "人关注");
        helper.addOnClickListener(R.id.ri_me_celled_storge_item_group);
        helper.addOnClickListener(R.id.ri_me_celled_storge_item_attention);




    }

    class MyHolder extends BaseViewHolder {
        ImageView imageView;
        ImageView imageView_attention;

        public MyHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.ri_me_celled_storge_item_shop_logo);
            imageView_attention = view.findViewById(R.id.ri_me_celled_storge_item_attention);
        }
    }
}

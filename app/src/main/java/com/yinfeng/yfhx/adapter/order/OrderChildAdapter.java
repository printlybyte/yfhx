package com.yinfeng.yfhx.adapter.order;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GlideUS;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.CalculationActivityBean;
import com.yinfeng.yfhx.entity.order.OrderActivityBean;

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

public class OrderChildAdapter extends BaseQuickAdapter<OrderActivityBean.DataBean.ListBean.OrderGoodsBean, OrderChildAdapter.MyHolder> {

    public OrderChildAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(@NonNull OrderChildAdapter.MyHolder helper, OrderActivityBean.DataBean.ListBean.OrderGoodsBean item) {

        GlideUS.loadPhoto(item.getGoods_thumb(), helper.imageView);
        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.ri_order_child_item_goods_name, item.getGoods_name() == "" ? tipStr : item.getGoods_name());
        helper.setText(R.id.ri_order_child_item_goods_nums, item.getGoods_id()+"" == "" ? tipStr : "x"+item.getGoods_id());


        helper.addOnClickListener(R.id.ri_order_child_item_group);

    }

    class MyHolder extends BaseViewHolder {
        ImageView imageView;

        public MyHolder(View view) {
            super(view);
            imageView=   view.findViewById(R.id.ri_order_child_item_goods_img);
        }
    }
}

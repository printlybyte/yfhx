package com.yinfeng.yfhx.adapter.me;

import android.support.annotation.NonNull;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.ui.me.coupon.FoldLevel2;
import com.yinfeng.yfhx.ui.me.coupon.FoldLevel1;

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

public class MeCouponAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;

    public MeCouponAdapter(List<MultiItemEntity> data, int type) {
        super(data);

        if (type == 0) {
            addItemType(TYPE_LEVEL_0, R.layout.expand_coupon_not_group);
            addItemType(TYPE_LEVEL_1, R.layout.expand_coupon_not_child);
        } else if (type == 1) {
            addItemType(TYPE_LEVEL_0, R.layout.expand_coupon_yes_group);
            addItemType(TYPE_LEVEL_1, R.layout.expand_coupon_yes_child);
        }else if (type == 2) {
            addItemType(TYPE_LEVEL_0, R.layout.expand_coupon_lost_group);
            addItemType(TYPE_LEVEL_1, R.layout.expand_coupon_lost_child);
        }
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, MultiItemEntity item) {
        switch (holder.getItemViewType()) {
            case TYPE_LEVEL_0:
                final FoldLevel1 lv0 = (FoldLevel1) item;
                holder.setText(R.id.expand_coupon_not_group_price, "￥" + lv0.getCou_money())
                        .setText(R.id.expand_coupon_not_group_cou_name, lv0.getCou_name())
                        .setText(R.id.expand_coupon_not_group_cou_type_name, lv0.getCou_type_name())
                        .setText(R.id.expand_coupon_not_group_time, lv0.getCou_start_time() + "至" + lv0.getCou_end_time())
                        .setImageResource(R.id.expand_coupon_not_group_downg, lv0.isExpanded() ? R.mipmap.ic_jiantou_top_write : R.mipmap.ic_jiantou_down_write);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getAdapterPosition();
                        if (lv0.isExpanded()) {
                            collapse(pos);
                        } else {
                            expand(pos);
                        }
                    }
                });
                break;
            case TYPE_LEVEL_1:
                final FoldLevel2 lv1 = (FoldLevel2) item;
                holder.setText(R.id.expand_coupon_not_child_txt, lv1.getStore_name());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getAdapterPosition();
                        if (lv1.isExpanded()) {
                            collapse(pos);
                        } else {
                            expand(pos);
                        }
                    }
                });
                break;
        }
//    @Override
////    protected void convert(final BaseViewHolder holder, final MultiItemEntity item) {
////        switch (holder.getItemViewType()) {}
////    @Override
////    protected void convert(@NonNull MeCouponAdapter.MyHolder helper, CouponNotFragmentBean.DataBean item) {
////
//////        GlideUS.loadPhoto(item.getPic(), helper.imageView);
////        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
////        helper.setText(R.id.ri_me_meaddress_item_name, item.getName() == "" ? tipStr : item.getName());
//////        helper.setText(R.id.ri_me_meinvoice_type, item.getAdd_time() == "" ? tipStr : item.getTitle());
////        helper.setText(R.id.ri_me_meaddress_item_details, item.getAddress() == "" ? tipStr : item.getAddress());
////        helper.addOnClickListener(R.id.ri_me_meaddress_item_checkbox);
////        helper.addOnClickListener(R.id.ri_me_meaddress_item_delete);
////
////    }

        class MyHolder extends BaseViewHolder {
            public MyHolder(View view) {
                super(view);
            }
        }
////
    }
}

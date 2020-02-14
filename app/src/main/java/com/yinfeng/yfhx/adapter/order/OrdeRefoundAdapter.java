package com.yinfeng.yfhx.adapter.order;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.CommonUtils;
import com.lgd.lgd_core.ui.utils.GlideUS;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.order.OrderRefoundActivityBean;
import com.yinfeng.yfhx.ui.utils.OrderUtils;

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
public class OrdeRefoundAdapter extends BaseQuickAdapter<OrderRefoundActivityBean.DataBean, OrdeRefoundAdapter.MyHolder> {


    private Context context = Latte.getApplicationContext();

    public OrdeRefoundAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    @Override
    protected void convert(@NonNull MyHolder helper, OrderRefoundActivityBean.DataBean item) {

        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.ri_refound_item_order_sn, item.getOrder_sn() == "" ? tipStr : "" + item.getOrder_sn());
        helper.setText(R.id.ri_refound_item_order_time, item.getApply_time() == "" ? tipStr : "申请时间：" + item.getApply_time());

        helper.setText(R.id.ri_refound_item_goods_name, item.getGoods_name() == "" ? tipStr : "" + item.getGoods_name());


        helper.setText(R.id.ri_refound_item_attr, item.getGoods_attr() == "" ? tipStr : "" + item.getGoods_attr());


        GlideUS.loadPhoto(item.getGoods_thumb(), helper.imageView);

        String Agree_apply = "";
        if (item.getAgree_apply() == 0) {
            Agree_apply = "待同意";
        } else if (item.getAgree_apply() == 1) {
            Agree_apply = "已同意";
        } else {
            Agree_apply = "拒绝";
        }
        helper.setText(R.id.ri_refound_item_order_status, item.getOrder_status() == "" ? tipStr : Agree_apply + " " + item.getReimburse_status());

        helper.setText(R.id.ri_refound_item_goods_nums, item.getGet_return_goods().getReturn_number() + "" + "" == "" ? tipStr : "x" + item.getGet_return_goods().getReturn_number() + "");
        helper.addOnClickListener(R.id.ri_refound_item_group);

        helper.mContainer.removeAllViews();

        if (item.isRefound_cancel()) {
            View view_pingjia = addView("取消申请", true, helper);
            view_pingjia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    OrderUtils.getInstance().refound_cancel_post(item.getRet_id() + "");
                    OrderUtils.getInstance().setOnQequestOrderCeancelListener(new OrderUtils.OnQequestOrderCeancelListener() {
                        @Override
                        public void OnQequestOrderCeancel(int status) {
                            if (status==1){
                                remove(helper.getAdapterPosition());
                            }else {
                                ToastUS.Error("取消申请失败");
                            }
                        }
                    });
                }
            });
        }


        View view = addView("查看详情", true, helper);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ITTUtils.Jump(OrderDetailsActivity.class, item.getOrder_id() + "");
            }
        });


    }

    class MyHolder extends BaseViewHolder {
        LinearLayout mContainer;

        ImageView imageView;

        public MyHolder(View view) {
            super(view);
            mContainer = view.findViewById(R.id.ri_refound_item_container);
            imageView = view.findViewById(R.id.ri_refound_item_goods_img);
        }

    }

    public View addView(String title, boolean isBga, MyHolder helper) {
        LinearLayout mFooterLayout = helper.itemView.findViewById(R.id.ri_refound_item_container);
        TextView child = new TextView(context);
        child.setTextSize(11);
        child.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(CommonUtils.dp2px(mContext, 50), CommonUtils.dp2px(mContext, 25));
        lp.setMargins(0, 0, CommonUtils.dp2px(mContext, 15), 0);
        child.setWidth(CommonUtils.dp2px(mContext, 50));
        child.setHeight(CommonUtils.dp2px(mContext, 25));
        child.setText(title);
        if (isBga) {
            child.setTextColor(context.getResources().getColor(R.color.white));
            child.setBackground(context.getResources().getDrawable(R.drawable.shape_calculation_btn_yes_bga));
        } else {
            child.setTextColor(context.getResources().getColor(R.color.colorAccent));
            child.setBackground(context.getResources().getDrawable(R.drawable.shape_calculation_btn_no_bga));
        }
        child.setTag("aaaaa" + helper.getAdapterPosition());
        mFooterLayout.addView(child, lp);
        return child;
    }


}

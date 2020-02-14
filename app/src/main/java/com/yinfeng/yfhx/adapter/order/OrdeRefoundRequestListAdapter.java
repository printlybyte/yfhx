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
import com.lgd.lgd_core.ui.utils.ITTUtils;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.order.OrderRefoundRequestListActivityBean;
import com.yinfeng.yfhx.ui.order.OrderRefoundRequestListDetailsActivity;
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
public class OrdeRefoundRequestListAdapter extends BaseQuickAdapter<OrderRefoundRequestListActivityBean.DataBean.GoodsBean, OrdeRefoundRequestListAdapter.MyHolder> {


    private Context context = Latte.getApplicationContext();

    private String mOrderId;

    public OrdeRefoundRequestListAdapter(int layoutResId, List data, String order_id) {
        super(layoutResId, data);
        mOrderId = order_id;
    }


    @Override
    protected void convert(@NonNull MyHolder helper, OrderRefoundRequestListActivityBean.DataBean.GoodsBean item) {

        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);

        helper.setText(R.id.ri_refound_requstlist_item_goods_name, item.getGoods_name() == "" ? tipStr : "" + item.getGoods_name());
        helper.setText(R.id.ri_refound_requstlist_item_price, item.getGoods_price() == "" ? tipStr : "" + item.getGoods_price() + "x" + item.getGoods_number());
        GlideUS.loadPhoto(item.getGoods_thumb(), helper.imageView);

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
        }else {
            View view = addView("申请售后", true, helper);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                ActivityUtils.startActivity(OrderRefoundRequestListDetailsActivity.class);
                    ITTUtils.Jump(OrderRefoundRequestListDetailsActivity.class, item.getRec_id() + "", mOrderId + "");
                }
            });
        }





    }

    class MyHolder extends BaseViewHolder {
        ImageView imageView;
        LinearLayout mContainer;
        public MyHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.ri_refound_requstlist_item_goods_img);
            mContainer = view.findViewById(R.id.ri_refound_requstlist_item_container);

        }

    }


    public View addView(String title, boolean isBga, MyHolder helper) {
        LinearLayout mFooterLayout = helper.itemView.findViewById(R.id.ri_refound_requstlist_item_container);
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

package com.yinfeng.yfhx.adapter.order;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.CommonUtils;
import com.lgd.lgd_core.ui.utils.ITTUtils;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.order.OrderActivityBean;
import com.yinfeng.yfhx.ui.details.CommodityDetailsActivity;
import com.yinfeng.yfhx.ui.order.OrderDaiPingJiaListActivity;
import com.yinfeng.yfhx.ui.order.OrderDaipingjiaDetailsActivity;
import com.yinfeng.yfhx.ui.order.OrderDetailsActivity;
import com.yinfeng.yfhx.ui.order.OrderRefoundRequestListActivity;
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
public class OrdeAllAdapter extends BaseQuickAdapter<OrderActivityBean.DataBean.ListBean, OrdeAllAdapter.MyHolder> {


    private Context context = Latte.getApplicationContext();

    public OrdeAllAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    @Override
    protected void convert(@NonNull MyHolder helper, OrderActivityBean.DataBean.ListBean item) {

        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.ri_all_item_order_sn, item.getOrder_sn() == "" ? tipStr : "订单号：" + item.getOrder_sn());
        helper.setText(R.id.ri_all_item_order_time, item.getOrder_time() == "" ? tipStr : "下单时间：" + item.getOrder_time());
        helper.setText(R.id.ri_all_item_shop_name, item.getShop_name() == "" ? tipStr : item.getShop_name());
        helper.setText(R.id.ri_all_item_order_status, item.getOrder_status() == "" ? tipStr : item.getOrder_status());
        helper.setText(R.id.ri_all_item_total_price, item.getTotal_amount_formated() == "" ? tipStr : "" + item.getTotal_amount_formated());
        helper.setText(R.id.ri_all_item_total_nums, item.getOrder_goods().size() + "" == "" ? tipStr : "共" + item.getOrder_goods().size() + "件商品：");

        helper.addOnClickListener(R.id.ri_all_item_group);


        helper.mContainer.removeAllViews();

        if (!TextUtils.isEmpty(item.getHandler())) {
            if (item.getHandler().equals("0")) {
                View view_pingjia = addView("评价晒单", true, helper);

                view_pingjia.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ActivityUtils.startActivity(OrderDaiPingJiaListActivity.class);
                    }
                });
            }

            if (item.getHandler().equals("1")) {
                View view_pingjia = addView("取消订单", true, helper);
                view_pingjia.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        OrderUtils.getInstance().order_cancel_post(item.getOrder_id() + "");
                        OrderUtils.getInstance().setOnOrderCeancelListener(new OrderUtils.OnOrderCeancelListener() {
                            @Override
                            public void OnOrderCeancel(int status) {
                                if (status==1){
                                    remove(helper.getAdapterPosition());
                                }else {
                                    ToastUS.Error("取消订单失败");
                                }
                            }
                        });

                    }
                });
            }

            if (item.getHandler().equals("2")) {
                View view_pingjia = addView("确认收货", true, helper);
                view_pingjia.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        OrderUtils.getInstance().order_confirm_post(item.getOrder_id() + "");
                        OrderUtils.getInstance().setOnOrderConfirmListener(new OrderUtils.OnOrderConfirmListener() {
                            @Override
                            public void OnOrderConfirm(int status) {
                                if (status == 1) {
                                    ToastUS.Success("确认收货成功");
                                    remove(helper.getAdapterPosition());
                                } else {
                                    ToastUS.Error("收货失败");
                                }
                            }
                        });
                    }
                });
            }


        }

        if (item.getOrder_del() > 0 || item.getHandler().equals("8")) {
            View view_pingjia = addView("删除订单", true, helper);
            view_pingjia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   OrderUtils.getInstance().order_delete_post(item.getOrder_id() + "");
                    OrderUtils.getInstance().setOnOrderDellListener(new OrderUtils.OnOrderDelListener() {
                        @Override
                        public void OnOrderDel(int status) {
                            if (status==1){
                                remove(helper.getAdapterPosition());
                            }
                        }
                    });
                }
            });
        }


        if (item.getHandler_return() != 0 && !item.getExtension_code().equals("package_buy")) {
            View view_pingjia = addView("申请售后", true, helper);
            view_pingjia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ITTUtils.Jump(OrderRefoundRequestListActivity.class, "" + item.getOrder_id() + "");
                }
            });
        }


        if (!TextUtils.isEmpty(item.getOnline_pay()) && item.getFailure() == 0) {
            View view_pingjia = addView("立即支付", true, helper);
            view_pingjia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToastUS.Error("立即支付");
                }
            });
        }


        View view = addView("查看订单", true, helper);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ITTUtils.Jump(OrderDetailsActivity.class, item.getOrder_id() + "");
            }
        });


        OrderChildAdapter orderChildAdapter = new OrderChildAdapter(R.layout.ri_order_child_item, item.getOrder_goods());
        helper.recyclerView.setAdapter(orderChildAdapter);
        orderChildAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.ri_order_child_item_group:
                        String mGoods_id = orderChildAdapter.getData().get(position).getGoods_id() + "";
                        ITTUtils.Jump(CommodityDetailsActivity.class, mGoods_id);
                        break;

                }
            }
        });
    }

    class MyHolder extends BaseViewHolder {
        RecyclerView recyclerView;

        LinearLayout mContainer;

        public MyHolder(View view) {
            super(view);
            recyclerView = view.findViewById(R.id.ri_order_item_recyclerview);
            mContainer = view.findViewById(R.id.ri_all_item_container);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Latte.getApplicationContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
        }
    }


    public View addView(String title, boolean isBga, MyHolder helper) {
        LinearLayout mFooterLayout = helper.itemView.findViewById(R.id.ri_all_item_container);
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

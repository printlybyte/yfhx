package com.yinfeng.yfhx.ui.wheight.dialog;

import android.annotation.SuppressLint;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.lgd.lgd_core.ui.dialogFragment.BaseDialogFragment;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.adapter.dialog.CouponUseDialogAdapter;
import com.yinfeng.yfhx.entity.CalculationActivityBean;
import com.yinfeng.yfhx.entity.Trade_change_bean;
import com.yinfeng.yfhx.ui.utils.CouponUtils;

import java.util.List;

/**
 * ============================================
 * 描  述：优惠券底部弹出-立即使用
 * 包  名：com.yinfeng.yfhx.ui.wheight
 * 类  名：BottomCouponDialog
 * 创建人：liuguodong
 * 创建时间：2019/10/21 17:00
 * ============================================
 **/
@SuppressLint("ValidFragment")
public class BottomCouponUseDialog extends BaseDialogFragment implements View.OnClickListener {
    private RecyclerView mIncludeRecyclerview;
    private ImageView mDfCouponDialogLayoutDismis;


    @Override
    protected int getContentLayoutId() {
        return R.layout.df_coupon_use_dialog_layout;
    }

    @Override
    protected int getContentGravity() {
        return Gravity.BOTTOM;
    }

    private List<CalculationActivityBean.DataBean.CouponsListBean> mList;
    private CalculationActivityBean.DataBean mBean;

    private TextView mText_total, mText_coupon_price, mText_total_display;

    @SuppressLint("ValidFragment")
    public BottomCouponUseDialog(CalculationActivityBean.DataBean bean, TextView total, TextView coupon_price, TextView Text_total_display) {
        mList = bean.getCoupons_list();
        mBean = bean;
        mText_total = total;
        mText_coupon_price = coupon_price;
        mText_total_display = Text_total_display;
    }


    @Override
    protected void initView(View view) {
        mIncludeRecyclerview = (RecyclerView) view.findViewById(R.id.include_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(layoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        //消除嵌套卡顿
//        mIncludeRecyclerview.setNestedScrollingEnabled(false);


        mDfCouponDialogLayoutDismis = (ImageView) view.findViewById(R.id.df_coupon_use_dialog_layout_dismis);
        mDfCouponDialogLayoutDismis.setOnClickListener(this);
        setAdapter();
    }

    private void setAdapter() {

        CouponUseDialogAdapter couponDialogAdapter = new CouponUseDialogAdapter(R.layout.df_coupon_use_dialog_item, mList);
        couponDialogAdapter.openLoadAnimation();
        mIncludeRecyclerview.setAdapter(couponDialogAdapter);
        couponDialogAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.df_bottom_coupon_use_item_btn:
                        String uc_id = couponDialogAdapter.getData().get(position).getUc_id() + "";
                        String total = new Gson().toJson(mBean.getTotal()).toString();
                        CouponUtils.getInstance().trade_changecou_post(uc_id, total);

                        CouponUtils.getInstance().setOnChangeEcuListener(new CouponUtils.OnReceiveChangeEcuListener() {
                            @Override
                            public void OnReceiveChangeEcu(int status, Trade_change_bean bean) {
                                if (status == 1) {
                                    mText_total.setText(bean.getData().getAmount_formated() + "");
                                    mText_total_display.setText(bean.getData().getAmount_formated() + "");
                                    mText_coupon_price.setHint(uc_id);
                                    mText_coupon_price.setText(bean.getData().getCoupons_money_formated() + "");
                                } else {
                                    ToastUS.Normal("优惠券使用失败");
                                }
                                dismiss();
                            }
                        });

                        break;

                }
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.df_coupon_use_dialog_layout_dismis:
                this.dismiss();
                break;
        }
    }


}

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
import com.yinfeng.yfhx.adapter.dialog.RedpackUseDialogAdapter;
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
public class BottomRedpackUseDialog extends BaseDialogFragment implements View.OnClickListener {
    private RecyclerView mIncludeRecyclerview;
    private ImageView mDfCouponDialogLayoutDismis;


    @Override
    protected int getContentLayoutId() {
        return R.layout.df_redpack_use_dialog_layout;
    }

    @Override
    protected int getContentGravity() {
        return Gravity.BOTTOM;
    }

    List<CalculationActivityBean.DataBean.ValueCardBean> mList;


    private TextView mText_total, mText_redpack_price, mText_redpack_diaplay, mText_total_display;
    CalculationActivityBean.DataBean mBean;

    @SuppressLint("ValidFragment")
    public BottomRedpackUseDialog(CalculationActivityBean.DataBean bean, TextView total, TextView readpack_price, TextView display,TextView   Text_total_display) {
        mList = bean.getValue_card();
        mBean = bean;
        mText_total = total;
        mText_redpack_price = readpack_price;
        mText_redpack_diaplay = display;
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


        mDfCouponDialogLayoutDismis = (ImageView) view.findViewById(R.id.df_redpack_use_dialog_layout_dismis);
        mDfCouponDialogLayoutDismis.setOnClickListener(this);
        setAdapter();
    }

    private void setAdapter() {

        RedpackUseDialogAdapter redpackDialogAdapter = new RedpackUseDialogAdapter(R.layout.df_redpack_use_dialog_item, mList);
        redpackDialogAdapter.openLoadAnimation();
        mIncludeRecyclerview.setAdapter(redpackDialogAdapter);
        redpackDialogAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String vc_id = redpackDialogAdapter.getData().get(position).getVc_id() + "";
                String total = new Gson().toJson(mBean.getTotal()).toString();
                switch (view.getId()) {
                    case R.id.df_bottom_redpack_use_item_btn:
                        CouponUtils.getInstance().trade_changecard_post(vc_id, total);
                        CouponUtils.getInstance().setOnChangeCardListener(new CouponUtils.OnReceiveChangeCardListener() {
                            @Override
                            public void OnReceiveChangeCard(int status, Trade_change_bean bean) {
                                if (status == 1) {
                                    mText_total.setText(bean.getData().getAmount_formated() + "");
                                    mText_total_display.setText(bean.getData().getAmount_formated() + "");
                                    mText_redpack_price.setText(bean.getData().getCard_money_formated() + "");
                                    mText_redpack_diaplay.setText("电子红包");
                                } else {
                                    ToastUS.Normal("电子红包使用失败");
                                }
                                dismiss();
                            }
                        });
                        break;
                    case R.id.df_bottom_redcard_use_item_btn:
                        CouponUtils.getInstance().trade_changecard_post(vc_id, total);
                        CouponUtils.getInstance().setOnChangeCardListener(new CouponUtils.OnReceiveChangeCardListener() {
                            @Override
                            public void OnReceiveChangeCard(int status, Trade_change_bean bean) {
                                if (status == 1) {
                                    mText_total.setText(bean.getData().getAmount_formated() + "");
                                    mText_total_display.setText(bean.getData().getAmount_formated() + "");
                                    mText_redpack_price.setText(bean.getData().getCard_money_formated() + "");
                                    mText_redpack_diaplay.setText("储值卡");

                                } else {
                                    ToastUS.Normal("储值卡使用失败");
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
            case R.id.df_redpack_use_dialog_layout_dismis:
                this.dismiss();
                break;
        }
    }
}

package com.yinfeng.yfhx.ui.wheight.dialog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.dialogFragment.BaseDialogFragment;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.adapter.dialog.CouponDialogAdapter;
import com.yinfeng.yfhx.entity.BottomCouponDialogBean;
import com.yinfeng.yfhx.entity.CommonExternalBean;
import com.yinfeng.yfhx.entity.CommonStatusErrorBean;
import com.yinfeng.yfhx.ui.utils.CouponUtils;

import java.util.LinkedHashMap;

/**
 * ============================================
 * 描  述：优惠券底部弹出
 * 包  名：com.yinfeng.yfhx.ui.wheight
 * 类  名：BottomCouponDialog
 * 创建人：liuguodong
 * 创建时间：2019/10/21 17:00
 * ============================================
 **/
@SuppressLint("ValidFragment")
public class BottomCouponDialog extends BaseDialogFragment implements View.OnClickListener {
    private RecyclerView mIncludeRecyclerview;
    private View view;
    private ImageView mDfCouponDialogLayoutDismis;


    @Override
    protected int getContentLayoutId() {
        return R.layout.df_coupon_dialog_layout;
    }

    @Override
    protected int getContentGravity() {
        return Gravity.BOTTOM;
    }

    @SuppressLint("ValidFragment")
    public BottomCouponDialog(String ruId, String goodsId) {
        mRu_id = ruId;
        mGoods_id = goodsId;
    }



    private String mRu_id, mGoods_id;

    @Override
    protected void initView(View view) {
        mIncludeRecyclerview = (RecyclerView) view.findViewById(R.id.include_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(layoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        //消除嵌套卡顿
//        mIncludeRecyclerview.setNestedScrollingEnabled(false);
        requestDate();

        mDfCouponDialogLayoutDismis = (ImageView) view.findViewById(R.id.df_coupon_dialog_layout_dismis);
        mDfCouponDialogLayoutDismis.setOnClickListener(this);
    }

    private void setAdapter(BottomCouponDialogBean bean) {
        CouponDialogAdapter couponDialogAdapter = new CouponDialogAdapter(R.layout.df_coupon_dialog_item, bean.getData());
        couponDialogAdapter.openLoadAnimation();
        mIncludeRecyclerview.setAdapter(couponDialogAdapter);
        couponDialogAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.df_bottom_coupon_item_btn:
                        String cou_id = couponDialogAdapter.getData().get(position).getCou_id() + "";
                        CouponUtils.getInstance().coupon_receive(cou_id);
                        CouponUtils.getInstance().setOnValueChangeListener(new CouponUtils.OnReceiveChangeListener() {
                            @Override
                            public void OnReceiveChange(int status) {
//                                requestDate();
                            }
                        });
                        break;

                }
            }
        });

    }

    private void requestDate() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        if (TextUtils.isEmpty(mGoods_id) || TextUtils.isEmpty(mRu_id)) {
            ToastUS.Warning("query parmar null");
            return;
        }
        map.put("goods_id", mGoods_id);
        map.put("ru_id", mRu_id);
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.coupon_goods_post)
                .setParamsMap(map)
                .getStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            BottomCouponDialogBean bean = GsonUS.getIns().getGosn(response, BottomCouponDialogBean.class);
                            if (bean != null) {
                                setAdapter(bean);
                            }
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                CommonStatusErrorBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean.class);
                                ToastUS.Error(bean_e.getErrors().getMessage());
                            }
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {

                    }
                })
        ;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.df_coupon_dialog_layout_dismis:
                this.dismiss();
                break;
        }
    }
}

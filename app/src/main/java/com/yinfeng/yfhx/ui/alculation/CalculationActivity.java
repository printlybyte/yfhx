package com.yinfeng.yfhx.ui.alculation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kongzue.dialog.interfaces.OnDismissListener;
import com.kongzue.dialog.v3.TipDialog;
import com.kongzue.dialog.v3.WaitDialog;
import com.lgd.lgd_core.base.BaseActivity;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.ITTUtils;
import com.lgd.lgd_core.ui.utils.IntentUtilsConstant;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.adapter.calculation.CalculationAdapter;
import com.yinfeng.yfhx.entity.CalculationActivityBean;
import com.yinfeng.yfhx.entity.CommonExternalBean;
import com.yinfeng.yfhx.entity.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.Trade_done_bean;
import com.yinfeng.yfhx.entity.child.ChildInvoiceBean;
import com.yinfeng.yfhx.ui.me.MeAddressActivity;
import com.yinfeng.yfhx.ui.me.MeInvoiceActivity;
import com.yinfeng.yfhx.ui.shop.ShopActivity;
import com.yinfeng.yfhx.ui.utils.ShopCarUtils;
import com.yinfeng.yfhx.ui.wheight.dialog.BottomCouponUseDialog;
import com.yinfeng.yfhx.ui.wheight.dialog.BottomRedpackUseDialog;

import java.util.LinkedHashMap;

public class CalculationActivity extends BaseActivity implements View.OnClickListener {


    /**
     * 张66
     */
    private TextView mActivityCalculationAddressName;
    /**
     * 山东省济南市市中区历阳大街6号
     */
    private TextView mActivityCalculationAddressDetails;
    /**
     * ￥25.00
     */
    private TextView mActivityCalculationAmountFormated;

    private RecyclerView mIncludeRecyclerview;
    private CalculationAdapter calculationAdapter;
    /**
     *
     */
    private TextView mActivityCalculationCoupon;
    /**
     * 个人付款
     */
    private TextView mActivityCalculationPersonal;
    /**
     * 企业付款
     */
    private TextView mActivityCalculationEnterprise;
    private LinearLayout mActivityCalculationCouponOc;
    private LinearLayout mActivityCalculationInvoiceOc;
    /**
     * -25.00
     */
    private TextView mActivityCalculationRedpack;
    private LinearLayout mActivityCalculationRedpackOc;


    private TextView mActivityCalculationRedpackDisplay;
    /**
     * ￥25.00
     */
    private TextView mActivityCalculationShopFee;
    /**
     * ￥25.00
     */
    private TextView mActivityCalculationTotalPrice;
    /**
     * 立即付款
     */
    private TextView mActivityCalculationConfirmBtn;
    /**
     * 选填
     */
    private TextView mActivityCalculationInvoiceContent;
    private LinearLayout mActivityCalculationAddressOc;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_calculation;
    }

    @Override
    protected void initView() {

        mActivityCalculationAddressName = (TextView) findViewById(R.id.activity_calculation_address_name);
        mActivityCalculationAddressDetails = (TextView) findViewById(R.id.activity_calculation_address_details);
        mActivityCalculationAmountFormated = (TextView) findViewById(R.id.activity_calculation_amount_formated);


        mIncludeRecyclerview = (RecyclerView) findViewById(R.id.include_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Latte.getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(linearLayoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());


        mActivityCalculationCoupon = (TextView) findViewById(R.id.activity_calculation_coupon);
        mActivityCalculationPersonal = (TextView) findViewById(R.id.activity_calculation_personal);
        mActivityCalculationPersonal.setOnClickListener(this);
        mActivityCalculationEnterprise = (TextView) findViewById(R.id.activity_calculation_enterprise);
        mActivityCalculationEnterprise.setOnClickListener(this);
        mActivityCalculationCouponOc = (LinearLayout) findViewById(R.id.activity_calculation_coupon_oc);
        mActivityCalculationCouponOc.setOnClickListener(this);
        mActivityCalculationInvoiceOc = (LinearLayout) findViewById(R.id.activity_calculation_invoice_oc);
        mActivityCalculationInvoiceOc.setOnClickListener(this);
        mActivityCalculationRedpack = (TextView) findViewById(R.id.activity_calculation_redpack);
        mActivityCalculationRedpackOc = (LinearLayout) findViewById(R.id.activity_calculation_redpack_oc);
        mActivityCalculationRedpackOc.setOnClickListener(this);
        mActivityCalculationRedpackDisplay = (TextView) findViewById(R.id.activity_calculation_redpack_display);


        mActivityCalculationShopFee = (TextView) findViewById(R.id.activity_calculation_shop_fee);
        mActivityCalculationCoupon.setOnClickListener(this);
        mActivityCalculationTotalPrice = (TextView) findViewById(R.id.activity_calculation_total_price);
        mActivityCalculationConfirmBtn = (TextView) findViewById(R.id.activity_calculation_confirm_btn);
        mActivityCalculationConfirmBtn.setOnClickListener(this);
        mActivityCalculationInvoiceContent = (TextView) findViewById(R.id.activity_calculation_invoice_content);
        mActivityCalculationAddressOc = (LinearLayout) findViewById(R.id.activity_calculation_address_oc);
        mActivityCalculationAddressOc.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        requestDate();
    }

    void setAdapter(CalculationActivityBean bean) {
        calculationAdapter = new CalculationAdapter(R.layout.ri_calculation_item, bean.getData().getGoods_list());
        mIncludeRecyclerview.setAdapter(calculationAdapter);
        calculationAdapter.openLoadAnimation();

        calculationAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.ri_calculation_item_shop_name:
                        String mRu_id = calculationAdapter.getData().get(position).getRu_id() + "";
                        ITTUtils.Jump(ShopActivity.class, mRu_id + "");
                        break;
                }
            }
        });


    }

    private CalculationActivityBean bean;

    private void requestDate() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.trade_orderinfo_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            bean = GsonUS.getIns().getGosn(response, CalculationActivityBean.class);
                            if (bean != null) {
                                setDates(bean);
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

    private void setDates(CalculationActivityBean beanx) {


        CalculationActivityBean.DataBean bean = beanx.getData();
        mActivityCalculationAddressName.setText(bean.getConsignee().getConsignee() + "  " + bean.getConsignee().getMobile());
        mActivityCalculationAddressDetails.setText("" + bean.getConsignee().getProvince_name() + bean.getConsignee().getCity_name() + bean.getConsignee().getDistrict_name() + bean.getConsignee().getAddress());
        mActivityCalculationAmountFormated.setText(bean.getTotal().getAmount_formated() + "");
        mActivityCalculationCoupon.setText("可用优惠券" + "(" + bean.getCoupons_list().size() + "张)");

        mActivityCalculationRedpack.setText("可用红包/储值卡" + "(" + bean.getValue_card().size() + "张)");

        mActivityCalculationShopFee.setText("" + bean.getTotal().getShipping_fee_formated() + "");
        mActivityCalculationTotalPrice.setText("" + bean.getTotal().getAmount_formated() + "");


    }

    /**
     * ==2  企业   ==1 个人
     */
    private int mPayStatus = 2;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.activity_calculation_personal:
                mPayStatus = 1;
                mActivityCalculationPersonal.setTextColor(getResources().getColor(R.color.white));
                mActivityCalculationEnterprise.setTextColor(getResources().getColor(R.color.black));
                mActivityCalculationPersonal.setBackground(getResources().getDrawable(R.drawable.shape_calculation_btn_yes_bga));
                mActivityCalculationEnterprise.setBackground(getResources().getDrawable(R.drawable.shape_calculation_btn_no_bga));
                mActivityCalculationRedpackOc.setVisibility(View.VISIBLE);

                break;
            case R.id.activity_calculation_enterprise:
                mActivityCalculationEnterprise.setBackground(getResources().getDrawable(R.drawable.shape_calculation_btn_yes_bga));
                mActivityCalculationPersonal.setBackground(getResources().getDrawable(R.drawable.shape_calculation_btn_no_bga));
                mPayStatus = 2;
                mActivityCalculationPersonal.setTextColor(getResources().getColor(R.color.black));
                mActivityCalculationEnterprise.setTextColor(getResources().getColor(R.color.white));

                mActivityCalculationRedpackOc.setVisibility(View.GONE);

                break;
            case R.id.activity_calculation_coupon_oc:
                BottomCouponUseDialog couponDialog = new BottomCouponUseDialog(bean.getData(), mActivityCalculationTotalPrice, mActivityCalculationCoupon, mActivityCalculationAmountFormated);
                couponDialog.show(getSupportFragmentManager(), "");


                break;
            case R.id.activity_calculation_invoice_oc://发票信息


//                ITTUtils.Jump(MeInvoiceActivity.class, "calculation");

                Intent intent = new Intent(CalculationActivity.this, MeInvoiceActivity.class);
                intent.putExtra(IntentUtilsConstant.INTENT_PARAMS_1, "calculation");
                startActivityForResult(intent, invoice_request_code);


//                ActivityUtils.startActivity(MeInvoiceActivity.class);

                break;
            case R.id.activity_calculation_redpack_oc:

                BottomRedpackUseDialog redpackUseDialog = new BottomRedpackUseDialog(bean.getData(), mActivityCalculationTotalPrice, mActivityCalculationRedpack, mActivityCalculationRedpackDisplay, mActivityCalculationAmountFormated);
                redpackUseDialog.show(getSupportFragmentManager(), "");


                break;
            case R.id.activity_calculation_coupon:


                break;
            case R.id.activity_calculation_confirm_btn:
                if (bean != null) {
                    if (bean.getData().getNoshipping_list() != null && bean.getData().getNoshipping_list().size() == 0) {
                        //下单
                        WaitDialog.show(CalculationActivity.this, "请稍候...");
                        ShopCarUtils.getInstance().trade_done_post(bean.getData(), childInvoiceBean);
                        ShopCarUtils.getInstance().setOnTradeDoneListener(new ShopCarUtils.OnTradeDoneListener() {
                            @Override
                            public void onTradeDoneClick(int status, Trade_done_bean bean) {
                                if (status==1){
                                    TipDialog.show(CalculationActivity.this, "成功！", TipDialog.TYPE.SUCCESS).setOnDismissListener(new OnDismissListener() {
                                        @Override
                                        public void onDismiss() {



                                        }
                                    });
                                }else {
                                    TipDialog.show(CalculationActivity.this, "失败", TipDialog.TYPE.SUCCESS).setOnDismissListener(new OnDismissListener() {
                                        @Override
                                        public void onDismiss() {



                                        }
                                    });
                                }
                            }
                        });
                    } else {
                        ToastUS.Error("有不支持配送的商品,请重新选择地址");
                    }
                } else {
                    ToastUS.Error("bean==null");
                }
                break;
            case R.id.activity_calculation_address_oc:

                Intent intent2 = new Intent(CalculationActivity.this, MeAddressActivity.class);
                intent2.putExtra(IntentUtilsConstant.INTENT_PARAMS_1, "address");
                startActivityForResult(intent2, address_request_code);

                break;
        }
    }


    int invoice_request_code = 686;
    int address_request_code = 786;
    private String Inv_type;
    private String Company_name;
    private String Tax_id;
    private String Inv_id;
    private String inv_content;
    private ChildInvoiceBean childInvoiceBean = new ChildInvoiceBean();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == invoice_request_code) {
            Inv_type = data.getStringExtra("Inv_type");
            Inv_id = data.getStringExtra("Inv_id");
            Company_name = data.getStringExtra("Company_name");
            Tax_id = data.getStringExtra("Tax_id");
            inv_content = "开发票";

            childInvoiceBean.setInv_type(Inv_type);
            childInvoiceBean.setInv_id(Inv_id);
            childInvoiceBean.setTax_id(Tax_id);
            childInvoiceBean.setInv_content(inv_content);

            mActivityCalculationInvoiceContent.setText(Company_name);

        }else if (requestCode==address_request_code){

             requestDate();
        }
    }



}

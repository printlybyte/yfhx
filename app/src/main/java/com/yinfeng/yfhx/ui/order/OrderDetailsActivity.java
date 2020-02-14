package com.yinfeng.yfhx.ui.order;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
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
import com.yinfeng.yfhx.adapter.order.OrderDrtailsAdapter;
import com.yinfeng.yfhx.entity.common.CommonExternalBean;
import com.yinfeng.yfhx.entity.common.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.child.ChildInvoiceBean;
import com.yinfeng.yfhx.entity.order.OrderDetailsActivityBean;
import com.yinfeng.yfhx.ui.details.CommodityDetailsActivity;

import java.util.LinkedHashMap;

public class OrderDetailsActivity extends BaseActivity implements View.OnClickListener {


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
    private OrderDrtailsAdapter orderDrtailsAdapter;
    /**
     *
     */
    private TextView mActivityCalculationCoupon;
    private TextView mActivityCalculationVccard;
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
        return R.layout.activity_order_details;
    }

    private String mOrderId = "";

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String flags = intent.getStringExtra(IntentUtilsConstant.INTENT_PARAMS_1);
        if (TextUtils.isEmpty(flags)) {
            ToastUS.Error("请携带订单查询id");
            return;
        }
        mOrderId = flags;
        mActivityCalculationAddressName = (TextView) findViewById(R.id.activity_oder_details_address_name);
        mActivityCalculationAddressDetails = (TextView) findViewById(R.id.activity_oder_details_address_details);
        mActivityCalculationAmountFormated = (TextView) findViewById(R.id.activity_oder_details_amount_formated);


        mIncludeRecyclerview = (RecyclerView) findViewById(R.id.include_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Latte.getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(linearLayoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());


        mActivityCalculationCoupon = (TextView) findViewById(R.id.activity_oder_details_coupon);
        mActivityCalculationVccard = (TextView) findViewById(R.id.activity_oder_details_vccard);
        mActivityCalculationEnterprise = (TextView) findViewById(R.id.activity_oder_details_enterprise);
        mActivityCalculationEnterprise.setOnClickListener(this);
        mActivityCalculationCouponOc = (LinearLayout) findViewById(R.id.activity_oder_details_coupon_oc);
        mActivityCalculationCouponOc.setOnClickListener(this);
        mActivityCalculationInvoiceOc = (LinearLayout) findViewById(R.id.activity_oder_details_invoice_oc);
        mActivityCalculationInvoiceOc.setOnClickListener(this);
        mActivityCalculationRedpack = (TextView) findViewById(R.id.activity_oder_details_redpack);
        mActivityCalculationRedpackOc = (LinearLayout) findViewById(R.id.activity_oder_details_redpack_oc);
        mActivityCalculationRedpackOc.setOnClickListener(this);
        mActivityCalculationRedpackDisplay = (TextView) findViewById(R.id.activity_oder_details_redpack_display);


        mActivityCalculationShopFee = (TextView) findViewById(R.id.activity_oder_details_shop_fee);
        mActivityCalculationCoupon.setOnClickListener(this);
        mActivityCalculationTotalPrice = (TextView) findViewById(R.id.activity_oder_details_total_price);
        mActivityCalculationConfirmBtn = (TextView) findViewById(R.id.activity_oder_details_confirm_btn);
        mActivityCalculationConfirmBtn.setOnClickListener(this);
        mActivityCalculationInvoiceContent = (TextView) findViewById(R.id.activity_oder_details_invoice_content);
        mActivityCalculationAddressOc = (LinearLayout) findViewById(R.id.activity_oder_details_address_oc);
        mActivityCalculationAddressOc.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        requestDate();
        setTitle("订单详情");
    }

    void setAdapter(OrderDetailsActivityBean bean) {
        orderDrtailsAdapter = new OrderDrtailsAdapter(R.layout.ri_calculation_child_item, bean.getData().getGoods());
        mIncludeRecyclerview.setAdapter(orderDrtailsAdapter);
        orderDrtailsAdapter.openLoadAnimation();

        orderDrtailsAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.ri_calculation_child_item_group:
                        String mGoods_id = orderDrtailsAdapter.getData().get(position).getGoods_id() + "";
                        ITTUtils.Jump(CommodityDetailsActivity.class, mGoods_id);
                        break;
                }
            }
        });


    }

    private OrderDetailsActivityBean bean;

    private void requestDate() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("order_id", mOrderId);
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.trade_orderdetail_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            bean = GsonUS.getIns().getGosn(response, OrderDetailsActivityBean.class);
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

    private void setDates(OrderDetailsActivityBean beanx) {
        OrderDetailsActivityBean.DataBean bean = beanx.getData();

        mActivityCalculationEnterprise.setText(bean.getPay_type() + "");
        mActivityCalculationAddressDetails.setText("" + bean.getAddress());
        mActivityCalculationAddressName.setText(bean.getConsignee() + "");

        mActivityCalculationCoupon.setText("-" + bean.getCoupons());
        mActivityCalculationVccard.setText("-" + bean.getCard_amount() + "");
        mActivityCalculationShopFee.setText(bean.getShipping_name() + "");
        mActivityCalculationInvoiceContent.setText(bean.getInv_content() + "");

        mActivityCalculationAmountFormated.setText(bean.getGoods_amount_formated() + "");
        mActivityCalculationTotalPrice.setText(bean.getGoods_amount_formated() + "");

        mActivityCalculationConfirmBtn.setText(bean.getGoods_amount_formated() + "");


    }

    /**
     * ==2  企业   ==1 个人
     */
    private int mPayStatus = 2;

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            default:
//                break;
//            case R.id.activity_oder_details_personal:
//                mPayStatus = 1;
//                mActivityCalculationPersonal.setTextColor(getResources().getColor(R.color.white));
//                mActivityCalculationEnterprise.setTextColor(getResources().getColor(R.color.black));
//                mActivityCalculationPersonal.setBackground(getResources().getDrawable(R.drawable.shape_calculation_btn_yes_bga));
//                mActivityCalculationEnterprise.setBackground(getResources().getDrawable(R.drawable.shape_calculation_btn_no_bga));
//                mActivityCalculationRedpackOc.setVisibility(View.VISIBLE);
//
//                break;
//            case R.id.activity_oder_details_enterprise:
//                mActivityCalculationEnterprise.setBackground(getResources().getDrawable(R.drawable.shape_calculation_btn_yes_bga));
//                mActivityCalculationPersonal.setBackground(getResources().getDrawable(R.drawable.shape_calculation_btn_no_bga));
//                mPayStatus = 2;
//                mActivityCalculationPersonal.setTextColor(getResources().getColor(R.color.black));
//                mActivityCalculationEnterprise.setTextColor(getResources().getColor(R.color.white));
//
//                mActivityCalculationRedpackOc.setVisibility(View.GONE);
//
//                break;
//            case R.id.activity_oder_details_coupon_oc:
//                BottomCouponUseDialog couponDialog = new BottomCouponUseDialog(bean.getData(), mActivityCalculationTotalPrice, mActivityCalculationCoupon, mActivityCalculationAmountFormated);
//                couponDialog.show(getSupportFragmentManager(), "");
//
//
//                break;
//            case R.id.activity_oder_details_invoice_oc://发票信息
//
//
////                ITTUtils.Jump(MeInvoiceActivity.class, "calculation");
//
//                Intent intent = new Intent(OrderDetailsActivity.this, MeInvoiceActivity.class);
//                intent.putExtra(IntentUtilsConstant.INTENT_PARAMS_1, "calculation");
//                startActivityForResult(intent, invoice_request_code);
//
//
////                ActivityUtils.startActivity(MeInvoiceActivity.class);
//
//                break;
//            case R.id.activity_oder_details_redpack_oc:
//
//                BottomRedpackUseDialog redpackUseDialog = new BottomRedpackUseDialog(bean.getData(), mActivityCalculationTotalPrice, mActivityCalculationRedpack, mActivityCalculationRedpackDisplay, mActivityCalculationAmountFormated);
//                redpackUseDialog.show(getSupportFragmentManager(), "");
//
//
//                break;
//            case R.id.activity_oder_details_coupon:
//
//
//                break;
//            case R.id.activity_oder_details_confirm_btn:
//                if (bean != null) {
//                    if (bean.getData().getNoshipping_list() != null && bean.getData().getNoshipping_list().size() == 0) {
//                        //下单
//                        WaitDialog.show(OrderDetailsActivity.this, "请稍候...");
//                        ShopCarUtils.getInstance().trade_done_post(bean.getData(), childInvoiceBean);
//                        ShopCarUtils.getInstance().setOnTradeDoneListener(new ShopCarUtils.OnTradeDoneListener() {
//                            @Override
//                            public void onTradeDoneClick(int status, Trade_done_bean bean) {
//                                if (status == 1) {
//                                    TipDialog.show(OrderDetailsActivity.this, "成功！", TipDialog.TYPE.SUCCESS).setOnDismissListener(new OnDismissListener() {
//                                        @Override
//                                        public void onDismiss() {
//
//
//                                        }
//                                    });
//                                } else {
//                                    TipDialog.show(OrderDetailsActivity.this, "失败", TipDialog.TYPE.SUCCESS).setOnDismissListener(new OnDismissListener() {
//                                        @Override
//                                        public void onDismiss() {
//
//
//                                        }
//                                    });
//                                }
//                            }
//                        });
//                    } else {
//                        ToastUS.Error("有不支持配送的商品,请重新选择地址");
//                    }
//                } else {
//                    ToastUS.Error("bean==null");
//                }
//                break;
//            case R.id.activity_oder_details_address_oc:
//
//                Intent intent2 = new Intent(OrderDetailsActivity.this, MeAddressActivity.class);
//                intent2.putExtra(IntentUtilsConstant.INTENT_PARAMS_1, "address");
//                startActivityForResult(intent2, address_request_code);
//
//                break;
//        }
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

        } else if (requestCode == address_request_code) {

            requestDate();
        }
    }


}

package com.yinfeng.yfhx.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lgd.lgd_core.entity.XBannerImageBean;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.dialogFragment.BaseDialogFragment;
import com.lgd.lgd_core.ui.gproview.ProviewImageLoader;
import com.lgd.lgd_core.ui.utils.GlideUS;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.ITTUtils;
import com.lgd.lgd_core.ui.utils.IntentUtilsConstant;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.XbannerUtils;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.previewlibrary.ZoomMediaLoader;
import com.sackcentury.shinebuttonlib.ShineButton;
import com.stx.xhb.xbanner.XBanner;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.common.CommodityDetailsActivityBean;
import com.yinfeng.yfhx.entity.common.CommonExternalBean;
import com.yinfeng.yfhx.entity.common.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.Trade_done_bean;
import com.yinfeng.yfhx.entity.details.GoodsshippingfeeBean;
import com.yinfeng.yfhx.ui.alculation.CalculationActivity;
import com.yinfeng.yfhx.ui.shop.MainShopActivity;
import com.yinfeng.yfhx.ui.utils.DetailsUtils;
import com.yinfeng.yfhx.ui.utils.ShopCarUtils;
import com.yinfeng.yfhx.ui.wheight.dialog.BottomCouponDialog;
import com.yinfeng.yfhx.ui.wheight.dialog.BottomDialog;
import com.yinfeng.yfhx.ui.wheight.dialog.BottomSelectedSpecificationDialog;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import chihane.jdaddressselector.ADBottomDialog;
import chihane.jdaddressselector.ISelectAble;
import chihane.jdaddressselector.SelectedListener;


/**
 * ============================================
 * 描  述：商品详情
 * 包  名：com.yinfeng.yfhx.ui.details
 * 类  名：CommodityDetailsActivity
 * 创建人：liuguodong
 * 创建时间：2019/10/9 10:34
 * ============================================
 **/
public class CommodityDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private XBanner mIncludeActivityCommodityDetailsHeaderBanner;

    private String jump_goods_id = "";
    private String mRu_id = "";
    /**
     * 壹号桌（yihaozhuo）
     */
    private TextView mIncludeActivityCommodityDetailsHeaderGoodsName;
    /**
     * 酒店用品宾馆一次性洗漱用品
     */
    private TextView mIncludeActivityCommodityDetailsHeaderGoodsIntroduction;
    /**
     * ￥25.00
     */
    private TextView mIncludeActivityCommodityDetailsHeaderGoodsPrice;
    /**
     * ￥25.00
     */
    private TextView mIncludeActivityCommodityDetailsHeaderGoodsPriceOld;
    /**
     * 库存：2600
     */
    private TextView mIncludeCommodityDetailsHeaderNumber;
    /**
     * 月销量：3666
     */
    private TextView mIncludeCommodityDetailsHeaderSalesVolume;
    /**
     * 格力电器期旗舰店
     */
    private TextView mIncludeCommodityDetailsHeaderShopName;
    /**
     * 1.1万粉丝
     */
    private TextView mIncludeCommodityDetailsHeaderAreaLink;
    private LinearLayout mIncludeDetailsSelectedSpecificationOc;
    private LinearLayout mIncludeDetailsSelectedAddressOc;
    private LinearLayout mIncludeDetailsSelectedCouponOc;
    /**
     * 银丰电商甄选精品
     */
    private TextView mIncludeActivityCommodityDetailsHeaderService;
    /**
     *
     */
    private TextView mIncludeActivityCommodityDetailsHeaderActType;
    /**
     * 100元券 满200减100...查看更多优惠
     */
    private TextView mIncludeActivityCommodityDetailsHeaderActTitle;
    /**
     * 100元券 满200减100...查看更多优惠
     */
    private TextView mIncludeActivityCommodityDetailsYhqContent;
    private LinearLayout mIncludeDetailsSelectedYhqOc;
    private ImageView mIncludeActivityCommodityDetailsShopLogo;
    /**
     * 商品 5分
     */
    private TextView mInDetailsShopCommodity;
    /**
     * 高
     */
    private TextView mInDetailsShopCommodityLe;
    /**
     * 商品 5分
     */
    private TextView mInDetailsShopService;
    /**
     * 高
     */
    private TextView mInDetailsShopServiceLe;
    /**
     * 商品 5分
     */
    private TextView mInDetailsShopAging;
    /**
     * 高
     */
    private TextView mInDetailsShopAgingLe;
    private ImageButton mActivityCommodityDetailsBack;
    private ShineButton mIncludeDetailsBootomBarCollecdOc;
    private LinearLayout mIncludeDetailsBootomBarGwcOc;
    private LinearLayout mIncludeDetailsBootomBarShopOc;
    /**
     * 加入购物车
     */
    private TextView mIncludeDetailsBootomBarAdd;
    /**
     * 立即付款
     */
    private TextView mIncludeDetailsBootomBarBuy;
    /**
     * 送至：
     */
    private TextView mIncludeActivityCommodityDetailsAddressDe;
    /**
     * 运费：￥0.00
     */
    private TextView mIncludeActivityCommodityDetailsAddressYf;
    private ImageView mIncludeActivityCommodityDetailsHeaderAttention;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commodity_details);
        ZoomMediaLoader.getInstance().init(new ProviewImageLoader());
        Intent intent = getIntent();
        jump_goods_id = intent.getStringExtra(IntentUtilsConstant.INTENT_PARAMS_1);
        if (TextUtils.isEmpty(jump_goods_id)) {
            ToastUS.Error("请携带查询参数");
            return;
        }
        initView();

    }

    protected void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);

        mIncludeActivityCommodityDetailsHeaderBanner = (XBanner) findViewById(R.id.include_commodity_details_header_banner);
        requestDate();
        mIncludeActivityCommodityDetailsHeaderGoodsName = (TextView) findViewById(R.id.include_activity_commodity_details_header_goods_name);
        mIncludeActivityCommodityDetailsHeaderGoodsIntroduction = (TextView) findViewById(R.id.include_commodity_details_header_goods_introduction);
        mIncludeActivityCommodityDetailsHeaderGoodsPrice = (TextView) findViewById(R.id.include_commodity_details_header_goods_price);
        mIncludeActivityCommodityDetailsHeaderGoodsPriceOld = (TextView) findViewById(R.id.include_commodity_details_header_goods_price_old);
        mIncludeCommodityDetailsHeaderNumber = (TextView) findViewById(R.id.include_commodity_details_header_number);
        mIncludeCommodityDetailsHeaderSalesVolume = (TextView) findViewById(R.id.include_commodity_details_header_sales_volume);
        mIncludeCommodityDetailsHeaderShopName = (TextView) findViewById(R.id.include_commodity_details_header_shop_name);
        mIncludeCommodityDetailsHeaderAreaLink = (TextView) findViewById(R.id.include_commodity_details_header_area_link);
        mIncludeDetailsSelectedSpecificationOc = (LinearLayout) findViewById(R.id.include_details_selected_specification_oc);
        mIncludeDetailsSelectedAddressOc = (LinearLayout) findViewById(R.id.include_details_selected_address_oc);
        mIncludeDetailsSelectedCouponOc = (LinearLayout) findViewById(R.id.include_details_selected_coupon_oc);
        mIncludeDetailsSelectedSpecificationOc.setOnClickListener(this);
        mIncludeDetailsSelectedAddressOc.setOnClickListener(this);
        mIncludeDetailsSelectedCouponOc.setOnClickListener(this);
        mIncludeActivityCommodityDetailsHeaderService = (TextView) findViewById(R.id.include_activity_commodity_details_header_service);
        mIncludeActivityCommodityDetailsHeaderActType = (TextView) findViewById(R.id.include_activity_commodity_details_header_act_type);
        mIncludeActivityCommodityDetailsHeaderActTitle = (TextView) findViewById(R.id.include_activity_commodity_details_header_act_title);
        mIncludeActivityCommodityDetailsYhqContent = (TextView) findViewById(R.id.include_activity_commodity_details_yhq_content);
        mIncludeDetailsSelectedYhqOc = (LinearLayout) findViewById(R.id.include_details_selected_yhq_oc);
        mIncludeDetailsSelectedYhqOc.setOnClickListener(this);
        mIncludeActivityCommodityDetailsShopLogo = (ImageView) findViewById(R.id.include_activity_commodity_details_shop_logo);
        mInDetailsShopCommodity = (TextView) findViewById(R.id.in_details_shop_commodity);
        mInDetailsShopCommodityLe = (TextView) findViewById(R.id.in_details_shop_commodity_le);
        mInDetailsShopService = (TextView) findViewById(R.id.in_details_shop_service);
        mInDetailsShopServiceLe = (TextView) findViewById(R.id.in_details_shop_service_le);
        mInDetailsShopAging = (TextView) findViewById(R.id.in_details_shop_aging);
        mInDetailsShopAgingLe = (TextView) findViewById(R.id.in_details_shop_aging_le);
        mActivityCommodityDetailsBack = (ImageButton) findViewById(R.id.activity_commodity_details_back);
        mActivityCommodityDetailsBack.setOnClickListener(this);
        mIncludeDetailsBootomBarCollecdOc = (ShineButton) findViewById(R.id.include_details_bootom_bar_collecd_oc);
        mIncludeDetailsBootomBarCollecdOc.setOnCheckStateChangeListener(new ShineButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(View view, boolean checked) {
                if (checked) {
                    DetailsUtils.getInstance().collectgoods(jump_goods_id);
                } else {
                    DetailsUtils.getInstance().collectgoods(jump_goods_id);
                }
            }
        });
        mIncludeDetailsBootomBarGwcOc = (LinearLayout) findViewById(R.id.include_details_bootom_bar_gwc_oc);
        mIncludeDetailsBootomBarGwcOc.setOnClickListener(this);
        mIncludeDetailsBootomBarShopOc = (LinearLayout) findViewById(R.id.include_details_bootom_bar_shop_oc);
        mIncludeDetailsBootomBarShopOc.setOnClickListener(this);
        mIncludeDetailsBootomBarAdd = (TextView) findViewById(R.id.include_details_bootom_bar_add);
        mIncludeDetailsBootomBarAdd.setOnClickListener(this);
        mIncludeDetailsBootomBarBuy = (TextView) findViewById(R.id.include_details_bootom_bar_buy);
        mIncludeDetailsBootomBarBuy.setOnClickListener(this);
        mIncludeActivityCommodityDetailsAddressDe = (TextView) findViewById(R.id.include_activity_commodity_details_address_de);
        mIncludeActivityCommodityDetailsAddressYf = (TextView) findViewById(R.id.include_activity_commodity_details_address_yf);
        mIncludeActivityCommodityDetailsHeaderAttention = (ImageView) findViewById(R.id.include_activity_commodity_details_header_attention);
        mIncludeActivityCommodityDetailsHeaderAttention.setOnClickListener(this);
    }

    private CommodityDetailsActivityBean bean;

    private void requestDate() {
        LinkedHashMap<String, String> mParamsMapx = new LinkedHashMap<>();
        mParamsMapx.put("goods_id", jump_goods_id);
//        mParamsMapx.put("goods_id", "6969");
        new OKBuilder(this)
                .setNetUrl(Api.goods_details_post)
                .setParamsMap(mParamsMapx)
                .showLoading("loading...")
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            bean = GsonUS.getIns().getGosn(response, CommodityDetailsActivityBean.class);
                            if (bean.getData() == null) {
                                return;
                            }
                            setShopDate(bean.getData());
                            setBannerDate(bean.getData().getGallery_list());
                            String html_static = bean.getData().getDesc_mobile();
                            getFragments(html_static, jump_goods_id);
                            initViewPage();
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
                });
    }

    /**
     * 设置xbanner数据
     */
    private void setBannerDate(List<CommodityDetailsActivityBean.DataBean.GalleryListBean> mList) {
        if (mList != null && mList.size() > 0) {
            mIncludeActivityCommodityDetailsHeaderBanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
                @Override
                public void onItemClick(XBanner banner, Object model, View view, int position) {
                    ToastUS.Error(mList.get(position).getImg_original());
//                    ITTUtils.Jump(Main2Activity.class, "" + mList.get(position).getUrl());
                }
            });
            List<XBannerImageBean> data = new ArrayList<>();
            for (int i = 0; i < mList.size(); i++) {
                XBannerImageBean xBannerImageBean = new XBannerImageBean();
                xBannerImageBean.setPath(mList.get(i).getImg_original() + "");
                data.add(xBannerImageBean);
            }
            XbannerUtils.getIns().setXbanner(mIncludeActivityCommodityDetailsHeaderBanner, data);
        }
    }

    private int mCollect_shop = 0;

    private void setShopDate(CommodityDetailsActivityBean.DataBean bean) {
        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        GlideUS.loadPhoto(bean.getBasic_info().getShop_logo(), mIncludeActivityCommodityDetailsShopLogo);
        mIncludeActivityCommodityDetailsHeaderGoodsName.setText(bean.getGoods_bill_name() == "" ? tipStr : bean.getGoods_bill_name());
        mIncludeActivityCommodityDetailsHeaderGoodsIntroduction.setText(bean.getGoods_name() == "" ? tipStr : bean.getGoods_name());
        mIncludeActivityCommodityDetailsHeaderGoodsPrice.setText(bean.getShop_price_formated() == "" ? tipStr : bean.getShop_price_formated());
        mIncludeActivityCommodityDetailsHeaderGoodsPriceOld.setText(bean.getMarket_price_formated() == "" ? tipStr : bean.getMarket_price_formated());
        mIncludeCommodityDetailsHeaderNumber.setText(bean.getGoods_number() + "" == "" ? tipStr : "库存：" + bean.getGoods_number());
        mIncludeCommodityDetailsHeaderSalesVolume.setText(bean.getSales_volume() + "" == "" ? tipStr : "月销量：" + bean.getSales_volume());
        mIncludeCommodityDetailsHeaderShopName.setText(bean.getBasic_info().getShop_title() + "" == "" ? tipStr : bean.getBasic_info().getShop_title());
        mIncludeCommodityDetailsHeaderAreaLink.setText(bean.getBasic_info().getCount_gaze() + "" == "" ? tipStr : bean.getBasic_info().getCount_gaze() + "粉丝");
        mIncludeActivityCommodityDetailsHeaderService.setText(bean.getGoods_msg() + "" == "" ? tipStr : "" + bean.getGoods_msg());


        //店铺信息
        if (bean.getBasic_info() != null) {

            mInDetailsShopCommodity.setText(bean.getBasic_info().getCommentdelivery() + "" == "" ? tipStr : "商品 " + bean.getBasic_info().getCommentdelivery());
            mInDetailsShopCommodityLe.setText(bean.getBasic_info().getCommentdelivery_font() + "" == "" ? tipStr : "" + bean.getBasic_info().getCommentdelivery_font());
            mInDetailsShopService.setText(bean.getBasic_info().getCommentserver() + "" == "" ? tipStr : "服务 " + bean.getBasic_info().getCommentserver());
            mInDetailsShopServiceLe.setText(bean.getBasic_info().getCommentserver_font() + "" == "" ? tipStr : "" + bean.getBasic_info().getCommentserver_font());
            mInDetailsShopAging.setText(bean.getBasic_info().getCommentrank() + "" == "" ? tipStr : "时效 " + bean.getBasic_info().getCommentrank());
            mInDetailsShopAgingLe.setText(bean.getBasic_info().getCommentrank_font() + "" == "" ? tipStr : "" + bean.getBasic_info().getCommentrank_font());
            //店铺关注
            mCollect_shop = bean.getBasic_info().getIs_collect_shop();
            if (bean.getBasic_info().getIs_collect_shop() == 1) {
                mIncludeActivityCommodityDetailsHeaderAttention.setImageResource(R.mipmap.ic_details_attention_yes);
            } else {
                mIncludeActivityCommodityDetailsHeaderAttention.setImageResource(R.mipmap.ic_details_attention_no);
            }
        }
        //bottonbar
        if (bean.getIs_collect() == 1) {
            mIncludeDetailsBootomBarCollecdOc.setChecked(true);
        } else {
            mIncludeDetailsBootomBarCollecdOc.setChecked(false);
        }

        try {
            //地址 运费
            if (bean.getDefault_address() != null) {
                String address = "";
                JSONObject jsonObject = new JSONObject();
                if (bean.getDefault_address().getProvince() != null) {
                    address = bean.getDefault_address().getProvince().getRegion_name();
                    String province_id = bean.getDefault_address().getProvince().getRegion_id() + "";
                    jsonObject.put("province_id", province_id);
                }
                if (bean.getDefault_address().getCity() != null) {
                    String address_city = bean.getDefault_address().getCity().getRegion_name();
                    address = address + address_city;

                    String city_id = bean.getDefault_address().getCity().getRegion_id() + "";
                    jsonObject.put("city_id", city_id);
                }
                if (bean.getDefault_address().getDistrict() != null) {
                    String address_acre = bean.getDefault_address().getDistrict().getRegion_name();
                    address = address + address_acre;

                    String acre_id = bean.getDefault_address().getDistrict().getRegion_id() + "";
                    jsonObject.put("district_id", acre_id);
                    jsonObject.put("street_id", "");
                }
                mIncludeActivityCommodityDetailsAddressDe.setText("送至：" + address);

                DetailsUtils.getInstance().shipping_goodsshippingfee(jump_goods_id, jsonObject.toString());
                DetailsUtils.getInstance().setOnValueChangeListener(new DetailsUtils.OnValueChangeListener() {
                    @Override
                    public void OnValueChange(int status, GoodsshippingfeeBean person, String msg) {
                        if (status == 1) {
                            mIncludeActivityCommodityDetailsAddressYf.setText("运费：" + person.getData().getShipping_fee_formated() + "");
                        } else {
                            mIncludeActivityCommodityDetailsAddressYf.setText("运费：" + "err");
                        }
                    }
                });
            }
        } catch (Exception e) {
            ToastUS.Error(e.getMessage());
        }


        //判断是否有促销是否存在
        if (bean.getGoods_promotion() != null && bean.getGoods_promotion().size() > 0) {
            mIncludeDetailsSelectedCouponOc.setVisibility(View.VISIBLE);
            mIncludeActivityCommodityDetailsHeaderActType.setText(bean.getGoods_promotion().get(0).getAct_title());
            mIncludeActivityCommodityDetailsHeaderActTitle.setText(bean.getGoods_promotion().get(0).getAct_name());
        }


        //判断优惠券是否存在
        if (bean.getCoupon_count() > 0) {
            mIncludeDetailsSelectedYhqOc.setVisibility(View.VISIBLE);
            mIncludeActivityCommodityDetailsYhqContent.setText("领取优惠券" + "(" + bean.getCoupon_count() + "张)");
        }
        mRu_id = bean.getBasic_info().getRu_id() + "";


    }

    String mProd = "";
    List<String> titles = new ArrayList<>();
    List<Fragment> fragments = new ArrayList<>();

    private List<Fragment> getFragments(String html_S, String jump_goods_id) {
        fragments.add(FragmentShopDetails.newInstance(html_S));
        fragments.add(FragmentEvaluationList.newInstance(jump_goods_id));
        titles.add("商品详情");
        titles.add("评价列表");
        return fragments;
    }


    private void initViewPage() {

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                super.destroyItem(container, position, object);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setCustomView(null);
                ;
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.include_details_selected_coupon_oc://优惠券

                break;
            case R.id.include_details_selected_address_oc://地址
//                showAddressDialog();
                break;
            case R.id.include_details_selected_specification_oc://规格

                BottomSelectedSpecificationDialog bottomDialog = new BottomSelectedSpecificationDialog(bean);
                bottomDialog.show(getSupportFragmentManager(), "");
                bottomDialog.setOnDialogListener(new BaseDialogFragment.OnDialogListener() {
                    @Override
                    public void onDialogClick(int type) {

                    }
                });
                break;


            case R.id.include_details_selected_yhq_oc:
                BottomCouponDialog couponDialog = new BottomCouponDialog(mRu_id, jump_goods_id);
                couponDialog.show(getSupportFragmentManager(), "");
                couponDialog.setOnDialogListener(new BaseDialogFragment.OnDialogListener() {
                    @Override
                    public void onDialogClick(int type) {

                    }
                });


                break;
            case R.id.activity_commodity_details_back:
                finish();
                break;
            case R.id.include_details_bootom_bar_gwc_oc:
                finish();

                break;
            case R.id.include_details_bootom_bar_shop_oc:
                  ITTUtils.Jump(MainShopActivity.class, mRu_id + "");

                ToastUS.Success("店铺");
                break;
            case R.id.include_details_bootom_bar_add:
                BottomSelectedSpecificationDialog bottomDialogadd = new BottomSelectedSpecificationDialog(bean);
                bottomDialogadd.show(getSupportFragmentManager(), "");
                bottomDialogadd.setOnDialogListener(new BaseDialogFragment.OnDialogListener() {
                    @Override
                    public void onDialogClick(int type) {

                    }
                });

                break;
            case R.id.include_details_bootom_bar_buy:


                List<CommodityDetailsActivityBean.DataBean.AttrBean> mProd = bean.getData().getAttr() ;
                if (mProd!=null) {
                    if (mProd.size()==0) {

                        ShopCarUtils.getInstance().add(jump_goods_id, null, false,true);
                        ShopCarUtils.getInstance().setOnAddChangeListener(new ShopCarUtils.OnAddChangeListener() {
                            @Override
                            public void onOnAddChangeClick(int status, Trade_done_bean bean) {
                                if (status==1){



                                Intent intent = new Intent(CommodityDetailsActivity.this, CalculationActivity.class);
                                intent.putExtra(IntentUtilsConstant.INTENT_PARAMS_1, "10");
                                startActivityForResult(intent, 131);



                                }
                            }
                        });
                    } else {
                        ITTUtils.Jump(CommodityDetailsActivity.class, jump_goods_id);
                    }
                } else {
                    ToastUS.Warning("err err");
                }


                break;
            case R.id.include_activity_commodity_details_header_attention:
                if (mCollect_shop == 0) {
                    mIncludeActivityCommodityDetailsHeaderAttention.setImageResource(R.mipmap.ic_details_attention_yes);
                    mCollect_shop = 1;
                } else {
                    mIncludeActivityCommodityDetailsHeaderAttention.setImageResource(R.mipmap.ic_details_attention_no);
                    mCollect_shop = 0;
                }
                break;
        }
    }

    //地址选择
    private void showAddressDialog() {
        ADBottomDialog dialog = new ADBottomDialog(CommodityDetailsActivity.this);
        dialog.setOnAddressSelectedListener(new SelectedListener() {
            @Override
            public void onAddressSelected(ArrayList<ISelectAble> selectAbles) {

            }
        });
        dialog.show();
    }




}

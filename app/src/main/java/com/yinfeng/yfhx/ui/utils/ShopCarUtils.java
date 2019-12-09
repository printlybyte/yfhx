package com.yinfeng.yfhx.ui.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.entity.CalculationActivityBean;
import com.yinfeng.yfhx.entity.CommonExternalBean;
import com.yinfeng.yfhx.entity.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.CommonStatusSuccessBean;
import com.yinfeng.yfhx.entity.CommonStatusSuccessBeantest;
import com.yinfeng.yfhx.entity.TAB3CounterUpdateBean;
import com.yinfeng.yfhx.entity.TAB3CounterUpdateErrBean;
import com.yinfeng.yfhx.entity.Trade_change_bean;
import com.yinfeng.yfhx.entity.Trade_done_bean;
import com.yinfeng.yfhx.entity.child.ChildInvoiceBean;
import com.yinfeng.yfhx.entity.t3.ChangeValueArrBean;
import com.yinfeng.yfhx.entity.t3.ShopCarCartValueBean;

import org.json.JSONArray;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.ui.shoppingcar
 * 类  名：ShopCarUtils
 * 创建人：liuguodong
 * 创建时间：2019/10/18 17:18
 * ============================================
 **/
public class ShopCarUtils {


    private static final ShopCarUtils ourInstance = new ShopCarUtils();

    public static ShopCarUtils getInstance() {
        return ourInstance;
    }

    private ShopCarUtils() {
    }

    /**
     * 添加购物车
     */
    public void add(String goods_id, JSONArray jsonArray, boolean isPord) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("goods_id", goods_id);
        map.put("num", "1");
        if (isPord) {
            if (jsonArray == null) {
                ToastUS.Warning("请携带添加购物车参数");
                return;
            }
            map.put("spec", jsonArray.toString());
        }
        map.put("warehouse_id", "0");
        map.put("area_id", "0");
        map.put("parent_id", "0");
        map.put("rec_type", "0");
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.cart_add_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
//                            LoginBean bean_s = GsonUS.getIns().getGosn(response, LoginBean.class);
                            ToastUS.Success("添加成功");
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
     * 购物车选中
     * 0默认不选中 1选中   不传rec_id 时， is_checked 0全部不选中 1全部选中
     */

    public void check(JSONArray jsonArray, String is_checked, boolean isAllSelected) {

        if (!isAllSelected) {
            if (jsonArray == null) {
                ToastUS.Warning("请携带参数");
                return;
            }
        }
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        if (!isAllSelected) {
            map.put("rec_id", jsonArray.toString());
        }
        map.put("is_checked", is_checked);
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.cart_mchecked_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
//                            cartValue();
                            ChangeValueArrBean changeValueArrBean = GsonUS.getIns().getGosn(response, ChangeValueArrBean.class);
                            if (changeValueArrBean != null && changeValueArrBean.getData().getChecked_rec_id() != null && changeValueArrBean.getData().getChecked_rec_id().size() > 0) {
                                if (checkValueChangeListener != null) {
                                    checkValueChangeListener.onChangeValueClick(1, changeValueArrBean.getData().getChecked_rec_id());
                                }
                            } else {
                                if (checkValueChangeListener != null) {
                                    checkValueChangeListener.onChangeValueClick(0, null);
                                }
                            }
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                if (checkValueChangeListener != null) {
                                    checkValueChangeListener.onChangeValueClick(0, null);
                                }
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

    public void cartValue(String jsonArray) {
        if (jsonArray == null) {
            ToastUS.Warning("请携带参数");
            return;
        }
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("rec_id", jsonArray);
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.cart_cartvalue_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            ShopCarCartValueBean bean_s = GsonUS.getIns().getGosn(response, ShopCarCartValueBean.class);
                            if (cartValueChangeListener != null) {
                                cartValueChangeListener.OnCartValueChange(1, bean_s);
                            }
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                CommonStatusErrorBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean.class);
                                ToastUS.Error(bean_e.getErrors().getMessage());
                                if (cartValueChangeListener != null) {
                                    cartValueChangeListener.OnCartValueChange(0, null);
                                }
                            }
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                    }
                });


    }

    public void deleteCart(String recid, int pos) {
        if (TextUtils.isEmpty(recid) || recid == null) {
            ToastUS.Warning("请携带参数");
            return;
        }
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("rec_id", recid);
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.cart_deletecart_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            ToastUS.Success("删除成功");
                            if (mDelListener != null) {
                                mDelListener.onDelClick(1, pos);
                            }
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                mDelListener.onDelClick(0, pos);
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


    public void cart_update(String rec_id, String num) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("rec_id", rec_id);
        map.put("num", num);
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.cart_update_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            TAB3CounterUpdateBean bean_s = GsonUS.getIns().getGosn(response, TAB3CounterUpdateBean.class);
                            if (bean_s.getData().getError() == 0) {
                                String recid_str = bean_s.getData().getChecked_rec_id().toString();
                                ShopCarUtils.getInstance().cartValue(recid_str);
                            } else {
                                TAB3CounterUpdateErrBean counterUpdateErrBean = GsonUS.getIns().getGosn(response, TAB3CounterUpdateErrBean.class);
                                ToastUS.Error(counterUpdateErrBean.getData().getMsg());
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
                });
    }


    /**
     * 提交订单
     */

    public void trade_done_post(CalculationActivityBean.DataBean bean, ChildInvoiceBean childInvoiceBean) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();

        String cart_value = new Gson().toJson(bean.getIsshipping_list()).toString();
        map.put("cart_value", cart_value);
        map.put("flow_type", "" + bean.getFlow_type());
        map.put("store_id", "0");
        map.put("store_type", "0");
        map.put("store_mobile", "0");
        map.put("take_time", "");
        map.put("pay_type", "1");
        map.put("pay_method", "个人付款");
        map.put("pay_id", "15");
        JSONArray jsonArrayRu_id = new JSONArray();
        for (int i = 0; i < bean.getGoods_list().size(); i++) {
            jsonArrayRu_id.put(bean.getGoods_list().get(i).getRu_id());
        }
        map.put("ru_id", jsonArrayRu_id.toString());

        map.put("shipping", null);
        map.put("shipping_code", null);
        map.put("shipping_type", null);

        map.put("point_id", "0");
        map.put("shipping_dateStr", "0");
        map.put("is_surplus", "0");
        map.put("surplus", "0");
        map.put("use_integral", "0");
        map.put("integral", "0");
        map.put("bonus_id", "0");
        map.put("bonus", "0");
        map.put("bonus_sn", "0");
        map.put("uc_id", "0");
        map.put("coupons", "0");
        map.put("vc_id", "0");
        map.put("use_value_card", "0");
        map.put("goods_amount", "0");
        map.put("discount", "0");
        map.put("how_oos", "0");

        map.put("invoice", childInvoiceBean.getInvoice());
        map.put("inv_id", childInvoiceBean.getInv_id());
        map.put("inv_type", childInvoiceBean.getInv_type());
        map.put("inv_payee", childInvoiceBean.getInv_payee());
        map.put("tax_id", childInvoiceBean.getTax_id());
        map.put("inv_content", childInvoiceBean.getInv_content());
        map.put("need_inv", childInvoiceBean.getNeed_inv());


        map.put("card_message", "");
        map.put("tax", "0");
        map.put("pack", "0");
        map.put("card", "0");
        map.put("vat_id", "0");
        map.put("need_insure", "0");
        map.put("bs_id", "0");
        map.put("t_id", "0");
        map.put("extension_id", "0");
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.trade_done_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            Trade_done_bean bean_e = GsonUS.getIns().getGosn(response, Trade_done_bean.class);
                            if (bean_e.getData() != null) {
                                if (mTradeDoneListener != null) {
                                    mTradeDoneListener.onTradeDoneClick(1);
                                }
                            } else {

                            }


//                            CommonStatusSuccessBeantest bean_e = GsonUS.getIns().getGosn(response, CommonStatusSuccessBeantest.class);
//                            ToastUS.Error(bean_e.getData().getMsg());

                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                CommonStatusErrorBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean.class);
                                ToastUS.Error(bean_e.getErrors().getMessage());
                                if (mTradeDoneListener != null) {
                                    mTradeDoneListener.onTradeDoneClick(0);
                                }
                            }
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                    }
                });
    }


    public interface OnCartValueChangeListener {
        void OnCartValueChange(int status, ShopCarCartValueBean person);
    }

    public void setOnCartValueChangeListener(OnCartValueChangeListener dialogListener) {
        this.cartValueChangeListener = dialogListener;
    }

    private static OnCartValueChangeListener cartValueChangeListener;


    public interface OnCheckValueChangeListener {
        void onChangeValueClick(int status, List<Integer> bean);
    }

    public void setOnChangeValueListener(OnCheckValueChangeListener dialogListener) {
        this.checkValueChangeListener = dialogListener;
    }

    private static OnCheckValueChangeListener checkValueChangeListener;


    public interface OnDelListener {
        void onDelClick(int status, int pos);
    }

    public void setOnDelListener(OnDelListener delListener) {
        this.mDelListener = delListener;
    }

    private static OnDelListener mDelListener;


    /**
     * 下单
     */
    public interface OnTradeDoneListener {
        void onTradeDoneClick(int status);
    }

    public void setOnTradeDoneListener(OnTradeDoneListener tradeDoneListener) {
        this.mTradeDoneListener = tradeDoneListener;
    }

    private static OnTradeDoneListener mTradeDoneListener;
}

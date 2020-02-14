package com.yinfeng.yfhx.ui.utils;

import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.entity.common.CommonExternalBean;
import com.yinfeng.yfhx.entity.common.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.common.CommonStatusSuccessBean;
import com.yinfeng.yfhx.entity.details.GoodsshippingfeeBean;

import java.util.LinkedHashMap;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.ui.details
 * 类  名：DetailsUtils
 * 创建人：liuguodong
 * 创建时间：2019/11/21 16:37
 * ============================================
 **/
public class OrderUtils {
    private static final OrderUtils ourInstance = new OrderUtils();

    public static OrderUtils getInstance() {
        return ourInstance;
    }

    private OrderUtils() {
    }

    /**
     * 添加购物车
     */
    public void collectgoods(String goods_id) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("goods_id", goods_id);

        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.collect_collectgoods_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            CommonStatusSuccessBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusSuccessBean.class);
                            ToastUS.Error(bean_e.getData().getMessage());

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
     * 确认收货
     */
    public void order_confirm_post(String order_id) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("order_id", order_id);
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.order_confirm_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            CommonStatusSuccessBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusSuccessBean.class);
//                            ToastUS.Error(bean_e.getData().getMessage());
                            if (onOrderConfirmListener != null) {
                                onOrderConfirmListener.OnOrderConfirm(1);
                            }
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                CommonStatusErrorBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean.class);
                                ToastUS.Error(bean_e.getErrors().getMessage());
                                if (onOrderConfirmListener != null) {
                                    onOrderConfirmListener.OnOrderConfirm(0);
                                }
                            }
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                    }
                });
    }


    /**
     * 取消申请售后
     */
    public void refound_cancel_post(String ret_id) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("ret_id", ret_id);
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.refound_cancel_post)
                .showLoading()
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            CommonStatusSuccessBean bean = GsonUS.getIns().getGosn(response, CommonStatusSuccessBean.class);
                            if (bean != null && bean.getData().getCode() == 0) {
                                if (onQequestOrderCeancelListener != null) {
                                    onQequestOrderCeancelListener.OnQequestOrderCeancel(1);
                                }
                            } else {
                                if (onQequestOrderCeancelListener != null) {
                                    onQequestOrderCeancelListener.OnQequestOrderCeancel(0);
                                }
                                ToastUS.Error(bean.getData().getMessage());
                            }
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                if (onQequestOrderCeancelListener != null) {
                                    onQequestOrderCeancelListener.OnQequestOrderCeancel(1);
                                }
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

    /**
     * 取消订单
     */
    public void order_cancel_post(String order_id) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("order_id", order_id);
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.order_cancel_post)
                .showLoading()
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            CommonStatusSuccessBean bean = GsonUS.getIns().getGosn(response, CommonStatusSuccessBean.class);
                            if (bean != null && bean.getData().getCode() == 0) {
                                if (onOrderCeancelListener != null) {
                                    onOrderCeancelListener.OnOrderCeancel(1);
                                }
                            } else {
                                if (onOrderCeancelListener != null) {
                                    onOrderCeancelListener.OnOrderCeancel(0);
                                }
                                ToastUS.Error(bean.getData().getMessage());
                            }
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                if (onOrderCeancelListener != null) {
                                    onOrderCeancelListener.OnOrderCeancel(1);
                                }
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



    /**
     * 删除订单
     */
    public void order_delete_post(String order_id) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("order_id", order_id);
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.order_delete_post)
                .showLoading()
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
//                            CommonStatusSuccessBean bean = GsonUS.getIns().getGosn(response, CommonStatusSuccessBean.class);
//                            if (bean != null && bean.getData().getCode() == 0) {
//                                if (onOrderCeancelListener != null) {
//                                    onOrderCeancelListener.OnOrderCeancel(1);
//                                }
//                            } else {
//                                if (onOrderCeancelListener != null) {
//                                    onOrderCeancelListener.OnOrderCeancel(0);
//                                }
//                                ToastUS.Error(bean.getData().getMessage());
//                            }

                            if (onOrderDelListener != null) {
                                onOrderDelListener.OnOrderDel(1);
                            }
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                if (onOrderDelListener != null) {
                                    onOrderDelListener.OnOrderDel(0);
                                }
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

    /**
     * 计算商品运费 	{"province_id":370000,"city_id":370100,"district_id":370103,"street_id":""}
     */

    public void shipping_goodsshippingfee(String goods_id, String position) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("goods_id", goods_id);
        map.put("position", position);
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.shipping_goodsshippingfee_get)
                .setParamsMap(map)
                .getStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {

                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            GoodsshippingfeeBean bean_s = GsonUS.getIns().getGosn(response, GoodsshippingfeeBean.class);
                            if (valueChangeListener != null) {
                                valueChangeListener.OnValueChange(1, bean_s, "");
                            }
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {

                                CommonStatusErrorBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean.class);
                                ToastUS.Error(bean_e.getErrors().getMessage());
                                if (valueChangeListener != null) {
                                    valueChangeListener.OnValueChange(0, null, bean_e.getErrors().getMessage());
                                }
                            }
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                    }
                });
    }


    public void collect_collectshop_post(String ru_id) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("ru_id", ru_id);
        map.put("status", "1");
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.collect_collectshop_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {

                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            if (onShopCellectListener != null) {
                                onShopCellectListener.OnShopCellect(1);
                            }
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                CommonStatusErrorBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean.class);
                                ToastUS.Error(bean_e.getErrors().getMessage());
                                if (onShopCellectListener != null) {
                                    onShopCellectListener.OnShopCellect(0);
                                }
                            }
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                    }
                });
    }


    public interface OnValueChangeListener {
        void OnValueChange(int status, GoodsshippingfeeBean person, String msg);
    }

    public void setOnValueChangeListener(OnValueChangeListener dialogListener) {
        this.valueChangeListener = dialogListener;
    }

    private static OnValueChangeListener valueChangeListener;


    /**
     * 取消关注
     */
    public interface OnShopCellectListener {
        void OnShopCellect(int status);
    }

    public void setOnShopCellectListener(OnShopCellectListener dialogListener) {
        this.onShopCellectListener = dialogListener;
    }

    private static OnShopCellectListener onShopCellectListener;


    /**
     * 确认收货
     */
    public interface OnOrderConfirmListener {
        void OnOrderConfirm(int status);
    }

    public void setOnOrderConfirmListener(OnOrderConfirmListener dialogListener) {
        this.onOrderConfirmListener = dialogListener;
    }

    private static OnOrderConfirmListener onOrderConfirmListener;

    /**
     * 取消申请售后
     */
    public interface OnQequestOrderCeancelListener {
        void OnQequestOrderCeancel(int status);
    }

    public void setOnQequestOrderCeancelListener(OnQequestOrderCeancelListener dialogListener) {
        this.onQequestOrderCeancelListener = dialogListener;
    }

    private static OnQequestOrderCeancelListener onQequestOrderCeancelListener;




    /**
     * 取消订单
     */
    public interface OnOrderCeancelListener {
        void OnOrderCeancel(int status);
    }

    public void setOnOrderCeancelListener(OnOrderCeancelListener dialogListener) {
        this.onOrderCeancelListener = dialogListener;
    }

    private static OnOrderCeancelListener onOrderCeancelListener;



    /**
     * 删除订单
     */
    public interface OnOrderDelListener {
        void OnOrderDel(int status);
    }

    public void setOnOrderDellListener(OnOrderDelListener dialogListener) {
        this.onOrderDelListener = dialogListener;
    }

    private static OnOrderDelListener onOrderDelListener;

}

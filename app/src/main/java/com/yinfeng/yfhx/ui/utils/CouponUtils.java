package com.yinfeng.yfhx.ui.utils;

import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.entity.common.CommonExternalBean;
import com.yinfeng.yfhx.entity.common.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.CouponReceiveBean;
import com.yinfeng.yfhx.entity.Trade_change_bean;

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
public class CouponUtils {
    private static final CouponUtils ourInstance = new CouponUtils();

    public static CouponUtils getInstance() {
        return ourInstance;
    }

    private CouponUtils() {
    }

    /**
     * 添加购物车
     */
    public void coupon_receive(String cou_id) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("cou_id", cou_id);
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.coupon_receive_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            CouponReceiveBean bean_e = GsonUS.getIns().getGosn(response, CouponReceiveBean.class);
                            ToastUS.Error(bean_e.getData().getMsg());
                            if (receiveChangeListener != null) {
                                receiveChangeListener.OnReceiveChange(1);
                            }
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                CommonStatusErrorBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean.class);
                                ToastUS.Error(bean_e.getErrors().getMessage());
                                if (receiveChangeListener != null) {
                                    receiveChangeListener.OnReceiveChange(0);
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
     * 优惠券使用
     */
    public void trade_changecou_post(String uc_id, String jsonObject) {
        if (jsonObject == null) {
            ToastUS.Warning("json obj null");
            return;
        }
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("uc_id", uc_id);
        map.put("total", jsonObject.toString());

        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.trade_changecou_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            Trade_change_bean bean_e = GsonUS.getIns().getGosn(response, Trade_change_bean.class);
                            if (changeEcuListener != null) {
                                changeEcuListener.OnReceiveChangeEcu(1,bean_e);
                            }
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                CommonStatusErrorBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean.class);
                                ToastUS.Error(bean_e.getErrors().getMessage());
                                if (changeEcuListener != null) {
                                    changeEcuListener.OnReceiveChangeEcu(0,null);
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
     * 电子红包  储值卡使用
     */
    public void trade_changecard_post(String vid, String jsonObject) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("vid", vid);
        map.put("total", jsonObject.toString());
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.trade_changecard_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            Trade_change_bean bean_e = GsonUS.getIns().getGosn(response, Trade_change_bean.class);
                            if (cardListener != null) {
                                cardListener.OnReceiveChangeCard(1,bean_e);
                            }
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                CommonStatusErrorBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean.class);
                                ToastUS.Error(bean_e.getErrors().getMessage());
                                if (cardListener != null) {
                                    cardListener.OnReceiveChangeCard(0,null);
                                }
                            }
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                    }
                });
    }


    public interface OnReceiveChangeListener {
        void OnReceiveChange(int status);
    }

    public void setOnValueChangeListener(OnReceiveChangeListener dialogListener) {
        this.receiveChangeListener = dialogListener;
    }

    private static OnReceiveChangeListener receiveChangeListener;




    public interface OnReceiveChangeEcuListener {
        void OnReceiveChangeEcu(int status, Trade_change_bean bean);
    }

    public void setOnChangeEcuListener(OnReceiveChangeEcuListener dialogListener) {
        this.changeEcuListener = dialogListener;
    }

    private static OnReceiveChangeEcuListener changeEcuListener;



    public interface OnReceiveChangeCardListener {
        void OnReceiveChangeCard(int status, Trade_change_bean bean);
    }

    public void setOnChangeCardListener(OnReceiveChangeCardListener dialogListener) {
        this.cardListener = dialogListener;
    }

    private static OnReceiveChangeCardListener cardListener;

}

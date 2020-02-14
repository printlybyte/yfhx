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
import com.yinfeng.yfhx.entity.pay.WxPayDateBean;
import com.yinfeng.yfhx.entity.pay.WxPayResultBean;

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
public class PayUtils {
    private static final PayUtils ourInstance = new PayUtils();

    public static PayUtils getInstance() {
        return ourInstance;
    }

    private PayUtils() {
    }


    public void payment(String order_sn, String log_id, String order_amount) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("order_sn", order_sn);//订单编号
        map.put("log_id", log_id);//	订单日志ID
        map.put("payment_id", "20");//20（代表微信支付）
        map.put("order_amount", order_amount);
        map.put("platform", "APP");
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.payment_code_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        WxPayResultBean beanx = GsonUS.getIns().getGosn(response, WxPayResultBean.class);
                        if (beanx.getStatus().equals("success")) {
                            WxPayDateBean wxPayDateBean = GsonUS.getIns().getGosn(beanx.getData(), WxPayDateBean.class);
                            ToastUS.Error(wxPayDateBean.getAppid());
                            if (payChangeListener != null) {
                                payChangeListener.OnPayChange(1,wxPayDateBean,"");
                            }
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                CommonStatusErrorBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean.class);
                                ToastUS.Error(bean_e.getErrors().getMessage());
                                if (payChangeListener != null) {
                                    payChangeListener.OnPayChange(1,null,bean_e.getErrors().getMessage());
                                }
                            }
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {

                    }
                });
    }


    public interface OnPayChangeListener {
        void OnPayChange(int status, WxPayDateBean person, String msg);
    }

    public void setOnPayChangeListener(OnPayChangeListener dialogListener) {
        this.payChangeListener = dialogListener;
    }

    private static OnPayChangeListener payChangeListener;


//    /**
//     * 取消关注
//     */
//    public interface OnShopCellectListener {
//        void OnShopCellect(int status);
//    }
//
//    public void setOnShopCellectListener(OnShopCellectListener dialogListener) {
//        this.onShopCellectListener = dialogListener;
//    }
//
//    private static OnShopCellectListener onShopCellectListener;

}

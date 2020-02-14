package com.yinfeng.yfhx.entity.pay;

import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity.pay
 * 类  名：PaycheckBean
 * 创建人：liuguodong
 * 创建时间：2020/1/2 16:28
 * ============================================
 **/
public class PaycheckBean {

    /**
     * status : success
     * data : {"order_sn":"2020010216265083173","pay_name":"在线支付","pay_code":"onlinepay","pay_desc":"想要使用在线支付的一系列方法如支付宝,余额支付,就必须安装该插件,否则订单结算页不会显示\"在线支付\"按钮","is_surplus":0,"is_online":0,"pay_result":0,"cod_fee":0,"support_cod":0,"pay_status":0,"order_id":28875,"order_amount":"4.00","order_amount_format":"¥4.00","child_order":0,"child_order_info":[],"store_info":[],"extension_code":"","log_id":1168}
     * time : 1577953314
     * timestamp : 1.577953314665977E9
     */

    private String status;
    private DataBean data;
    private int time;
    private double timestamp;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }

    public static class DataBean {
        /**
         * order_sn : 2020010216265083173
         * pay_name : 在线支付
         * pay_code : onlinepay
         * pay_desc : 想要使用在线支付的一系列方法如支付宝,余额支付,就必须安装该插件,否则订单结算页不会显示"在线支付"按钮
         * is_surplus : 0
         * is_online : 0
         * pay_result : 0
         * cod_fee : 0
         * support_cod : 0
         * pay_status : 0
         * order_id : 28875
         * order_amount : 4.00
         * order_amount_format : ¥4.00
         * child_order : 0
         * child_order_info : []
         * store_info : []
         * extension_code :
         * log_id : 1168
         */

        private String order_sn;
        private String pay_name;
        private String pay_code;
        private String pay_desc;
        private int is_surplus;
        private int is_online;
        private int pay_result;
        private int cod_fee;
        private int support_cod;
        private int pay_status;
        private int order_id;
        private String order_amount;
        private String order_amount_format;
        private int child_order;
        private String extension_code;
        private int log_id;
        private List<?> child_order_info;
        private List<?> store_info;

        public String getOrder_sn() {
            return order_sn;
        }

        public void setOrder_sn(String order_sn) {
            this.order_sn = order_sn;
        }

        public String getPay_name() {
            return pay_name;
        }

        public void setPay_name(String pay_name) {
            this.pay_name = pay_name;
        }

        public String getPay_code() {
            return pay_code;
        }

        public void setPay_code(String pay_code) {
            this.pay_code = pay_code;
        }

        public String getPay_desc() {
            return pay_desc;
        }

        public void setPay_desc(String pay_desc) {
            this.pay_desc = pay_desc;
        }

        public int getIs_surplus() {
            return is_surplus;
        }

        public void setIs_surplus(int is_surplus) {
            this.is_surplus = is_surplus;
        }

        public int getIs_online() {
            return is_online;
        }

        public void setIs_online(int is_online) {
            this.is_online = is_online;
        }

        public int getPay_result() {
            return pay_result;
        }

        public void setPay_result(int pay_result) {
            this.pay_result = pay_result;
        }

        public int getCod_fee() {
            return cod_fee;
        }

        public void setCod_fee(int cod_fee) {
            this.cod_fee = cod_fee;
        }

        public int getSupport_cod() {
            return support_cod;
        }

        public void setSupport_cod(int support_cod) {
            this.support_cod = support_cod;
        }

        public int getPay_status() {
            return pay_status;
        }

        public void setPay_status(int pay_status) {
            this.pay_status = pay_status;
        }

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public String getOrder_amount() {
            return order_amount;
        }

        public void setOrder_amount(String order_amount) {
            this.order_amount = order_amount;
        }

        public String getOrder_amount_format() {
            return order_amount_format;
        }

        public void setOrder_amount_format(String order_amount_format) {
            this.order_amount_format = order_amount_format;
        }

        public int getChild_order() {
            return child_order;
        }

        public void setChild_order(int child_order) {
            this.child_order = child_order;
        }

        public String getExtension_code() {
            return extension_code;
        }

        public void setExtension_code(String extension_code) {
            this.extension_code = extension_code;
        }

        public int getLog_id() {
            return log_id;
        }

        public void setLog_id(int log_id) {
            this.log_id = log_id;
        }

        public List<?> getChild_order_info() {
            return child_order_info;
        }

        public void setChild_order_info(List<?> child_order_info) {
            this.child_order_info = child_order_info;
        }

        public List<?> getStore_info() {
            return store_info;
        }

        public void setStore_info(List<?> store_info) {
            this.store_info = store_info;
        }
    }
}

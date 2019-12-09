package com.yinfeng.yfhx.entity.details;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity.details
 * 类  名：GoodsshippingfeeBean
 * 创建人：liuguodong
 * 创建时间：2019/11/27 10:13
 * ============================================
 **/
public class GoodsshippingfeeBean {

    /**
     * status : success
     * data : {"shipping_id":"54","shipping_code":"","shipping_name":"","shipping_type":"0","shipping_fee":"0.00","shipping_fee_formated":"¥0.00","free_money":"","is_shipping":1,"shipping_title":"免邮"}
     * time : 1571385980
     * timestamp : 1.571385980003946E9
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
         * shipping_id : 54
         * shipping_code :
         * shipping_name :
         * shipping_type : 0
         * shipping_fee : 0.00
         * shipping_fee_formated : ¥0.00
         * free_money :
         * is_shipping : 1
         * shipping_title : 免邮
         */

        private String shipping_id;
        private String shipping_code;
        private String shipping_name;
        private String shipping_type;
        private String shipping_fee;
        private String shipping_fee_formated;
        private String free_money;
        private int is_shipping;
        private String shipping_title;

        public String getShipping_id() {
            return shipping_id;
        }

        public void setShipping_id(String shipping_id) {
            this.shipping_id = shipping_id;
        }

        public String getShipping_code() {
            return shipping_code;
        }

        public void setShipping_code(String shipping_code) {
            this.shipping_code = shipping_code;
        }

        public String getShipping_name() {
            return shipping_name;
        }

        public void setShipping_name(String shipping_name) {
            this.shipping_name = shipping_name;
        }

        public String getShipping_type() {
            return shipping_type;
        }

        public void setShipping_type(String shipping_type) {
            this.shipping_type = shipping_type;
        }

        public String getShipping_fee() {
            return shipping_fee;
        }

        public void setShipping_fee(String shipping_fee) {
            this.shipping_fee = shipping_fee;
        }

        public String getShipping_fee_formated() {
            return shipping_fee_formated;
        }

        public void setShipping_fee_formated(String shipping_fee_formated) {
            this.shipping_fee_formated = shipping_fee_formated;
        }

        public String getFree_money() {
            return free_money;
        }

        public void setFree_money(String free_money) {
            this.free_money = free_money;
        }

        public int getIs_shipping() {
            return is_shipping;
        }

        public void setIs_shipping(int is_shipping) {
            this.is_shipping = is_shipping;
        }

        public String getShipping_title() {
            return shipping_title;
        }

        public void setShipping_title(String shipping_title) {
            this.shipping_title = shipping_title;
        }
    }
}

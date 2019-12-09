package com.yinfeng.yfhx.entity;

import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity
 * 类  名：TAB3CounterUpdateBean
 * 创建人：liuguodong
 * 创建时间：2019/10/18 16:29
 * ============================================
 **/
public class TAB3CounterUpdateBean {


    /**
     * status : success
     * data : {"error":0,"rec_goods":33,"save_total_amount":"¥0.00","dis_amount":0,"goods_amount":30901.5,"goods_amount_formated":"¥30901.50","cart_number":13,"discount":0,"goods_price":0,"goods_price_formated":"¥0.00","discount_formated":"¥0.00","group":[],"checked_rec_id":[1737,1739,1780]}
     * time : 1573106490
     * timestamp : 1.573106490228756E9
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
         * error : 0
         * rec_goods : 33
         * save_total_amount : ¥0.00
         * dis_amount : 0
         * goods_amount : 30901.5
         * goods_amount_formated : ¥30901.50
         * cart_number : 13
         * discount : 0
         * goods_price : 0
         * goods_price_formated : ¥0.00
         * discount_formated : ¥0.00
         * group : []
         * checked_rec_id : [1737,1739,1780]
         */

        private int error;
        private int rec_goods;
        private String save_total_amount;
        private int dis_amount;
        private String goods_amount;
        private String goods_amount_formated;
        private int cart_number;
        private int discount;
        private int goods_price;
        private String goods_price_formated;
        private String discount_formated;
        private List<?> group;
        private List<Integer> checked_rec_id;

        public int getError() {
            return error;
        }

        public void setError(int error) {
            this.error = error;
        }

        public int getRec_goods() {
            return rec_goods;
        }

        public void setRec_goods(int rec_goods) {
            this.rec_goods = rec_goods;
        }

        public String getSave_total_amount() {
            return save_total_amount;
        }

        public void setSave_total_amount(String save_total_amount) {
            this.save_total_amount = save_total_amount;
        }

        public int getDis_amount() {
            return dis_amount;
        }

        public void setDis_amount(int dis_amount) {
            this.dis_amount = dis_amount;
        }

        public String getGoods_amount() {
            return goods_amount;
        }

        public void setGoods_amount(String goods_amount) {
            this.goods_amount = goods_amount;
        }

        public String getGoods_amount_formated() {
            return goods_amount_formated;
        }

        public void setGoods_amount_formated(String goods_amount_formated) {
            this.goods_amount_formated = goods_amount_formated;
        }

        public int getCart_number() {
            return cart_number;
        }

        public void setCart_number(int cart_number) {
            this.cart_number = cart_number;
        }

        public int getDiscount() {
            return discount;
        }

        public void setDiscount(int discount) {
            this.discount = discount;
        }

        public int getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(int goods_price) {
            this.goods_price = goods_price;
        }

        public String getGoods_price_formated() {
            return goods_price_formated;
        }

        public void setGoods_price_formated(String goods_price_formated) {
            this.goods_price_formated = goods_price_formated;
        }

        public String getDiscount_formated() {
            return discount_formated;
        }

        public void setDiscount_formated(String discount_formated) {
            this.discount_formated = discount_formated;
        }

        public List<?> getGroup() {
            return group;
        }

        public void setGroup(List<?> group) {
            this.group = group;
        }

        public List<Integer> getChecked_rec_id() {
            return checked_rec_id;
        }

        public void setChecked_rec_id(List<Integer> checked_rec_id) {
            this.checked_rec_id = checked_rec_id;
        }
    }
}

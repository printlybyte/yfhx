package com.yinfeng.yfhx.entity.t3;

import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity
 * 类  名：ShopCarCartValueBean
 * 创建人：liuguodong
 * 创建时间：2019/11/4 11:39
 * ============================================
 **/
public class ShopCarCartValueBean {


    /**
     * status : success
     * data : {"error":0,"cart_number":9,"goods_amount":85410,"rec_id":[1807,1808,1809,1811],"save_total_amount":"¥0.00","dis_amount":0,"goods_amount_formated":"¥85410.00","discount":0,"discount_formated":"¥0.00","unselected":0}
     * time : 1573116758
     * timestamp : 1.573116758727493E9
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
         * cart_number : 9
         * goods_amount : 85410
         * rec_id : [1807,1808,1809,1811]
         * save_total_amount : ¥0.00
         * dis_amount : 0
         * goods_amount_formated : ¥85410.00
         * discount : 0
         * discount_formated : ¥0.00
         * unselected : 0
         */

        private int error;
        private int cart_number;
        private String goods_amount;
        private String save_total_amount;
        private int dis_amount;
        private String goods_amount_formated;
        private String discount;
        private String discount_formated;
        private int unselected;
        private List<Integer> rec_id;

        public int getError() {
            return error;
        }

        public void setError(int error) {
            this.error = error;
        }

        public int getCart_number() {
            return cart_number;
        }

        public void setCart_number(int cart_number) {
            this.cart_number = cart_number;
        }

        public String getGoods_amount() {
            return goods_amount;
        }

        public void setGoods_amount(String goods_amount) {
            this.goods_amount = goods_amount;
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

        public String getGoods_amount_formated() {
            return goods_amount_formated;
        }

        public void setGoods_amount_formated(String goods_amount_formated) {
            this.goods_amount_formated = goods_amount_formated;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getDiscount_formated() {
            return discount_formated;
        }

        public void setDiscount_formated(String discount_formated) {
            this.discount_formated = discount_formated;
        }

        public int getUnselected() {
            return unselected;
        }

        public void setUnselected(int unselected) {
            this.unselected = unselected;
        }

        public List<Integer> getRec_id() {
            return rec_id;
        }

        public void setRec_id(List<Integer> rec_id) {
            this.rec_id = rec_id;
        }
    }
}

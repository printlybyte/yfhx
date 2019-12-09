package com.yinfeng.yfhx.entity;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity
 * 类  名：Trade_change_bean
 * 创建人：liuguodong
 * 创建时间：2019/12/5 17:16
 * ============================================
 **/
public class Trade_done_bean {


    /**
     * status : success
     * data : {"order_sn":"2019120914494265099","amount":"5149.00"}
     * time : 1575873974
     * timestamp : 1.575873974936907E9
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
         * order_sn : 2019120914494265099
         * amount : 5149.00
         */

        private String order_sn;
        private String amount;

        public String getOrder_sn() {
            return order_sn;
        }

        public void setOrder_sn(String order_sn) {
            this.order_sn = order_sn;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }
    }
}

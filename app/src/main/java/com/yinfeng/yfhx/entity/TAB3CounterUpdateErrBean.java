package com.yinfeng.yfhx.entity;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity
 * 类  名：TAB3CounterUpdateBean
 * 创建人：liuguodong
 * 创建时间：2019/10/18 16:29
 * ============================================
 **/
public class TAB3CounterUpdateErrBean {


    /**
     * status : success
     * data : {"error":1,"number":5,"msg":"非常抱歉，您选择的商品 儿童水杯 的数量只有 5 件，您最多只能购买 5 件。"}
     * time : 1573111435
     * timestamp : 1.573111435829015E9
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
         * error : 1
         * number : 5
         * msg : 非常抱歉，您选择的商品 儿童水杯 的数量只有 5 件，您最多只能购买 5 件。
         */

        private int error;
        private int number;
        private String msg;

        public int getError() {
            return error;
        }

        public void setError(int error) {
            this.error = error;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}

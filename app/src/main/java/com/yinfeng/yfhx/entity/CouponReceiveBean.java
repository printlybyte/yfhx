package com.yinfeng.yfhx.entity;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx
 * 类  名：CouponReceiveBean
 * 创建人：liuguodong
 * 创建时间：2019/11/29 14:21
 * ============================================
 **/
public class CouponReceiveBean {

    /**
     * status : success
     * data : {"error":1,"msg":"领取成功！感谢您的参与，祝您购物愉快~"}
     * time : 1571651511
     * timestamp : 1.571651511686012E9
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
         * msg : 领取成功！感谢您的参与，祝您购物愉快~
         */

        private int error;
        private String msg;

        public int getError() {
            return error;
        }

        public void setError(int error) {
            this.error = error;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}

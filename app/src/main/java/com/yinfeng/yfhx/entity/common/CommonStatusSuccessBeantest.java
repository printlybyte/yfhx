package com.yinfeng.yfhx.entity.common;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity
 * 类  名：CommonStatusSuccessBean
 * 创建人：liuguodong
 * 创建时间：2019/10/12 17:46
 * ============================================
 **/
public class CommonStatusSuccessBeantest {

    /**
     * status : success
     * data : {"error":1,"msg":"请选择配送方式"}
     * time : 1575627349
     * timestamp : 1.575627349578949E9
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
         * msg : 请选择配送方式
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

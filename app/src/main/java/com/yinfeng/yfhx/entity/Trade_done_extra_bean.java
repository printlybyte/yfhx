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
public class Trade_done_extra_bean {


    /**
     * status : success
     * data : {"error":1}
     */

    private String status;
    private DataBean data;

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

    public static class DataBean {
        /**
         * error : 1
         */

        private int error;

        public int getError() {
            return error;
        }

        public void setError(int error) {
            this.error = error;
        }
    }
}

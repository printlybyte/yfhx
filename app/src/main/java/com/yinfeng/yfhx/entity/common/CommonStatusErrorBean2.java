package com.yinfeng.yfhx.entity.common;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity.common
 * 类  名：CommonStatusErrorBean2
 * 创建人：liuguodong
 * 创建时间：2020/1/3 11:46
 * ============================================
 **/
public class CommonStatusErrorBean2 {

    /**
     * status : failed
     * code : 102
     * errors : {"code":200,"message":"找不到该用户，请使用手机号登录"}
     * time : 1578019783
     */

    private String status;
    private int code;
    private ErrorsBean errors;
    private int time;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ErrorsBean getErrors() {
        return errors;
    }

    public void setErrors(ErrorsBean errors) {
        this.errors = errors;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public static class ErrorsBean {
        /**
         * code : 200
         * message : 找不到该用户，请使用手机号登录
         */

        private int code;
        private String message;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}

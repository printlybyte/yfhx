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
public class CommonStatusErrorBean {


    /**
     * status : failed
     * errors : {"code":0,"message":"The given data was invalid."}
     * time : 1571021826
     */

    private String status;
    private ErrorsBean errors;
    private int time;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
         * code : 0
         * message : The given data was invalid.
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

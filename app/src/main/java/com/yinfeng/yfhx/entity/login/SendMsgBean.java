package com.yinfeng.yfhx.entity.login;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity.login
 * 类  名：SendMsgBean
 * 创建人：liuguodong
 * 创建时间：2019/10/30 14:14
 * ============================================
 **/
public class SendMsgBean {

    /**
     * status : success
     * data : {"status":"success","result":{"msg":"提交成功"},"cache":794658}
     * time : 1572415935
     * timestamp : 1.572415935815804E9
     */

    private String status;
    private DataBean data;
    private int time;
    private double timestamp;
    /**
     * code : 100
     * errors : {"code":200,"message":"手机 不能为空。"}
     */

    private int code;
    private ErrorsBean errors;

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

    public static class DataBean {
        /**
         * status : success
         * result : {"msg":"提交成功"}
         * cache : 794658
         */

        private String status;
        private ResultBean result;
        private int cache;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public ResultBean getResult() {
            return result;
        }

        public void setResult(ResultBean result) {
            this.result = result;
        }

        public int getCache() {
            return cache;
        }

        public void setCache(int cache) {
            this.cache = cache;
        }

        public static class ResultBean {
            /**
             * msg : 提交成功
             */

            private String msg;

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }
        }
    }

    public static class ErrorsBean {
        /**
         * code : 200
         * message : 手机 不能为空。
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

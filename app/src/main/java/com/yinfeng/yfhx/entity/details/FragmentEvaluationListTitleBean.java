package com.yinfeng.yfhx.entity.details;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity
 * 类  名：FragmentEvaluationListTitleBean
 * 创建人：liuguodong
 * 创建时间：2019/11/15 10:35
 * ============================================
 **/
public class FragmentEvaluationListTitleBean {

    /**
     * status : success
     * data : {"all":0,"good":0,"in":0,"rotten":0,"img":0}
     * time : 1571394142
     * timestamp : 1.571394142861685E9
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
         * all : 0
         * good : 0
         * in : 0
         * rotten : 0
         * img : 0
         */

        private int all;
        private int good;
        private int in;
        private int rotten;
        private int img;

        public int getAll() {
            return all;
        }

        public void setAll(int all) {
            this.all = all;
        }

        public int getGood() {
            return good;
        }

        public void setGood(int good) {
            this.good = good;
        }

        public int getIn() {
            return in;
        }

        public void setIn(int in) {
            this.in = in;
        }

        public int getRotten() {
            return rotten;
        }

        public void setRotten(int rotten) {
            this.rotten = rotten;
        }

        public int getImg() {
            return img;
        }

        public void setImg(int img) {
            this.img = img;
        }
    }
}

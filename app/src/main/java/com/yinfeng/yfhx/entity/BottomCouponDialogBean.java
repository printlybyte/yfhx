package com.yinfeng.yfhx.entity;

import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity
 * 类  名：BottomCouponDialogBean
 * 创建人：liuguodong
 * 创建时间：2019/12/5 10:18
 * ============================================
 **/
public class BottomCouponDialogBean {

    /**
     * status : success
     * data : [{"cou_id":23,"cou_name":"满5899减1770","cou_total":500,"cou_man":"5899","cou_money":"1770","cou_user_num":5,"cou_goods":"5337","spec_cat":"","cou_start_time":"2019.06.13","cou_end_time":"2020.06.13","cou_type":3,"cou_get_man":"0","cou_ok_user":"9","cou_ok_goods":"0","cou_ok_cat":"","cou_intro":"","cou_add_time":1560391996,"ru_id":50059,"cou_order":0,"cou_title":"320WPQC冰箱","review_status":3,"review_content":"","cou_is_receive":0,"enable_ling":0}]
     * time : 1571906969
     * timestamp : 1.571906969695536E9
     */

    private String status;
    private int time;
    private double timestamp;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cou_id : 23
         * cou_name : 满5899减1770
         * cou_total : 500
         * cou_man : 5899
         * cou_money : 1770
         * cou_user_num : 5
         * cou_goods : 5337
         * spec_cat :
         * cou_start_time : 2019.06.13
         * cou_end_time : 2020.06.13
         * cou_type : 3
         * cou_get_man : 0
         * cou_ok_user : 9
         * cou_ok_goods : 0
         * cou_ok_cat :
         * cou_intro :
         * cou_add_time : 1560391996
         * ru_id : 50059
         * cou_order : 0
         * cou_title : 320WPQC冰箱
         * review_status : 3
         * review_content :
         * cou_is_receive : 0
         * enable_ling : 0
         */

        private int cou_id;
        private String cou_name;
        private int cou_total;
        private String cou_man;
        private String cou_money;
        private int cou_user_num;
        private String cou_goods;
        private String spec_cat;
        private String cou_start_time;
        private String cou_end_time;
        private int cou_type;
        private String cou_get_man;
        private String cou_ok_user;
        private String cou_ok_goods;
        private String cou_ok_cat;
        private String cou_intro;
        private int cou_add_time;
        private int ru_id;
        private int cou_order;
        private String cou_title;
        private int review_status;
        private String review_content;
        private int cou_is_receive;
        private int enable_ling;

        public int getCou_id() {
            return cou_id;
        }

        public void setCou_id(int cou_id) {
            this.cou_id = cou_id;
        }

        public String getCou_name() {
            return cou_name;
        }

        public void setCou_name(String cou_name) {
            this.cou_name = cou_name;
        }

        public int getCou_total() {
            return cou_total;
        }

        public void setCou_total(int cou_total) {
            this.cou_total = cou_total;
        }

        public String getCou_man() {
            return cou_man;
        }

        public void setCou_man(String cou_man) {
            this.cou_man = cou_man;
        }

        public String getCou_money() {
            return cou_money;
        }

        public void setCou_money(String cou_money) {
            this.cou_money = cou_money;
        }

        public int getCou_user_num() {
            return cou_user_num;
        }

        public void setCou_user_num(int cou_user_num) {
            this.cou_user_num = cou_user_num;
        }

        public String getCou_goods() {
            return cou_goods;
        }

        public void setCou_goods(String cou_goods) {
            this.cou_goods = cou_goods;
        }

        public String getSpec_cat() {
            return spec_cat;
        }

        public void setSpec_cat(String spec_cat) {
            this.spec_cat = spec_cat;
        }

        public String getCou_start_time() {
            return cou_start_time;
        }

        public void setCou_start_time(String cou_start_time) {
            this.cou_start_time = cou_start_time;
        }

        public String getCou_end_time() {
            return cou_end_time;
        }

        public void setCou_end_time(String cou_end_time) {
            this.cou_end_time = cou_end_time;
        }

        public int getCou_type() {
            return cou_type;
        }

        public void setCou_type(int cou_type) {
            this.cou_type = cou_type;
        }

        public String getCou_get_man() {
            return cou_get_man;
        }

        public void setCou_get_man(String cou_get_man) {
            this.cou_get_man = cou_get_man;
        }

        public String getCou_ok_user() {
            return cou_ok_user;
        }

        public void setCou_ok_user(String cou_ok_user) {
            this.cou_ok_user = cou_ok_user;
        }

        public String getCou_ok_goods() {
            return cou_ok_goods;
        }

        public void setCou_ok_goods(String cou_ok_goods) {
            this.cou_ok_goods = cou_ok_goods;
        }

        public String getCou_ok_cat() {
            return cou_ok_cat;
        }

        public void setCou_ok_cat(String cou_ok_cat) {
            this.cou_ok_cat = cou_ok_cat;
        }

        public String getCou_intro() {
            return cou_intro;
        }

        public void setCou_intro(String cou_intro) {
            this.cou_intro = cou_intro;
        }

        public int getCou_add_time() {
            return cou_add_time;
        }

        public void setCou_add_time(int cou_add_time) {
            this.cou_add_time = cou_add_time;
        }

        public int getRu_id() {
            return ru_id;
        }

        public void setRu_id(int ru_id) {
            this.ru_id = ru_id;
        }

        public int getCou_order() {
            return cou_order;
        }

        public void setCou_order(int cou_order) {
            this.cou_order = cou_order;
        }

        public String getCou_title() {
            return cou_title;
        }

        public void setCou_title(String cou_title) {
            this.cou_title = cou_title;
        }

        public int getReview_status() {
            return review_status;
        }

        public void setReview_status(int review_status) {
            this.review_status = review_status;
        }

        public String getReview_content() {
            return review_content;
        }

        public void setReview_content(String review_content) {
            this.review_content = review_content;
        }

        public int getCou_is_receive() {
            return cou_is_receive;
        }

        public void setCou_is_receive(int cou_is_receive) {
            this.cou_is_receive = cou_is_receive;
        }

        public int getEnable_ling() {
            return enable_ling;
        }

        public void setEnable_ling(int enable_ling) {
            this.enable_ling = enable_ling;
        }
    }
}

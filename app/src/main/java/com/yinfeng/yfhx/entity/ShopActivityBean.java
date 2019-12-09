package com.yinfeng.yfhx.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity
 * 类  名：ShopActivityBean
 * 创建人：liuguodong
 * 创建时间：2019/11/27 16:52
 * ============================================
 **/
public class ShopActivityBean {

    /**
     * status : success
     * data : [{"shop_id":59,"user_id":50080,"rz_shopName":"果果蔬菜店","logo_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/seller_imgs/seller_logo/logo_thumb/1560126731502196922.jpg","street_thumb":"http://kaifa.yinfengnet.com/img/no_image.jpg","shop_banner":["http://kaifa.yinfengnet.com/storage/images/shop_banner.png"],"shop_top":"http://kaifa.yinfengnet.com/storage/images/shop_top.png","total":7,"new":3,"promote":0,"count_gaze":0,"like_num":2}]
     * time : 1574842856
     * timestamp : 1.574842856173562E9
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
         * shop_id : 59
         * user_id : 50080
         * rz_shopName : 果果蔬菜店
         * logo_thumb : http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/seller_imgs/seller_logo/logo_thumb/1560126731502196922.jpg
         * street_thumb : http://kaifa.yinfengnet.com/img/no_image.jpg
         * shop_banner : ["http://kaifa.yinfengnet.com/storage/images/shop_banner.png"]
         * shop_top : http://kaifa.yinfengnet.com/storage/images/shop_top.png
         * total : 7
         * new : 3
         * promote : 0
         * count_gaze : 0
         * like_num : 2
         */

        private int shop_id;
        private int user_id;
        private String rz_shopName;
        private String logo_thumb;
        private String street_thumb;
        private String shop_top;
        private int total;
        @SerializedName("new")
        private int newX;
        private int promote;
        private int count_gaze;
        private int like_num;
        private List<String> shop_banner;

        public int getShop_id() {
            return shop_id;
        }

        public void setShop_id(int shop_id) {
            this.shop_id = shop_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getRz_shopName() {
            return rz_shopName;
        }

        public void setRz_shopName(String rz_shopName) {
            this.rz_shopName = rz_shopName;
        }

        public String getLogo_thumb() {
            return logo_thumb;
        }

        public void setLogo_thumb(String logo_thumb) {
            this.logo_thumb = logo_thumb;
        }

        public String getStreet_thumb() {
            return street_thumb;
        }

        public void setStreet_thumb(String street_thumb) {
            this.street_thumb = street_thumb;
        }

        public String getShop_top() {
            return shop_top;
        }

        public void setShop_top(String shop_top) {
            this.shop_top = shop_top;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getNewX() {
            return newX;
        }

        public void setNewX(int newX) {
            this.newX = newX;
        }

        public int getPromote() {
            return promote;
        }

        public void setPromote(int promote) {
            this.promote = promote;
        }

        public int getCount_gaze() {
            return count_gaze;
        }

        public void setCount_gaze(int count_gaze) {
            this.count_gaze = count_gaze;
        }

        public int getLike_num() {
            return like_num;
        }

        public void setLike_num(int like_num) {
            this.like_num = like_num;
        }

        public List<String> getShop_banner() {
            return shop_banner;
        }

        public void setShop_banner(List<String> shop_banner) {
            this.shop_banner = shop_banner;
        }
    }
}

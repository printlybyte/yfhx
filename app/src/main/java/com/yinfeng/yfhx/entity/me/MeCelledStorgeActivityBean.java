package com.yinfeng.yfhx.entity.me;

import java.util.List;

public class MeCelledStorgeActivityBean {


    /**
     * status : success
     * data : [{"collect_number":1,"rec_id":24,"shoprz_brandName":"","shopNameSuffix":"专营店","cancel_collect_shop":"http://kaifa.yinfengnet.com/api/v4/collect/collectshop?rec_id=24","shop_id":50053,"store_name":"雅文家居用品专营店","shop_bg_logo":"http://kaifa.yinfengnet.com/storage/images/errorImg.png","shop_logo":"http://kaifa.yinfengnet.com/storage/images/errorImg.png","count_store":1,"add_time":"2019-12-09","kf_type":0,"kf_ww":"","kf_qq":"","ru_id":50053,"brand_thumb":"http://kaifa.yinfengnet.com/storage/images/errorImg.png","url":"http://kaifa.yinfengnet.com/api/v4/store/storedetail?id=50053"}]
     * time : 1575880421
     * timestamp : 1.575880421102216E9
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
         * collect_number : 1
         * rec_id : 24
         * shoprz_brandName :
         * shopNameSuffix : 专营店
         * cancel_collect_shop : http://kaifa.yinfengnet.com/api/v4/collect/collectshop?rec_id=24
         * shop_id : 50053
         * store_name : 雅文家居用品专营店
         * shop_bg_logo : http://kaifa.yinfengnet.com/storage/images/errorImg.png
         * shop_logo : http://kaifa.yinfengnet.com/storage/images/errorImg.png
         * count_store : 1
         * add_time : 2019-12-09
         * kf_type : 0
         * kf_ww :
         * kf_qq :
         * ru_id : 50053
         * brand_thumb : http://kaifa.yinfengnet.com/storage/images/errorImg.png
         * url : http://kaifa.yinfengnet.com/api/v4/store/storedetail?id=50053
         */

        private int collect_number;
        private int rec_id;
        private String shoprz_brandName;
        private String shopNameSuffix;
        private String cancel_collect_shop;
        private int shop_id;
        private String store_name;
        private String shop_bg_logo;
        private String shop_logo;
        private int count_store;
        private String add_time;
        private int kf_type;
        private String kf_ww;
        private String kf_qq;
        private int ru_id;
        private String brand_thumb;
        private String url;

        public int getCollect_number() {
            return collect_number;
        }

        public void setCollect_number(int collect_number) {
            this.collect_number = collect_number;
        }

        public int getRec_id() {
            return rec_id;
        }

        public void setRec_id(int rec_id) {
            this.rec_id = rec_id;
        }

        public String getShoprz_brandName() {
            return shoprz_brandName;
        }

        public void setShoprz_brandName(String shoprz_brandName) {
            this.shoprz_brandName = shoprz_brandName;
        }

        public String getShopNameSuffix() {
            return shopNameSuffix;
        }

        public void setShopNameSuffix(String shopNameSuffix) {
            this.shopNameSuffix = shopNameSuffix;
        }

        public String getCancel_collect_shop() {
            return cancel_collect_shop;
        }

        public void setCancel_collect_shop(String cancel_collect_shop) {
            this.cancel_collect_shop = cancel_collect_shop;
        }

        public int getShop_id() {
            return shop_id;
        }

        public void setShop_id(int shop_id) {
            this.shop_id = shop_id;
        }

        public String getStore_name() {
            return store_name;
        }

        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }

        public String getShop_bg_logo() {
            return shop_bg_logo;
        }

        public void setShop_bg_logo(String shop_bg_logo) {
            this.shop_bg_logo = shop_bg_logo;
        }

        public String getShop_logo() {
            return shop_logo;
        }

        public void setShop_logo(String shop_logo) {
            this.shop_logo = shop_logo;
        }

        public int getCount_store() {
            return count_store;
        }

        public void setCount_store(int count_store) {
            this.count_store = count_store;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public int getKf_type() {
            return kf_type;
        }

        public void setKf_type(int kf_type) {
            this.kf_type = kf_type;
        }

        public String getKf_ww() {
            return kf_ww;
        }

        public void setKf_ww(String kf_ww) {
            this.kf_ww = kf_ww;
        }

        public String getKf_qq() {
            return kf_qq;
        }

        public void setKf_qq(String kf_qq) {
            this.kf_qq = kf_qq;
        }

        public int getRu_id() {
            return ru_id;
        }

        public void setRu_id(int ru_id) {
            this.ru_id = ru_id;
        }

        public String getBrand_thumb() {
            return brand_thumb;
        }

        public void setBrand_thumb(String brand_thumb) {
            this.brand_thumb = brand_thumb;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
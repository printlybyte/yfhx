package com.yinfeng.yfhx.entity.me;

import java.util.List;

public class MeCelledGoodsActivityBean {

    /**
     * status : success
     * data : [{"goods_number":998,"on_sale":1,"rec_id":29,"is_attention":1,"goods_id":5144,"shop_name":"雅文家居用品专营店","is_IM":0,"is_dsc":false,"add_time":"2019-06-05 08:48:57","goods_name":"外交官儿童经典款拉杆（蓝色有货）","market_price":"¥988.00","shop_price":"¥329.00","promote_price":"","url":"http://kaifa.yinfengnet.com/mobile/#/goods/5144","shop_url":"http://kaifa.yinfengnet.com/mobile/#/shopHome/50053","goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/gallery_album/0/thumb_img/0_thumb_G_1559667555480.jpg"},{"goods_number":996,"on_sale":1,"rec_id":26,"is_attention":1,"goods_id":5142,"shop_name":"雅文家居用品专营店","is_IM":0,"is_dsc":false,"add_time":"2019-06-05 08:48:57","goods_name":"外交官商务休闲双肩背包","market_price":"¥780.00","shop_price":"¥148.00","promote_price":"","url":"http://kaifa.yinfengnet.com/mobile/#/goods/5142","shop_url":"http://kaifa.yinfengnet.com/mobile/#/shopHome/50053","goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/gallery_album/0/thumb_img/0_thumb_G_1559667339479.jpg"},{"goods_number":996,"on_sale":1,"rec_id":25,"is_attention":1,"goods_id":5141,"shop_name":"雅文家居用品专营店","is_IM":0,"is_dsc":false,"add_time":"2019-06-05 08:48:57","goods_name":"外交官商务休闲双肩背包","market_price":"¥1360.00","shop_price":"¥331.00","promote_price":"","url":"http://kaifa.yinfengnet.com/mobile/#/goods/5141","shop_url":"http://kaifa.yinfengnet.com/mobile/#/shopHome/50053","goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/gallery_album/0/thumb_img/0_thumb_G_1559667263463.jpg"},{"goods_number":36,"on_sale":1,"rec_id":24,"is_attention":1,"goods_id":33,"shop_name":"手机配件专卖店","is_IM":0,"is_dsc":false,"add_time":"2019-06-03 10:54:02","goods_name":"华为手机3200像素高清","market_price":"¥2000.00","shop_price":"¥1800.00","promote_price":"¥1500.00","url":"http://kaifa.yinfengnet.com/mobile/#/goods/33","shop_url":"http://kaifa.yinfengnet.com/mobile/#/shopHome/50049","goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201906/thumb_img/0_thumb_G_1559500494961.jpg"}]
     * time : 1575879080
     * timestamp : 1.575879080599067E9
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
         * goods_number : 998
         * on_sale : 1
         * rec_id : 29
         * is_attention : 1
         * goods_id : 5144
         * shop_name : 雅文家居用品专营店
         * is_IM : 0
         * is_dsc : false
         * add_time : 2019-06-05 08:48:57
         * goods_name : 外交官儿童经典款拉杆（蓝色有货）
         * market_price : ¥988.00
         * shop_price : ¥329.00
         * promote_price :
         * url : http://kaifa.yinfengnet.com/mobile/#/goods/5144
         * shop_url : http://kaifa.yinfengnet.com/mobile/#/shopHome/50053
         * goods_thumb : http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/gallery_album/0/thumb_img/0_thumb_G_1559667555480.jpg
         */

        private int goods_number;
        private int on_sale;
        private int rec_id;
        private int is_attention;
        private int goods_id;
        private String shop_name;
        private int is_IM;
        private boolean is_dsc;
        private String add_time;
        private String goods_name;
        private String market_price;
        private String shop_price;
        private String promote_price;
        private String url;
        private String shop_url;
        private String goods_thumb;

        public int getGoods_number() {
            return goods_number;
        }

        public void setGoods_number(int goods_number) {
            this.goods_number = goods_number;
        }

        public int getOn_sale() {
            return on_sale;
        }

        public void setOn_sale(int on_sale) {
            this.on_sale = on_sale;
        }

        public int getRec_id() {
            return rec_id;
        }

        public void setRec_id(int rec_id) {
            this.rec_id = rec_id;
        }

        public int getIs_attention() {
            return is_attention;
        }

        public void setIs_attention(int is_attention) {
            this.is_attention = is_attention;
        }

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public String getShop_name() {
            return shop_name;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
        }

        public int getIs_IM() {
            return is_IM;
        }

        public void setIs_IM(int is_IM) {
            this.is_IM = is_IM;
        }

        public boolean isIs_dsc() {
            return is_dsc;
        }

        public void setIs_dsc(boolean is_dsc) {
            this.is_dsc = is_dsc;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getMarket_price() {
            return market_price;
        }

        public void setMarket_price(String market_price) {
            this.market_price = market_price;
        }

        public String getShop_price() {
            return shop_price;
        }

        public void setShop_price(String shop_price) {
            this.shop_price = shop_price;
        }

        public String getPromote_price() {
            return promote_price;
        }

        public void setPromote_price(String promote_price) {
            this.promote_price = promote_price;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getShop_url() {
            return shop_url;
        }

        public void setShop_url(String shop_url) {
            this.shop_url = shop_url;
        }

        public String getGoods_thumb() {
            return goods_thumb;
        }

        public void setGoods_thumb(String goods_thumb) {
            this.goods_thumb = goods_thumb;
        }
    }
}
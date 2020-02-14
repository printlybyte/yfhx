package com.yinfeng.yfhx.entity.details;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity.details
 * 类  名：SelectedAttrpriceBean
 * 创建人：liuguodong
 * 创建时间：2019/12/24 17:04
 * ============================================
 **/
public class SelectedAttrpriceBean {

    /**
     * status : success
     * data : {"stock":999,"market_price":1860,"qty":"1","spec_price":291,"goods_price":"291.00","attr_img":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/gallery_album/0/images/0_P_1559667449009.jpg","market_price_formated":"¥1860.00","spec_price_formated":"¥291.00","spec_promote_price":0,"spec_promote_price_formated":"¥0.00","goods_price_formated":"¥291.00","attr_name":"蓝色"}
     * time : 1577178260
     * timestamp : 1.577178260787243E9
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
         * stock : 999
         * market_price : 1860
         * qty : 1
         * spec_price : 291
         * goods_price : 291.00
         * attr_img : http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/gallery_album/0/images/0_P_1559667449009.jpg
         * market_price_formated : ¥1860.00
         * spec_price_formated : ¥291.00
         * spec_promote_price : 0
         * spec_promote_price_formated : ¥0.00
         * goods_price_formated : ¥291.00
         * attr_name : 蓝色
         */

        private int stock;
        private int market_price;
        private String qty;
        private int spec_price;
        private String goods_price;
        private String attr_img;
        private String market_price_formated;
        private String spec_price_formated;
        private int spec_promote_price;
        private String spec_promote_price_formated;
        private String goods_price_formated;
        private String attr_name;

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public int getMarket_price() {
            return market_price;
        }

        public void setMarket_price(int market_price) {
            this.market_price = market_price;
        }

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
        }

        public int getSpec_price() {
            return spec_price;
        }

        public void setSpec_price(int spec_price) {
            this.spec_price = spec_price;
        }

        public String getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(String goods_price) {
            this.goods_price = goods_price;
        }

        public String getAttr_img() {
            return attr_img;
        }

        public void setAttr_img(String attr_img) {
            this.attr_img = attr_img;
        }

        public String getMarket_price_formated() {
            return market_price_formated;
        }

        public void setMarket_price_formated(String market_price_formated) {
            this.market_price_formated = market_price_formated;
        }

        public String getSpec_price_formated() {
            return spec_price_formated;
        }

        public void setSpec_price_formated(String spec_price_formated) {
            this.spec_price_formated = spec_price_formated;
        }

        public int getSpec_promote_price() {
            return spec_promote_price;
        }

        public void setSpec_promote_price(int spec_promote_price) {
            this.spec_promote_price = spec_promote_price;
        }

        public String getSpec_promote_price_formated() {
            return spec_promote_price_formated;
        }

        public void setSpec_promote_price_formated(String spec_promote_price_formated) {
            this.spec_promote_price_formated = spec_promote_price_formated;
        }

        public String getGoods_price_formated() {
            return goods_price_formated;
        }

        public void setGoods_price_formated(String goods_price_formated) {
            this.goods_price_formated = goods_price_formated;
        }

        public String getAttr_name() {
            return attr_name;
        }

        public void setAttr_name(String attr_name) {
            this.attr_name = attr_name;
        }
    }
}

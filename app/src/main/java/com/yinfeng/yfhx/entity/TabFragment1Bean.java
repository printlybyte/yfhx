package com.yinfeng.yfhx.entity;

import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity
 * 类  名：TabFragment1Bean
 * 创建人：liuguodong
 * 创建时间：2019/9/6 11:08
 * ============================================
 **/
public class TabFragment1Bean {


    private List<CategoriesBean> categories;
    private List<BannersBean> banners;
    private List<NavsBean> navs;
    private List<TopicBean> topic;
    private List<AdsBean> ads;
    private List<StoresBean> stores;
    private List<NewgoodsBean> newgoods;
    private List<NoticelistBean> noticelist;
    private List<HdlistBean> hdlist;
    private List<SeckillsBean> seckills;

    public List<CategoriesBean> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesBean> categories) {
        this.categories = categories;
    }

    public List<BannersBean> getBanners() {
        return banners;
    }

    public void setBanners(List<BannersBean> banners) {
        this.banners = banners;
    }

    public List<NavsBean> getNavs() {
        return navs;
    }

    public void setNavs(List<NavsBean> navs) {
        this.navs = navs;
    }

    public List<TopicBean> getTopic() {
        return topic;
    }

    public void setTopic(List<TopicBean> topic) {
        this.topic = topic;
    }

    public List<AdsBean> getAds() {
        return ads;
    }

    public void setAds(List<AdsBean> ads) {
        this.ads = ads;
    }

    public List<StoresBean> getStores() {
        return stores;
    }

    public void setStores(List<StoresBean> stores) {
        this.stores = stores;
    }

    public List<NewgoodsBean> getNewgoods() {
        return newgoods;
    }

    public void setNewgoods(List<NewgoodsBean> newgoods) {
        this.newgoods = newgoods;
    }

    public List<NoticelistBean> getNoticelist() {
        return noticelist;
    }

    public void setNoticelist(List<NoticelistBean> noticelist) {
        this.noticelist = noticelist;
    }

    public List<HdlistBean> getHdlist() {
        return hdlist;
    }

    public void setHdlist(List<HdlistBean> hdlist) {
        this.hdlist = hdlist;
    }

    public List<SeckillsBean> getSeckills() {
        return seckills;
    }

    public void setSeckills(List<SeckillsBean> seckills) {
        this.seckills = seckills;
    }

    public static class CategoriesBean {
        /**
         * cat_id : 858
         * cat_name : 家用电器
         * cat_alias_name : 家用电器
         * touch_icon : data/touch_icon/15592525556253.png
         * user_role : 502
         * url : http://mall.yinfengnet.com/category.php?id=858
         */

        private int cat_id;
        private String cat_name;
        private String cat_alias_name;
        private String touch_icon;
        private String user_role;
        private String url;

        public int getCat_id() {
            return cat_id;
        }

        public void setCat_id(int cat_id) {
            this.cat_id = cat_id;
        }

        public String getCat_name() {
            return cat_name;
        }

        public void setCat_name(String cat_name) {
            this.cat_name = cat_name;
        }

        public String getCat_alias_name() {
            return cat_alias_name;
        }

        public void setCat_alias_name(String cat_alias_name) {
            this.cat_alias_name = cat_alias_name;
        }

        public String getTouch_icon() {
            return touch_icon;
        }

        public void setTouch_icon(String touch_icon) {
            this.touch_icon = touch_icon;
        }

        public String getUser_role() {
            return user_role;
        }

        public void setUser_role(String user_role) {
            this.user_role = user_role;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class BannersBean {
        /**
         * id : 21
         * url :
         * pic : http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/attached/banner/1568605228.png
         * user_role : 1014
         */

        private int id;
        private String url;
        private String pic;
        private String user_role;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getUser_role() {
            return user_role;
        }

        public void setUser_role(String user_role) {
            this.user_role = user_role;
        }
    }

    public static class NavsBean {
        /**
         * id : 9
         * title : 新品秒杀
         * url : 活动暂未上架
         * pic : http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/attached/banner/1562578128.png
         * user_role : 486
         */

        private int id;
        private String title;
        private String url;
        private String pic;
        private String user_role;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getUser_role() {
            return user_role;
        }

        public void setUser_role(String user_role) {
            this.user_role = user_role;
        }
    }

    public static class TopicBean {
        /**
         * id : 2
         * url : http://mall.yinfengnet.com/mobile/#/activity/common/5
         * pic : http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/attached/banner/1568106532.png
         * user_role : 1014
         */

        private int id;
        private String url;
        private String pic;
        private String user_role;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getUser_role() {
            return user_role;
        }

        public void setUser_role(String user_role) {
            this.user_role = user_role;
        }
    }

    public static class AdsBean {
        /**
         * id : 11
         * url : http://mall.yinfengnet.com/#/catalog/4
         * pic : http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/attached/banner/1560830358.png
         * user_role : 502
         */

        private int id;
        private String url;
        private String pic;
        private String user_role;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getUser_role() {
            return user_role;
        }

        public void setUser_role(String user_role) {
            this.user_role = user_role;
        }
    }

    public static class StoresBean {
        /**
         * ru_id : 50063
         * shop_name : 恒安品牌专营店
         * shop_title : 恒安纸卫品专营店
         * shop_logo : http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/seller_imgs/seller_logo/logo_thumb/1559510861312447077.jpg
         * logo_thumb : images/seller_imgs/seller_logo/logo_thumb/1559510861312447077.jpg
         * goods : [{"goods_id":6859,"goods_name":"心相印家居组合","goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/gallery_album/498/thumb_img/498_thumb_G_1567643596827.jpg","goods_img":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/gallery_album/498/images/498_P_1567643596605.jpg","shop_price":"75.00","cat_id":1511},{"goods_id":6857,"goods_name":"心相印优选郁金香200抽软抽 10提/组 DT19200抽纸  3包/提","goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201908/thumb_img/6857_thumb_G_1565735813496.jpg","goods_img":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201908/goods_img/6857_G_1565735813602.jpg","shop_price":"99.00","cat_id":1511},{"goods_id":6259,"goods_name":"奇莫皇家至柔婴儿柔纸巾100抽/包*16包（4包*4提）加赠40抽/包*4包","goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201907/thumb_img/6259_thumb_G_1562023216921.jpg","goods_img":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201907/goods_img/6259_G_1562023216433.jpg","shop_price":"98.00","cat_id":1511}]
         */

        private int ru_id;
        private String shop_name;
        private String shop_title;
        private String shop_logo;
        private String logo_thumb;
        private List<GoodsBean> goods;

        public int getRu_id() {
            return ru_id;
        }

        public void setRu_id(int ru_id) {
            this.ru_id = ru_id;
        }

        public String getShop_name() {
            return shop_name;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
        }

        public String getShop_title() {
            return shop_title;
        }

        public void setShop_title(String shop_title) {
            this.shop_title = shop_title;
        }

        public String getShop_logo() {
            return shop_logo;
        }

        public void setShop_logo(String shop_logo) {
            this.shop_logo = shop_logo;
        }

        public String getLogo_thumb() {
            return logo_thumb;
        }

        public void setLogo_thumb(String logo_thumb) {
            this.logo_thumb = logo_thumb;
        }

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        public static class GoodsBean {
            /**
             * goods_id : 6859
             * goods_name : 心相印家居组合
             * goods_thumb : http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/gallery_album/498/thumb_img/498_thumb_G_1567643596827.jpg
             * goods_img : http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/gallery_album/498/images/498_P_1567643596605.jpg
             * shop_price : 75.00
             * cat_id : 1511
             */

            private int goods_id;
            private String goods_name;
            private String goods_thumb;
            private String goods_img;
            private String shop_price;
            private int cat_id;

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_thumb() {
                return goods_thumb;
            }

            public void setGoods_thumb(String goods_thumb) {
                this.goods_thumb = goods_thumb;
            }

            public String getGoods_img() {
                return goods_img;
            }

            public void setGoods_img(String goods_img) {
                this.goods_img = goods_img;
            }

            public String getShop_price() {
                return shop_price;
            }

            public void setShop_price(String shop_price) {
                this.shop_price = shop_price;
            }

            public int getCat_id() {
                return cat_id;
            }

            public void setCat_id(int cat_id) {
                this.cat_id = cat_id;
            }
        }
    }

    public static class NewgoodsBean {
        /**
         * goods_id : 6460
         * goods_name : 龙大肉食 无淀粉火腿肠熟食即食肠 户外野餐真空包装配餐火腿肠350g*2个
         * goods_thumb : http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201907/thumb_img/0_thumb_G_1564128701043.jpg
         * goods_img : http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201907/goods_img/0_G_1564128701756.jpg
         * shop_price : 34.90
         * market_price : 39.80
         * sales_volume : 204
         * cat_id : 638
         */

        private int goods_id;
        private String goods_name;
        private String goods_thumb;
        private String goods_img;
        private String shop_price;
        private String market_price;
        private int sales_volume;
        private int cat_id;

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_thumb() {
            return goods_thumb;
        }

        public void setGoods_thumb(String goods_thumb) {
            this.goods_thumb = goods_thumb;
        }

        public String getGoods_img() {
            return goods_img;
        }

        public void setGoods_img(String goods_img) {
            this.goods_img = goods_img;
        }

        public String getShop_price() {
            return shop_price;
        }

        public void setShop_price(String shop_price) {
            this.shop_price = shop_price;
        }

        public String getMarket_price() {
            return market_price;
        }

        public void setMarket_price(String market_price) {
            this.market_price = market_price;
        }

        public int getSales_volume() {
            return sales_volume;
        }

        public void setSales_volume(int sales_volume) {
            this.sales_volume = sales_volume;
        }

        public int getCat_id() {
            return cat_id;
        }

        public void setCat_id(int cat_id) {
            this.cat_id = cat_id;
        }
    }

    public static class NoticelistBean {
        /**
         * article_id : 62
         * cat_id : 20
         * title : 银丰荟商城2.0上线啦！
         * id : 62
         * url : http://mall.yinfengnet.com/article.php?id=62
         * album : []
         * amity_time : 49年前
         */

        private int article_id;
        private int cat_id;
        private String title;
        private int id;
        private String url;
        private String amity_time;
        private List<?> album;

        public int getArticle_id() {
            return article_id;
        }

        public void setArticle_id(int article_id) {
            this.article_id = article_id;
        }

        public int getCat_id() {
            return cat_id;
        }

        public void setCat_id(int cat_id) {
            this.cat_id = cat_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAmity_time() {
            return amity_time;
        }

        public void setAmity_time(String amity_time) {
            this.amity_time = amity_time;
        }

        public List<?> getAlbum() {
            return album;
        }

        public void setAlbum(List<?> album) {
            this.album = album;
        }
    }

    public static class HdlistBean {
        /**
         * article_id : 63
         * cat_id : 20
         * title : 银丰电商与珠海格力集团签约达成战略合作！
         * id : 63
         * url : http://mall.yinfengnet.com/article.php?id=63
         * album : []
         * amity_time : 49年前
         */

        private int article_id;
        private int cat_id;
        private String title;
        private int id;
        private String url;
        private String amity_time;
        private List<?> album;

        public int getArticle_id() {
            return article_id;
        }

        public void setArticle_id(int article_id) {
            this.article_id = article_id;
        }

        public int getCat_id() {
            return cat_id;
        }

        public void setCat_id(int cat_id) {
            this.cat_id = cat_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAmity_time() {
            return amity_time;
        }

        public void setAmity_time(String amity_time) {
            this.amity_time = amity_time;
        }

        public List<?> getAlbum() {
            return album;
        }

        public void setAlbum(List<?> album) {
            this.album = album;
        }
    }

    public static class SeckillsBean {
        /**
         * goods_id : 6857
         * goods_thumb : http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201908/thumb_img/6857_thumb_G_1565735813496.jpg
         * shop_price : 99.00
         * market_price : 99.00
         * goods_name : 心相印优选郁金香200抽软抽 10提/组 DT19200抽纸  3包/提
         * id : 187
         * sec_price : 78.00
         * sec_num : 10
         * sec_limit : 10
         * begin_time : 1569420000
         * end_time : 1569438000
         * sec_id : 37
         * acti_title : 心相印郁金香抽纸
         * acti_time : 1572422400
         * sales_volume : {"total_order":36,"total_goods":"40","valid_order":36,"valid_goods":217}
         * goods_img : http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201908/goods_img/6857_G_1565735813602.jpg
         * current_time : 1569437401
         * status : true
         * data_end_time : 06:00:00
         * sec_price_formated : ¥78.00
         * market_price_formated : ¥99.00
         * valid_goods : 217
         * percent : 96
         * url : http://mall.yinfengnet.com/mobile/#/seckill/detail?seckill_id=187&tomorrow=0
         * pc_url : http://mall.yinfengnet.com/seckill.php?id=187&act=view
         */

        private int goods_id;
        private String goods_thumb;
        private String shop_price;
        private String market_price;
        private String goods_name;
        private int id;
        private String sec_price;
        private int sec_num;
        private int sec_limit;
        private int begin_time;
        private int end_time;
        private int sec_id;
        private String acti_title;
        private int acti_time;
        private SalesVolumeBean sales_volume;
        private String goods_img;
        private int current_time;
        private boolean status;
        private String data_end_time;
        private String sec_price_formated;
        private String market_price_formated;
        private int valid_goods;
        private int percent;
        private String url;
        private String pc_url;

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public String getGoods_thumb() {
            return goods_thumb;
        }

        public void setGoods_thumb(String goods_thumb) {
            this.goods_thumb = goods_thumb;
        }

        public String getShop_price() {
            return shop_price;
        }

        public void setShop_price(String shop_price) {
            this.shop_price = shop_price;
        }

        public String getMarket_price() {
            return market_price;
        }

        public void setMarket_price(String market_price) {
            this.market_price = market_price;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSec_price() {
            return sec_price;
        }

        public void setSec_price(String sec_price) {
            this.sec_price = sec_price;
        }

        public int getSec_num() {
            return sec_num;
        }

        public void setSec_num(int sec_num) {
            this.sec_num = sec_num;
        }

        public int getSec_limit() {
            return sec_limit;
        }

        public void setSec_limit(int sec_limit) {
            this.sec_limit = sec_limit;
        }

        public int getBegin_time() {
            return begin_time;
        }

        public void setBegin_time(int begin_time) {
            this.begin_time = begin_time;
        }

        public int getEnd_time() {
            return end_time;
        }

        public void setEnd_time(int end_time) {
            this.end_time = end_time;
        }

        public int getSec_id() {
            return sec_id;
        }

        public void setSec_id(int sec_id) {
            this.sec_id = sec_id;
        }

        public String getActi_title() {
            return acti_title;
        }

        public void setActi_title(String acti_title) {
            this.acti_title = acti_title;
        }

        public int getActi_time() {
            return acti_time;
        }

        public void setActi_time(int acti_time) {
            this.acti_time = acti_time;
        }

        public SalesVolumeBean getSales_volume() {
            return sales_volume;
        }

        public void setSales_volume(SalesVolumeBean sales_volume) {
            this.sales_volume = sales_volume;
        }

        public String getGoods_img() {
            return goods_img;
        }

        public void setGoods_img(String goods_img) {
            this.goods_img = goods_img;
        }

        public int getCurrent_time() {
            return current_time;
        }

        public void setCurrent_time(int current_time) {
            this.current_time = current_time;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String getData_end_time() {
            return data_end_time;
        }

        public void setData_end_time(String data_end_time) {
            this.data_end_time = data_end_time;
        }

        public String getSec_price_formated() {
            return sec_price_formated;
        }

        public void setSec_price_formated(String sec_price_formated) {
            this.sec_price_formated = sec_price_formated;
        }

        public String getMarket_price_formated() {
            return market_price_formated;
        }

        public void setMarket_price_formated(String market_price_formated) {
            this.market_price_formated = market_price_formated;
        }

        public int getValid_goods() {
            return valid_goods;
        }

        public void setValid_goods(int valid_goods) {
            this.valid_goods = valid_goods;
        }

        public int getPercent() {
            return percent;
        }

        public void setPercent(int percent) {
            this.percent = percent;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPc_url() {
            return pc_url;
        }

        public void setPc_url(String pc_url) {
            this.pc_url = pc_url;
        }

        public static class SalesVolumeBean {
            /**
             * total_order : 36
             * total_goods : 40
             * valid_order : 36
             * valid_goods : 217
             */

            private int total_order;
            private String total_goods;
            private int valid_order;
            private int valid_goods;

            public int getTotal_order() {
                return total_order;
            }

            public void setTotal_order(int total_order) {
                this.total_order = total_order;
            }

            public String getTotal_goods() {
                return total_goods;
            }

            public void setTotal_goods(String total_goods) {
                this.total_goods = total_goods;
            }

            public int getValid_order() {
                return valid_order;
            }

            public void setValid_order(int valid_order) {
                this.valid_order = valid_order;
            }

            public int getValid_goods() {
                return valid_goods;
            }

            public void setValid_goods(int valid_goods) {
                this.valid_goods = valid_goods;
            }
        }
    }
}

package com.yinfeng.yfhx;

/**
 * ============================================
 * 描  述：
 * 包  名：com.lgd.lgd_core
 * 类  名：Api
 * 创建人：liuguodong
 * 创建时间：2019/9/3 10:23
 * ============================================
 **/
public interface Api {
    /**
     * main
     */
    String DO_MAIN = "http://mall.yinfengnet.com";
    /**
     * Tab 1
     */
    //首页数据
    String shop_get = DO_MAIN + "/api/v4/shop";
    String catalog_list_get = DO_MAIN + "/api/v4/catalog/list";

    /**
     * 商品列表
     */
    String goodslist_post = DO_MAIN + "/api/v4/catalog/goodslist";


}

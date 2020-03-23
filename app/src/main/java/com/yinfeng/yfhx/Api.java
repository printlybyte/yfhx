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


    int NET_success = 1;
    /**
     * main
     */
    String DO_MAIN = "http://mall.yinfengnet.com";
//    String DO_MAIN = "http://kaifa.yinfengnet.com";
    /**
     * Tab 1
     */
    //首页数据
    String shop_get = DO_MAIN + "/api/v4/mshop";
    String catalog_list_get = DO_MAIN + "/api/v4/catalog/list";

    /**
     * 商品列表
     */
    String goodslist_post = DO_MAIN + "/api/v4/catalog/goodslist";
    /**
     * 微信登录
     */
    String usert_wxLogin_post = DO_MAIN + "/api/v4/user/wxLogin";
    String getwx_login_userinfo_get ="https://api.weixin.qq.com/sns/userinfo";

    String goods_details_post = DO_MAIN + "/api/v4/goods/show";


    /**
     * 图片上传
     */
    String user_material_post = DO_MAIN + "/api/v4/user/material";


    /**
     * /api/v4/user/profile 我的
     */

    String user_profile_get = DO_MAIN + "/api/v4/user/profile";


    /**
     * 发票信息列表
     */
    String invoice_list_get = DO_MAIN + "/api/v4/invoice/list";

    /**
     * 发票添加
     */
    String invoice_store_post = DO_MAIN + "/api/v4/invoice/store";

    /**
     * 发票删除
     */
    String invoice_destroy_post = DO_MAIN + "/api/v4/invoice/destroy";

    /**
     * 地址列表删除
     */
    String address_delete = DO_MAIN + "/api/v4/address/destroy";

    /**
     * 地址列表
     */
    String address_list = DO_MAIN + "/api/v4/address";
    /**
     * 地址列表
     */
    String address_default_post = DO_MAIN + "/api/v4/address/default";

    /**
     * 地址列表添加
     */
    String address_store_post = DO_MAIN + "/api/v4/address/store";

    /**
     * 未使用优惠券
     */
    String coupon_coupon_get = DO_MAIN + "/api/v4/coupon/coupon";


    /**
     * 购物车
     */
    String cart_goodslist_post = DO_MAIN + "/api/v4/cart/goodslist";

    /**
     * 购物数量更新
     */
    String cart_update_post = DO_MAIN + "/api/v4/cart/update";

    /**
     * 购物车添加
     */
    String cart_add_post = DO_MAIN + "/api/v4/cart/add";
    /**
     * 购物车选中
     */
    String cart_checked_post = DO_MAIN + "/api/v4/cart/checked";

    /**
     * 获取验证码
     */
    String sms_send_post = DO_MAIN + "/api/v4/misc/sms/sendmsg";
    /**
     * 登录
     */
    String user_mobileLogin_post = DO_MAIN + "/api/v4/user/mobileLogin";

    /**
     * 购物车计算
     */
    String cart_cartvalue_post = DO_MAIN + "/api/v4/cart/cartvalue";

    /**
     * 购物车选中
     */
    String cart_mchecked_post = DO_MAIN + "/api/v4/cart/mchecked";

    /**
     * 购物车删除
     */
    String cart_deletecart_post = DO_MAIN + "/api/v4/cart/deletecart";

    /**
     * 商品评价列表title
     */
    String cart_comment_title_post = DO_MAIN + "/api/v4/comment/title";

    /**
     * 商品评价列表
     */
    String cart_comment_goods_post = DO_MAIN + "/api/v4/comment/goods";

    /**
     * 商品规格选择弹框title
     */
    String goods_attrprice_post = DO_MAIN + "/api/v4/goods/attrprice";


    /**
     * 收藏/取藏商品
     */
    String collect_collectgoods_post = DO_MAIN + "/api/v4/collect/collectgoods";

    /**
     * 获取省市区
     */
    String misc_region_get = DO_MAIN + "/api/v4/misc/region";


    /**
     * 商品运费
     */
    String shipping_goodsshippingfee_get = DO_MAIN + "/api/v4/shipping/goodsshippingfee";


    /**
     * 店铺关注 取消关注
     */

    String collect_collectshop_post = DO_MAIN + "/api/v4/collect/collectshop";


    /**
     * 店铺详情
     */

    String visual_storein_post = DO_MAIN + "/api/v4/visual/storein";

    /**
     * 店铺分类商品
     */

    String shop_shopgoodslist_post = DO_MAIN + "/api/v4/shop/shopgoodslist";

    /**
     * 店铺优惠券
     */
    String shop_coupon_post = DO_MAIN + "/api/v4/coupon";

    /**
     * 领取店铺优惠券
     */
    String coupon_receive_post = DO_MAIN + "/api/v4/coupon/receive";

    /**
     * 储值卡/红包列表
     */
    String valuecard_post = DO_MAIN + "/api/v4/valuecard/list";
    /**
     * 订单信息确认
     */
    String trade_orderinfo_post = DO_MAIN + "/api/v4/trade/orderinfo";


    /**
     * 订单信息详情
     */
    String trade_orderdetail_post = DO_MAIN + "/api/v4/order/detail";


    /**
     * 商品优惠券
     */
    String coupon_goods_post = DO_MAIN + "/api/v4/coupon/goods";


    /**
     * 购物车猜你喜欢
     */
    String goods_goodsguess_post = DO_MAIN + "/api/v4/goods/goodsguess";

    /**
     * 优惠券使用
     */
    String trade_changecou_post = DO_MAIN + "/api/v4/trade/changecou";


    /**
     * 电子红包 储值卡使用
     */
    String trade_changecard_post = DO_MAIN + "/api/v4/trade/changecard";


    /**
     * 提交购物车
     */
    String trade_done_post = DO_MAIN + "/api/v4/trade/done";


    /**
     * 我的足迹
     */
    String history_index_get = DO_MAIN + "/api/v4/history/mindex";

    /**
     * 清楚我的足迹
     */
    String history_mdestroy_delected = DO_MAIN + "/api/v4/history/mdestroy";


    /**
     * 收藏商品
     */
    String collect_goods_get = DO_MAIN + "/api/v4/collect/goods";


    /**
     * 收藏店铺
     */
    String collect_shop_get = DO_MAIN + "/api/v4/collect/shop";


    /**
     * 订单列表
     */
    String order_list_post = DO_MAIN + "/api/v4/order/list";

    /**
     * 退换货列表
     */
    String refound_post = DO_MAIN + "/api/v4/refound";


    /**
     * 当前售后列表
     */
    String refound_returngoods_post = DO_MAIN + "/api/v4/refound/returngoods";
    /**
     * 待评价
     */
    String comment_commentlist_post = DO_MAIN + "/api/v4/comment/commentlist";

    /**
     * 取消 申请
     */
    String refound_cancel_post = DO_MAIN + "/api/v4/refound/cancel";


    /**
     * 确认收货
     */
    String order_confirm_post = DO_MAIN + "/api/v4/order/confirm";


    /**
     * 申请售后 详情
     */
    String refound_applyreturn_post = DO_MAIN + "/api/v4/refound/applyreturn";

    /**
     * 申请售后 提交申请
     */
    String refound_submit_return_post = DO_MAIN + "/api/v4/refound/submit_return";

    /**
     * 评价晒单  提交
     */
    String comment_addgoodscomment_post = DO_MAIN + "/api/v4/comment/addgoodscomment";
    /**
     * 评价晒单  当前陀
     */
    String comment_addcomment_post = DO_MAIN + "/api/v4/comment/addcomment";

    /**
     * 取消订单
     */
    String order_cancel_post = DO_MAIN + "/api/v4/order/cancel";

    /**
     * 删除订单
     */
    String order_delete_post = DO_MAIN + "/api/v4/order/delete";


    /**
     * 微信支付
     */
    String payment_code_post = DO_MAIN + "/api/v4/payment/code";

    /**
     * 微信支付不知道为啥调用
     */
    String trade_paycheck_post = DO_MAIN + "/api/v4/trade/paycheck";


}

package com.yinfeng.yfhx.entity.order;

import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity.order
 * 类  名：OrderDetailsActivityBean
 * 创建人：liuguodong
 * 创建时间：2019/12/17 17:24
 * ============================================
 **/
public class OrderDetailsActivityBean {

    /**
     * status : success
     * data : {"add_time":"2019-12-11 17:41:37","address":"中国山东省济南市历下区高新区","consignee":"刘国栋","pay_type":"个人付款","mobile":"17600065050","shop_id":40,"shop_name":"益海嘉里食品专营店","kf_qq":"","kf_ww":"","kf_type":0,"money_paid":"0.00","money_paid_formated":"¥0.00","goods_amount":"116.00","goods_amount_formated":"¥116.00","order_amount":"116.00","order_amount_formated":"¥116.00","order_id":28796,"order_sn":"2019121117453140373","tax_id":"0","inv_payee":"不开发票","inv_content":"不开发票","vat_id":0,"invoice_type":0,"order_status":"无效,未付款,未发货","pay_status":"未付款","shipping_status":"未发货","order_state":3,"pay_state":0,"shipping_state":0,"pay_time":"","shipping_time":"","pay_fee":"0.00","pay_fee_formated":"¥0.00","pay_name":"在线支付","pay_note":"","pay_code":"onlinepay","pack_name":"","pack_id":0,"card_name":"","card_id":0,"card_amount":"","vc_id":0,"parent_id":0,"shipping_fee":"0.00","bonus_id":0,"bonus":"¥0.00","discount":"0.00","shipping_fee_formated":"¥0.00","discount_formated":"¥0.00","shipping_id":"0","shipping_name":"","total_amount":"116.00","team_id":0,"team_parent_id":0,"team_user_id":0,"team_price":"0.00","total_amount_formated":"¥116.00","coupons_type":0,"coupons":"¥0.00","integral":0,"integral_money":"¥0.00","surplus":"0.00","surplus_formated":"¥0.00","exchange_goods":0,"postscript":"","inv_id":0,"isold":0,"handler":8,"goods":[{"goods_id":5912,"goods_name":"欧丽薇兰橄榄油1.6L","goods_number":1,"goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201906/thumb_img/0_thumb_G_1560192113988.jpg","goods_price":"116.00","goods_price_formated":"¥116.00","goods_sn":"ECS005912","shop_name":"山东康硕食品有限公司","parent_id":0,"goods_attr":"","is_gift":0,"is_real":1,"extension_code":"","is_single":0,"freight":1,"drp_money":"0.00","shipping_fee":"0.00","commission_rate":"0"}],"total_number":1,"delay":0,"delay_type":"审请","failure":0}
     * time : 1576574749
     * timestamp : 1.576574749547028E9
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
         * add_time : 2019-12-11 17:41:37
         * address : 中国山东省济南市历下区高新区
         * consignee : 刘国栋
         * pay_type : 个人付款
         * mobile : 17600065050
         * shop_id : 40
         * shop_name : 益海嘉里食品专营店
         * kf_qq :
         * kf_ww :
         * kf_type : 0
         * money_paid : 0.00
         * money_paid_formated : ¥0.00
         * goods_amount : 116.00
         * goods_amount_formated : ¥116.00
         * order_amount : 116.00
         * order_amount_formated : ¥116.00
         * order_id : 28796
         * order_sn : 2019121117453140373
         * tax_id : 0
         * inv_payee : 不开发票
         * inv_content : 不开发票
         * vat_id : 0
         * invoice_type : 0
         * order_status : 无效,未付款,未发货
         * pay_status : 未付款
         * shipping_status : 未发货
         * order_state : 3
         * pay_state : 0
         * shipping_state : 0
         * pay_time :
         * shipping_time :
         * pay_fee : 0.00
         * pay_fee_formated : ¥0.00
         * pay_name : 在线支付
         * pay_note :
         * pay_code : onlinepay
         * pack_name :
         * pack_id : 0
         * card_name :
         * card_id : 0
         * card_amount :
         * vc_id : 0
         * parent_id : 0
         * shipping_fee : 0.00
         * bonus_id : 0
         * bonus : ¥0.00
         * discount : 0.00
         * shipping_fee_formated : ¥0.00
         * discount_formated : ¥0.00
         * shipping_id : 0
         * shipping_name :
         * total_amount : 116.00
         * team_id : 0
         * team_parent_id : 0
         * team_user_id : 0
         * team_price : 0.00
         * total_amount_formated : ¥116.00
         * coupons_type : 0
         * coupons : ¥0.00
         * integral : 0
         * integral_money : ¥0.00
         * surplus : 0.00
         * surplus_formated : ¥0.00
         * exchange_goods : 0
         * postscript :
         * inv_id : 0
         * isold : 0
         * handler : 8
         * goods : [{"goods_id":5912,"goods_name":"欧丽薇兰橄榄油1.6L","goods_number":1,"goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201906/thumb_img/0_thumb_G_1560192113988.jpg","goods_price":"116.00","goods_price_formated":"¥116.00","goods_sn":"ECS005912","shop_name":"山东康硕食品有限公司","parent_id":0,"goods_attr":"","is_gift":0,"is_real":1,"extension_code":"","is_single":0,"freight":1,"drp_money":"0.00","shipping_fee":"0.00","commission_rate":"0"}]
         * total_number : 1
         * delay : 0
         * delay_type : 审请
         * failure : 0
         */

        private String add_time;
        private String address;
        private String consignee;
        private String pay_type;
        private String mobile;
        private int shop_id;
        private String shop_name;
        private String kf_qq;
        private String kf_ww;
        private int kf_type;
        private String money_paid;
        private String money_paid_formated;
        private String goods_amount;
        private String goods_amount_formated;
        private String order_amount;
        private String order_amount_formated;
        private int order_id;
        private String order_sn;
        private String tax_id;
        private String inv_payee;
        private String inv_content;
        private int vat_id;
        private int invoice_type;
        private String order_status;
        private String pay_status;
        private String shipping_status;
        private int order_state;
        private int pay_state;
        private int shipping_state;
        private String pay_time;
        private String shipping_time;
        private String pay_fee;
        private String pay_fee_formated;
        private String pay_name;
        private String pay_note;
        private String pay_code;
        private String pack_name;
        private int pack_id;
        private String card_name;
        private int card_id;
        private String card_amount;
        private int vc_id;
        private int parent_id;
        private String shipping_fee;
        private int bonus_id;
        private String bonus;
        private String discount;
        private String shipping_fee_formated;
        private String discount_formated;
        private String shipping_id;
        private String shipping_name;
        private String total_amount;
        private int team_id;
        private int team_parent_id;
        private int team_user_id;
        private String team_price;
        private String total_amount_formated;
        private int coupons_type;
        private String coupons;
        private int integral;
        private String integral_money;
        private String surplus;
        private String surplus_formated;
        private int exchange_goods;
        private String postscript;
        private int inv_id;
        private int isold;
        private int handler;
        private int total_number;
        private int delay;
        private String delay_type;
        private int failure;
        private List<GoodsBean> goods;

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getConsignee() {
            return consignee;
        }

        public void setConsignee(String consignee) {
            this.consignee = consignee;
        }

        public String getPay_type() {
            return pay_type;
        }

        public void setPay_type(String pay_type) {
            this.pay_type = pay_type;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getShop_id() {
            return shop_id;
        }

        public void setShop_id(int shop_id) {
            this.shop_id = shop_id;
        }

        public String getShop_name() {
            return shop_name;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
        }

        public String getKf_qq() {
            return kf_qq;
        }

        public void setKf_qq(String kf_qq) {
            this.kf_qq = kf_qq;
        }

        public String getKf_ww() {
            return kf_ww;
        }

        public void setKf_ww(String kf_ww) {
            this.kf_ww = kf_ww;
        }

        public int getKf_type() {
            return kf_type;
        }

        public void setKf_type(int kf_type) {
            this.kf_type = kf_type;
        }

        public String getMoney_paid() {
            return money_paid;
        }

        public void setMoney_paid(String money_paid) {
            this.money_paid = money_paid;
        }

        public String getMoney_paid_formated() {
            return money_paid_formated;
        }

        public void setMoney_paid_formated(String money_paid_formated) {
            this.money_paid_formated = money_paid_formated;
        }

        public String getGoods_amount() {
            return goods_amount;
        }

        public void setGoods_amount(String goods_amount) {
            this.goods_amount = goods_amount;
        }

        public String getGoods_amount_formated() {
            return goods_amount_formated;
        }

        public void setGoods_amount_formated(String goods_amount_formated) {
            this.goods_amount_formated = goods_amount_formated;
        }

        public String getOrder_amount() {
            return order_amount;
        }

        public void setOrder_amount(String order_amount) {
            this.order_amount = order_amount;
        }

        public String getOrder_amount_formated() {
            return order_amount_formated;
        }

        public void setOrder_amount_formated(String order_amount_formated) {
            this.order_amount_formated = order_amount_formated;
        }

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public String getOrder_sn() {
            return order_sn;
        }

        public void setOrder_sn(String order_sn) {
            this.order_sn = order_sn;
        }

        public String getTax_id() {
            return tax_id;
        }

        public void setTax_id(String tax_id) {
            this.tax_id = tax_id;
        }

        public String getInv_payee() {
            return inv_payee;
        }

        public void setInv_payee(String inv_payee) {
            this.inv_payee = inv_payee;
        }

        public String getInv_content() {
            return inv_content;
        }

        public void setInv_content(String inv_content) {
            this.inv_content = inv_content;
        }

        public int getVat_id() {
            return vat_id;
        }

        public void setVat_id(int vat_id) {
            this.vat_id = vat_id;
        }

        public int getInvoice_type() {
            return invoice_type;
        }

        public void setInvoice_type(int invoice_type) {
            this.invoice_type = invoice_type;
        }

        public String getOrder_status() {
            return order_status;
        }

        public void setOrder_status(String order_status) {
            this.order_status = order_status;
        }

        public String getPay_status() {
            return pay_status;
        }

        public void setPay_status(String pay_status) {
            this.pay_status = pay_status;
        }

        public String getShipping_status() {
            return shipping_status;
        }

        public void setShipping_status(String shipping_status) {
            this.shipping_status = shipping_status;
        }

        public int getOrder_state() {
            return order_state;
        }

        public void setOrder_state(int order_state) {
            this.order_state = order_state;
        }

        public int getPay_state() {
            return pay_state;
        }

        public void setPay_state(int pay_state) {
            this.pay_state = pay_state;
        }

        public int getShipping_state() {
            return shipping_state;
        }

        public void setShipping_state(int shipping_state) {
            this.shipping_state = shipping_state;
        }

        public String getPay_time() {
            return pay_time;
        }

        public void setPay_time(String pay_time) {
            this.pay_time = pay_time;
        }

        public String getShipping_time() {
            return shipping_time;
        }

        public void setShipping_time(String shipping_time) {
            this.shipping_time = shipping_time;
        }

        public String getPay_fee() {
            return pay_fee;
        }

        public void setPay_fee(String pay_fee) {
            this.pay_fee = pay_fee;
        }

        public String getPay_fee_formated() {
            return pay_fee_formated;
        }

        public void setPay_fee_formated(String pay_fee_formated) {
            this.pay_fee_formated = pay_fee_formated;
        }

        public String getPay_name() {
            return pay_name;
        }

        public void setPay_name(String pay_name) {
            this.pay_name = pay_name;
        }

        public String getPay_note() {
            return pay_note;
        }

        public void setPay_note(String pay_note) {
            this.pay_note = pay_note;
        }

        public String getPay_code() {
            return pay_code;
        }

        public void setPay_code(String pay_code) {
            this.pay_code = pay_code;
        }

        public String getPack_name() {
            return pack_name;
        }

        public void setPack_name(String pack_name) {
            this.pack_name = pack_name;
        }

        public int getPack_id() {
            return pack_id;
        }

        public void setPack_id(int pack_id) {
            this.pack_id = pack_id;
        }

        public String getCard_name() {
            return card_name;
        }

        public void setCard_name(String card_name) {
            this.card_name = card_name;
        }

        public int getCard_id() {
            return card_id;
        }

        public void setCard_id(int card_id) {
            this.card_id = card_id;
        }

        public String getCard_amount() {
            return card_amount;
        }

        public void setCard_amount(String card_amount) {
            this.card_amount = card_amount;
        }

        public int getVc_id() {
            return vc_id;
        }

        public void setVc_id(int vc_id) {
            this.vc_id = vc_id;
        }

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public String getShipping_fee() {
            return shipping_fee;
        }

        public void setShipping_fee(String shipping_fee) {
            this.shipping_fee = shipping_fee;
        }

        public int getBonus_id() {
            return bonus_id;
        }

        public void setBonus_id(int bonus_id) {
            this.bonus_id = bonus_id;
        }

        public String getBonus() {
            return bonus;
        }

        public void setBonus(String bonus) {
            this.bonus = bonus;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getShipping_fee_formated() {
            return shipping_fee_formated;
        }

        public void setShipping_fee_formated(String shipping_fee_formated) {
            this.shipping_fee_formated = shipping_fee_formated;
        }

        public String getDiscount_formated() {
            return discount_formated;
        }

        public void setDiscount_formated(String discount_formated) {
            this.discount_formated = discount_formated;
        }

        public String getShipping_id() {
            return shipping_id;
        }

        public void setShipping_id(String shipping_id) {
            this.shipping_id = shipping_id;
        }

        public String getShipping_name() {
            return shipping_name;
        }

        public void setShipping_name(String shipping_name) {
            this.shipping_name = shipping_name;
        }

        public String getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(String total_amount) {
            this.total_amount = total_amount;
        }

        public int getTeam_id() {
            return team_id;
        }

        public void setTeam_id(int team_id) {
            this.team_id = team_id;
        }

        public int getTeam_parent_id() {
            return team_parent_id;
        }

        public void setTeam_parent_id(int team_parent_id) {
            this.team_parent_id = team_parent_id;
        }

        public int getTeam_user_id() {
            return team_user_id;
        }

        public void setTeam_user_id(int team_user_id) {
            this.team_user_id = team_user_id;
        }

        public String getTeam_price() {
            return team_price;
        }

        public void setTeam_price(String team_price) {
            this.team_price = team_price;
        }

        public String getTotal_amount_formated() {
            return total_amount_formated;
        }

        public void setTotal_amount_formated(String total_amount_formated) {
            this.total_amount_formated = total_amount_formated;
        }

        public int getCoupons_type() {
            return coupons_type;
        }

        public void setCoupons_type(int coupons_type) {
            this.coupons_type = coupons_type;
        }

        public String getCoupons() {
            return coupons;
        }

        public void setCoupons(String coupons) {
            this.coupons = coupons;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public String getIntegral_money() {
            return integral_money;
        }

        public void setIntegral_money(String integral_money) {
            this.integral_money = integral_money;
        }

        public String getSurplus() {
            return surplus;
        }

        public void setSurplus(String surplus) {
            this.surplus = surplus;
        }

        public String getSurplus_formated() {
            return surplus_formated;
        }

        public void setSurplus_formated(String surplus_formated) {
            this.surplus_formated = surplus_formated;
        }

        public int getExchange_goods() {
            return exchange_goods;
        }

        public void setExchange_goods(int exchange_goods) {
            this.exchange_goods = exchange_goods;
        }

        public String getPostscript() {
            return postscript;
        }

        public void setPostscript(String postscript) {
            this.postscript = postscript;
        }

        public int getInv_id() {
            return inv_id;
        }

        public void setInv_id(int inv_id) {
            this.inv_id = inv_id;
        }

        public int getIsold() {
            return isold;
        }

        public void setIsold(int isold) {
            this.isold = isold;
        }

        public int getHandler() {
            return handler;
        }

        public void setHandler(int handler) {
            this.handler = handler;
        }

        public int getTotal_number() {
            return total_number;
        }

        public void setTotal_number(int total_number) {
            this.total_number = total_number;
        }

        public int getDelay() {
            return delay;
        }

        public void setDelay(int delay) {
            this.delay = delay;
        }

        public String getDelay_type() {
            return delay_type;
        }

        public void setDelay_type(String delay_type) {
            this.delay_type = delay_type;
        }

        public int getFailure() {
            return failure;
        }

        public void setFailure(int failure) {
            this.failure = failure;
        }

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        public static class GoodsBean {
            /**
             * goods_id : 5912
             * goods_name : 欧丽薇兰橄榄油1.6L
             * goods_number : 1
             * goods_thumb : http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201906/thumb_img/0_thumb_G_1560192113988.jpg
             * goods_price : 116.00
             * goods_price_formated : ¥116.00
             * goods_sn : ECS005912
             * shop_name : 山东康硕食品有限公司
             * parent_id : 0
             * goods_attr :
             * is_gift : 0
             * is_real : 1
             * extension_code :
             * is_single : 0
             * freight : 1
             * drp_money : 0.00
             * shipping_fee : 0.00
             * commission_rate : 0
             */

            private int goods_id;
            private String goods_name;
            private int goods_number;
            private String goods_thumb;
            private String goods_price;
            private String goods_price_formated;
            private String goods_sn;
            private String shop_name;
            private int parent_id;
            private String goods_attr;
            private int is_gift;
            private int is_real;
            private String extension_code;
            private int is_single;
            private int freight;
            private String drp_money;
            private String shipping_fee;
            private String commission_rate;

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

            public int getGoods_number() {
                return goods_number;
            }

            public void setGoods_number(int goods_number) {
                this.goods_number = goods_number;
            }

            public String getGoods_thumb() {
                return goods_thumb;
            }

            public void setGoods_thumb(String goods_thumb) {
                this.goods_thumb = goods_thumb;
            }

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public String getGoods_price_formated() {
                return goods_price_formated;
            }

            public void setGoods_price_formated(String goods_price_formated) {
                this.goods_price_formated = goods_price_formated;
            }

            public String getGoods_sn() {
                return goods_sn;
            }

            public void setGoods_sn(String goods_sn) {
                this.goods_sn = goods_sn;
            }

            public String getShop_name() {
                return shop_name;
            }

            public void setShop_name(String shop_name) {
                this.shop_name = shop_name;
            }

            public int getParent_id() {
                return parent_id;
            }

            public void setParent_id(int parent_id) {
                this.parent_id = parent_id;
            }

            public String getGoods_attr() {
                return goods_attr;
            }

            public void setGoods_attr(String goods_attr) {
                this.goods_attr = goods_attr;
            }

            public int getIs_gift() {
                return is_gift;
            }

            public void setIs_gift(int is_gift) {
                this.is_gift = is_gift;
            }

            public int getIs_real() {
                return is_real;
            }

            public void setIs_real(int is_real) {
                this.is_real = is_real;
            }

            public String getExtension_code() {
                return extension_code;
            }

            public void setExtension_code(String extension_code) {
                this.extension_code = extension_code;
            }

            public int getIs_single() {
                return is_single;
            }

            public void setIs_single(int is_single) {
                this.is_single = is_single;
            }

            public int getFreight() {
                return freight;
            }

            public void setFreight(int freight) {
                this.freight = freight;
            }

            public String getDrp_money() {
                return drp_money;
            }

            public void setDrp_money(String drp_money) {
                this.drp_money = drp_money;
            }

            public String getShipping_fee() {
                return shipping_fee;
            }

            public void setShipping_fee(String shipping_fee) {
                this.shipping_fee = shipping_fee;
            }

            public String getCommission_rate() {
                return commission_rate;
            }

            public void setCommission_rate(String commission_rate) {
                this.commission_rate = commission_rate;
            }
        }
    }
}

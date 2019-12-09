package com.yinfeng.yfhx.entity;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity
 * 类  名：Trade_change_bean
 * 创建人：liuguodong
 * 创建时间：2019/12/5 17:16
 * ============================================
 **/
public class Trade_change_bean {

    /**
     * status : success
     * data : {"goods_price":"199","market_price":"199","goods_number":"1","presale_price":"0","dis_amount":"0","discount":"0","saving":"199","saving_formated":"¥199.00","save_rate":"0%","discount_formated":"¥0.00","goods_price_formated":"¥199.00","market_price_formated":"¥199.00","real_goods_count":"1","virtual_goods_count":"0","coupons_count":"2","bonus_money":"0","bonus_id":0,"card":0,"card_money":0,"coupons_money":"60.00","coupons_id":"0","vc_dis":10,"amount":139,"amount_formated":"¥139.00","integral":"0","integral_money":"0","integral_money_formated":"¥0.00","value_card_id":"0","exchange_integral":"0","shipping_fee":"0","shipping_fee_formated":"¥0","payable":"199","payable_formated":"¥199","success_type":1,"coupons_money_formated":"¥60.00","cou_type":3,"card_money_formated":"¥0.00"}
     * time : 1575527226
     * timestamp : 1.575527226244654E9
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
         * goods_price : 199
         * market_price : 199
         * goods_number : 1
         * presale_price : 0
         * dis_amount : 0
         * discount : 0
         * saving : 199
         * saving_formated : ¥199.00
         * save_rate : 0%
         * discount_formated : ¥0.00
         * goods_price_formated : ¥199.00
         * market_price_formated : ¥199.00
         * real_goods_count : 1
         * virtual_goods_count : 0
         * coupons_count : 2
         * bonus_money : 0
         * bonus_id : 0
         * card : 0
         * card_money : 0
         * coupons_money : 60.00
         * coupons_id : 0
         * vc_dis : 10
         * amount : 139
         * amount_formated : ¥139.00
         * integral : 0
         * integral_money : 0
         * integral_money_formated : ¥0.00
         * value_card_id : 0
         * exchange_integral : 0
         * shipping_fee : 0
         * shipping_fee_formated : ¥0
         * payable : 199
         * payable_formated : ¥199
         * success_type : 1
         * coupons_money_formated : ¥60.00
         * cou_type : 3
         * card_money_formated : ¥0.00
         */

        private String goods_price;
        private String market_price;
        private String goods_number;
        private String presale_price;
        private String dis_amount;
        private String discount;
        private String saving;
        private String saving_formated;
        private String save_rate;
        private String discount_formated;
        private String goods_price_formated;
        private String market_price_formated;
        private String real_goods_count;
        private String virtual_goods_count;
        private String coupons_count;
        private String bonus_money;
        private int bonus_id;
        private int card;
        private int card_money;
        private String coupons_money;
        private String coupons_id;
        private int vc_dis;
        private int amount;
        private String amount_formated;
        private String integral;
        private String integral_money;
        private String integral_money_formated;
        private String value_card_id;
        private String exchange_integral;
        private String shipping_fee;
        private String shipping_fee_formated;
        private String payable;
        private String payable_formated;
        private int success_type;
        private String coupons_money_formated;
        private int cou_type;
        private String card_money_formated;

        public String getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(String goods_price) {
            this.goods_price = goods_price;
        }

        public String getMarket_price() {
            return market_price;
        }

        public void setMarket_price(String market_price) {
            this.market_price = market_price;
        }

        public String getGoods_number() {
            return goods_number;
        }

        public void setGoods_number(String goods_number) {
            this.goods_number = goods_number;
        }

        public String getPresale_price() {
            return presale_price;
        }

        public void setPresale_price(String presale_price) {
            this.presale_price = presale_price;
        }

        public String getDis_amount() {
            return dis_amount;
        }

        public void setDis_amount(String dis_amount) {
            this.dis_amount = dis_amount;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getSaving() {
            return saving;
        }

        public void setSaving(String saving) {
            this.saving = saving;
        }

        public String getSaving_formated() {
            return saving_formated;
        }

        public void setSaving_formated(String saving_formated) {
            this.saving_formated = saving_formated;
        }

        public String getSave_rate() {
            return save_rate;
        }

        public void setSave_rate(String save_rate) {
            this.save_rate = save_rate;
        }

        public String getDiscount_formated() {
            return discount_formated;
        }

        public void setDiscount_formated(String discount_formated) {
            this.discount_formated = discount_formated;
        }

        public String getGoods_price_formated() {
            return goods_price_formated;
        }

        public void setGoods_price_formated(String goods_price_formated) {
            this.goods_price_formated = goods_price_formated;
        }

        public String getMarket_price_formated() {
            return market_price_formated;
        }

        public void setMarket_price_formated(String market_price_formated) {
            this.market_price_formated = market_price_formated;
        }

        public String getReal_goods_count() {
            return real_goods_count;
        }

        public void setReal_goods_count(String real_goods_count) {
            this.real_goods_count = real_goods_count;
        }

        public String getVirtual_goods_count() {
            return virtual_goods_count;
        }

        public void setVirtual_goods_count(String virtual_goods_count) {
            this.virtual_goods_count = virtual_goods_count;
        }

        public String getCoupons_count() {
            return coupons_count;
        }

        public void setCoupons_count(String coupons_count) {
            this.coupons_count = coupons_count;
        }

        public String getBonus_money() {
            return bonus_money;
        }

        public void setBonus_money(String bonus_money) {
            this.bonus_money = bonus_money;
        }

        public int getBonus_id() {
            return bonus_id;
        }

        public void setBonus_id(int bonus_id) {
            this.bonus_id = bonus_id;
        }

        public int getCard() {
            return card;
        }

        public void setCard(int card) {
            this.card = card;
        }

        public int getCard_money() {
            return card_money;
        }

        public void setCard_money(int card_money) {
            this.card_money = card_money;
        }

        public String getCoupons_money() {
            return coupons_money;
        }

        public void setCoupons_money(String coupons_money) {
            this.coupons_money = coupons_money;
        }

        public String getCoupons_id() {
            return coupons_id;
        }

        public void setCoupons_id(String coupons_id) {
            this.coupons_id = coupons_id;
        }

        public int getVc_dis() {
            return vc_dis;
        }

        public void setVc_dis(int vc_dis) {
            this.vc_dis = vc_dis;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getAmount_formated() {
            return amount_formated;
        }

        public void setAmount_formated(String amount_formated) {
            this.amount_formated = amount_formated;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }

        public String getIntegral_money() {
            return integral_money;
        }

        public void setIntegral_money(String integral_money) {
            this.integral_money = integral_money;
        }

        public String getIntegral_money_formated() {
            return integral_money_formated;
        }

        public void setIntegral_money_formated(String integral_money_formated) {
            this.integral_money_formated = integral_money_formated;
        }

        public String getValue_card_id() {
            return value_card_id;
        }

        public void setValue_card_id(String value_card_id) {
            this.value_card_id = value_card_id;
        }

        public String getExchange_integral() {
            return exchange_integral;
        }

        public void setExchange_integral(String exchange_integral) {
            this.exchange_integral = exchange_integral;
        }

        public String getShipping_fee() {
            return shipping_fee;
        }

        public void setShipping_fee(String shipping_fee) {
            this.shipping_fee = shipping_fee;
        }

        public String getShipping_fee_formated() {
            return shipping_fee_formated;
        }

        public void setShipping_fee_formated(String shipping_fee_formated) {
            this.shipping_fee_formated = shipping_fee_formated;
        }

        public String getPayable() {
            return payable;
        }

        public void setPayable(String payable) {
            this.payable = payable;
        }

        public String getPayable_formated() {
            return payable_formated;
        }

        public void setPayable_formated(String payable_formated) {
            this.payable_formated = payable_formated;
        }

        public int getSuccess_type() {
            return success_type;
        }

        public void setSuccess_type(int success_type) {
            this.success_type = success_type;
        }

        public String getCoupons_money_formated() {
            return coupons_money_formated;
        }

        public void setCoupons_money_formated(String coupons_money_formated) {
            this.coupons_money_formated = coupons_money_formated;
        }

        public int getCou_type() {
            return cou_type;
        }

        public void setCou_type(int cou_type) {
            this.cou_type = cou_type;
        }

        public String getCard_money_formated() {
            return card_money_formated;
        }

        public void setCard_money_formated(String card_money_formated) {
            this.card_money_formated = card_money_formated;
        }
    }
}

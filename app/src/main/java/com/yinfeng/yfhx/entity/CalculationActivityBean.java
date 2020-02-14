package com.yinfeng.yfhx.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity
 * 类  名：CalculationActivityBean
 * 创建人：liuguodong
 * 创建时间：2019/12/4 11:31
 * ============================================
 **/
public class CalculationActivityBean {


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


        private TotalBean total;
        private ConsigneeBean consignee;
        private int use_value_card;
        private int use_surplus;
        private int store_lifting;
        private StoreCartBean store_cart;
        private int can_invoice;
        private int how_oos;
        private int flow_type;
        private List<GoodsListBean> goods_list;
        private List<ProductBean> product;
        private List<String> isshipping_list;
        private List<?> noshipping_list;
        private List<CouponsListBean> coupons_list;
        private List<?> bonus_list;
        private List<?> integral;
        private List<PaymentListBean> payment_list;
        private List<ValueCardBean> value_card;
        private List<String> invoice_content;

        public TotalBean getTotal() {
            return total;
        }

        public void setTotal(TotalBean total) {
            this.total = total;
        }

        public ConsigneeBean getConsignee() {
            return consignee;
        }

        public void setConsignee(ConsigneeBean consignee) {
            this.consignee = consignee;
        }

        public int getUse_value_card() {
            return use_value_card;
        }

        public void setUse_value_card(int use_value_card) {
            this.use_value_card = use_value_card;
        }

        public int getUse_surplus() {
            return use_surplus;
        }

        public void setUse_surplus(int use_surplus) {
            this.use_surplus = use_surplus;
        }

        public int getStore_lifting() {
            return store_lifting;
        }

        public void setStore_lifting(int store_lifting) {
            this.store_lifting = store_lifting;
        }

        public StoreCartBean getStore_cart() {
            return store_cart;
        }

        public void setStore_cart(StoreCartBean store_cart) {
            this.store_cart = store_cart;
        }

        public int getCan_invoice() {
            return can_invoice;
        }

        public void setCan_invoice(int can_invoice) {
            this.can_invoice = can_invoice;
        }

        public int getHow_oos() {
            return how_oos;
        }

        public void setHow_oos(int how_oos) {
            this.how_oos = how_oos;
        }

        public int getFlow_type() {
            return flow_type;
        }

        public void setFlow_type(int flow_type) {
            this.flow_type = flow_type;
        }

        public List<GoodsListBean> getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(List<GoodsListBean> goods_list) {
            this.goods_list = goods_list;
        }

        public List<ProductBean> getProduct() {
            return product;
        }

        public void setProduct(List<ProductBean> product) {
            this.product = product;
        }

        public List<String> getIsshipping_list() {
            return isshipping_list;
        }

        public void setIsshipping_list(List<String> isshipping_list) {
            this.isshipping_list = isshipping_list;
        }

        public List<?> getNoshipping_list() {
            return noshipping_list;
        }

        public void setNoshipping_list(List<?> noshipping_list) {
            this.noshipping_list = noshipping_list;
        }

        public List<CouponsListBean> getCoupons_list() {
            return coupons_list;
        }

        public void setCoupons_list(List<CouponsListBean> coupons_list) {
            this.coupons_list = coupons_list;
        }

        public List<?> getBonus_list() {
            return bonus_list;
        }

        public void setBonus_list(List<?> bonus_list) {
            this.bonus_list = bonus_list;
        }

        public List<?> getIntegral() {
            return integral;
        }

        public void setIntegral(List<?> integral) {
            this.integral = integral;
        }

        public List<PaymentListBean> getPayment_list() {
            return payment_list;
        }

        public void setPayment_list(List<PaymentListBean> payment_list) {
            this.payment_list = payment_list;
        }

        public List<ValueCardBean> getValue_card() {
            return value_card;
        }

        public void setValue_card(List<ValueCardBean> value_card) {
            this.value_card = value_card;
        }

        public List<String> getInvoice_content() {
            return invoice_content;
        }

        public void setInvoice_content(List<String> invoice_content) {
            this.invoice_content = invoice_content;
        }

        public static class TotalBean {
            /**
             * goods_price : 84902.01
             * market_price : 84904.45
             * goods_number : 8
             * presale_price : 0
             * dis_amount : 0
             * discount : 0
             * saving : 84904.45
             * saving_formated : ¥84904.45
             * save_rate : 0%
             * discount_formated : ¥0.00
             * goods_price_formated : ¥84902.01
             * market_price_formated : ¥84904.45
             * real_goods_count : 5
             * virtual_goods_count : 0
             * coupons_count : 5
             * bonus_money : 0
             * bonus_id : 0
             * card : 0
             * card_money : 0
             * coupons_money : 0
             * coupons_id : 0
             * vc_dis : 10
             * amount : 84902.01
             * amount_formated : ¥84902.01
             * integral : 0
             * integral_money : 0
             * integral_money_formated : ¥0.00
             * value_card_id : 0
             * exchange_integral : 0
             * shipping_fee : 6
             * shipping_fee_formated : ¥6
             * payable : 84908.01
             * payable_formated : ¥84908.01
             */

            private double goods_price;
            private double market_price;
            private int goods_number;
            private int presale_price;
            private int dis_amount;
            private int discount;
            private double saving;
            private String saving_formated;
            private String save_rate;
            private String discount_formated;
            private String goods_price_formated;
            private String market_price_formated;
            private int real_goods_count;
            private int virtual_goods_count;
            private int coupons_count;
            private int bonus_money;
            private int bonus_id;
            private int card;
            private int card_money;
            private int coupons_money;
            private int coupons_id;
            private int vc_dis;
            private double amount;
            private String amount_formated;
            private int integral;
            private int integral_money;
            private String integral_money_formated;
            private int value_card_id;
            private int exchange_integral;
            private int shipping_fee;
            private String shipping_fee_formated;
            private double payable;
            private String payable_formated;

            public double getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(double goods_price) {
                this.goods_price = goods_price;
            }

            public double getMarket_price() {
                return market_price;
            }

            public void setMarket_price(double market_price) {
                this.market_price = market_price;
            }

            public int getGoods_number() {
                return goods_number;
            }

            public void setGoods_number(int goods_number) {
                this.goods_number = goods_number;
            }

            public int getPresale_price() {
                return presale_price;
            }

            public void setPresale_price(int presale_price) {
                this.presale_price = presale_price;
            }

            public int getDis_amount() {
                return dis_amount;
            }

            public void setDis_amount(int dis_amount) {
                this.dis_amount = dis_amount;
            }

            public int getDiscount() {
                return discount;
            }

            public void setDiscount(int discount) {
                this.discount = discount;
            }

            public double getSaving() {
                return saving;
            }

            public void setSaving(double saving) {
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

            public int getReal_goods_count() {
                return real_goods_count;
            }

            public void setReal_goods_count(int real_goods_count) {
                this.real_goods_count = real_goods_count;
            }

            public int getVirtual_goods_count() {
                return virtual_goods_count;
            }

            public void setVirtual_goods_count(int virtual_goods_count) {
                this.virtual_goods_count = virtual_goods_count;
            }

            public int getCoupons_count() {
                return coupons_count;
            }

            public void setCoupons_count(int coupons_count) {
                this.coupons_count = coupons_count;
            }

            public int getBonus_money() {
                return bonus_money;
            }

            public void setBonus_money(int bonus_money) {
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

            public int getCoupons_money() {
                return coupons_money;
            }

            public void setCoupons_money(int coupons_money) {
                this.coupons_money = coupons_money;
            }

            public int getCoupons_id() {
                return coupons_id;
            }

            public void setCoupons_id(int coupons_id) {
                this.coupons_id = coupons_id;
            }

            public int getVc_dis() {
                return vc_dis;
            }

            public void setVc_dis(int vc_dis) {
                this.vc_dis = vc_dis;
            }

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            public String getAmount_formated() {
                return amount_formated;
            }

            public void setAmount_formated(String amount_formated) {
                this.amount_formated = amount_formated;
            }

            public int getIntegral() {
                return integral;
            }

            public void setIntegral(int integral) {
                this.integral = integral;
            }

            public int getIntegral_money() {
                return integral_money;
            }

            public void setIntegral_money(int integral_money) {
                this.integral_money = integral_money;
            }

            public String getIntegral_money_formated() {
                return integral_money_formated;
            }

            public void setIntegral_money_formated(String integral_money_formated) {
                this.integral_money_formated = integral_money_formated;
            }

            public int getValue_card_id() {
                return value_card_id;
            }

            public void setValue_card_id(int value_card_id) {
                this.value_card_id = value_card_id;
            }

            public int getExchange_integral() {
                return exchange_integral;
            }

            public void setExchange_integral(int exchange_integral) {
                this.exchange_integral = exchange_integral;
            }

            public int getShipping_fee() {
                return shipping_fee;
            }

            public void setShipping_fee(int shipping_fee) {
                this.shipping_fee = shipping_fee;
            }

            public String getShipping_fee_formated() {
                return shipping_fee_formated;
            }

            public void setShipping_fee_formated(String shipping_fee_formated) {
                this.shipping_fee_formated = shipping_fee_formated;
            }

            public double getPayable() {
                return payable;
            }

            public void setPayable(double payable) {
                this.payable = payable;
            }

            public String getPayable_formated() {
                return payable_formated;
            }

            public void setPayable_formated(String payable_formated) {
                this.payable_formated = payable_formated;
            }
        }

        public static class ConsigneeBean {
            /**
             * address_id : 163
             * address_name :
             * user_id : 50050
             * consignee : 刘国栋
             * email :
             * country : 1
             * province : 370000
             * city : 370100
             * district : 370102
             * street : 0
             * address : 高新区
             * zipcode :
             * tel :
             * mobile : 17600065050
             * sign_building :
             * best_time :
             * audit : 0
             * update_time : 0
             * province_name : 山东省
             * city_name : 济南市
             * district_name : 历下区
             */

            private int address_id;
            private String address_name;
            private int user_id;
            private String consignee;
            private String email;
            private int country;
            private int province;
            private int city;
            private int district;
            private int street;
            private String address;
            private String zipcode;
            private String tel;
            private String mobile;
            private String sign_building;
            private String best_time;
            private int audit;
            private int update_time;
            private String province_name;
            private String city_name;
            private String district_name;

            public int getAddress_id() {
                return address_id;
            }

            public void setAddress_id(int address_id) {
                this.address_id = address_id;
            }

            public String getAddress_name() {
                return address_name;
            }

            public void setAddress_name(String address_name) {
                this.address_name = address_name;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getConsignee() {
                return consignee;
            }

            public void setConsignee(String consignee) {
                this.consignee = consignee;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public int getCountry() {
                return country;
            }

            public void setCountry(int country) {
                this.country = country;
            }

            public int getProvince() {
                return province;
            }

            public void setProvince(int province) {
                this.province = province;
            }

            public int getCity() {
                return city;
            }

            public void setCity(int city) {
                this.city = city;
            }

            public int getDistrict() {
                return district;
            }

            public void setDistrict(int district) {
                this.district = district;
            }

            public int getStreet() {
                return street;
            }

            public void setStreet(int street) {
                this.street = street;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getZipcode() {
                return zipcode;
            }

            public void setZipcode(String zipcode) {
                this.zipcode = zipcode;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getSign_building() {
                return sign_building;
            }

            public void setSign_building(String sign_building) {
                this.sign_building = sign_building;
            }

            public String getBest_time() {
                return best_time;
            }

            public void setBest_time(String best_time) {
                this.best_time = best_time;
            }

            public int getAudit() {
                return audit;
            }

            public void setAudit(int audit) {
                this.audit = audit;
            }

            public int getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(int update_time) {
                this.update_time = update_time;
            }

            public String getProvince_name() {
                return province_name;
            }

            public void setProvince_name(String province_name) {
                this.province_name = province_name;
            }

            public String getCity_name() {
                return city_name;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public String getDistrict_name() {
                return district_name;
            }

            public void setDistrict_name(String district_name) {
                this.district_name = district_name;
            }
        }

        public static class StoreCartBean {
            /**
             * store_mobile : 0
             * take_time :
             */

            private String store_mobile;
            private String take_time;

            public String getStore_mobile() {
                return store_mobile;
            }

            public void setStore_mobile(String store_mobile) {
                this.store_mobile = store_mobile;
            }

            public String getTake_time() {
                return take_time;
            }

            public void setTake_time(String take_time) {
                this.take_time = take_time;
            }
        }

        public static class GoodsListBean {
            /**
             * shop_name : 格力空调家用电器专卖
             * ru_id : 50059
             * goods : [{"rec_id":1809,"user_id":50050,"cat_id":1107,"brand_id":0,"goods_name":"格力空调-润铂变频挂机1级（皓雪白）KFR-35GW/(35553)FNhAb-A1(WIFI)","goods_id":6066,"market_price":"5149.00","market_price_format":"¥5149.00","goods_price":"5149.00","goods_price_format":"¥5149.00","goods_number":1,"goods_attr":"","goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201906/thumb_img/0_thumb_G_1560369137461.jpg","is_real":1,"goods_attr_id":"","is_shipping":0,"ru_id":50059,"warehouse_id":0,"stages_qishu":"-1","add_time":"2019-11-07 16:42:25","goods_sn":"190601059","product_id":"0","extension_code":"","parent_id":0,"is_gift":0,"model_attr":0,"area_id":0,"act_id":0,"store_id":0},{"rec_id":1811,"user_id":50050,"cat_id":1107,"brand_id":0,"goods_name":"智睿变频变容中央空调多联机140一拖五","goods_id":5988,"market_price":"37005.00","market_price_format":"¥37005.00","goods_price":"37005.00","goods_price_format":"¥37005.00","goods_number":2,"goods_attr":"","goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201906/thumb_img/0_thumb_G_1560291166762.jpg","is_real":1,"goods_attr_id":"","is_shipping":0,"ru_id":50059,"warehouse_id":0,"stages_qishu":"-1","add_time":"2019-11-07 16:42:29","goods_sn":"190601056","product_id":"0","extension_code":"","parent_id":0,"is_gift":0,"model_attr":0,"area_id":0,"act_id":0,"store_id":0},{"rec_id":1896,"user_id":50050,"cat_id":1119,"brand_id":0,"goods_name":"格力大松电器-SC-4002加湿器","goods_id":5159,"market_price":"329.00","market_price_format":"¥329.00","goods_price":"329.00","goods_price_format":"¥329.00","goods_number":3,"goods_attr":"","goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201906/thumb_img/0_thumb_G_1559692318105.jpg","is_real":1,"goods_attr_id":"","is_shipping":1,"ru_id":50059,"warehouse_id":0,"stages_qishu":"-1","add_time":"2019-11-26 11:18:18","goods_sn":"190601004","product_id":"0","extension_code":"","parent_id":0,"is_gift":0,"model_attr":0,"area_id":0,"act_id":0,"store_id":0},{"rec_id":1980,"user_id":50050,"cat_id":1107,"brand_id":0,"goods_name":"格力空调-优铂变频挂机一级KFR-35GW/(35594)FNhAc-A1(WIFI)","goods_id":5936,"market_price":"4749.00","market_price_format":"¥4749.00","goods_price":"4749.00","goods_price_format":"¥4749.00","goods_number":1,"goods_attr":"","goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201906/thumb_img/0_thumb_G_1560218243243.jpg","is_real":1,"goods_attr_id":"","is_shipping":0,"ru_id":50059,"warehouse_id":0,"stages_qishu":"-1","add_time":"2019-12-04 17:55:44","goods_sn":"190601050","product_id":"0","extension_code":"","parent_id":0,"is_gift":0,"model_attr":0,"area_id":0,"act_id":0,"store_id":0}]
             * goods_count : 7
             * amount : ¥84895.00
             * shipping : {"shipping":[{"free_money":"¥0.00","format_shipping_fee":"¥0.00","shipping_fee":0,"shipping_id":49,"shipping_name":"申通快递","shipping_code":"sto","default":1,"m_default":1}],"is_freight":0,"shipping_rec":[],"shipping_count":1,"tmp_shipping_id":49,"default_shipping":{"free_money":"¥0.00","format_shipping_fee":"¥0.00","shipping_fee":0,"shipping_id":49,"shipping_name":"申通快递","shipping_code":"sto","default":1,"m_default":1}}
             */

            private String shop_name;
            private int ru_id;
            private int goods_count;
            private String amount;
            private ShippingBeanX shipping;
            private List<GoodsBean> goods;

            public String getShop_name() {
                return shop_name;
            }

            public void setShop_name(String shop_name) {
                this.shop_name = shop_name;
            }

            public int getRu_id() {
                return ru_id;
            }

            public void setRu_id(int ru_id) {
                this.ru_id = ru_id;
            }

            public int getGoods_count() {
                return goods_count;
            }

            public void setGoods_count(int goods_count) {
                this.goods_count = goods_count;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public ShippingBeanX getShipping() {
                return shipping;
            }

            public void setShipping(ShippingBeanX shipping) {
                this.shipping = shipping;
            }

            public List<GoodsBean> getGoods() {
                return goods;
            }

            public void setGoods(List<GoodsBean> goods) {
                this.goods = goods;
            }

            public static class ShippingBeanX {
                /**
                 * shipping : [{"free_money":"¥0.00","format_shipping_fee":"¥0.00","shipping_fee":0,"shipping_id":49,"shipping_name":"申通快递","shipping_code":"sto","default":1,"m_default":1}]
                 * is_freight : 0
                 * shipping_rec : []
                 * shipping_count : 1
                 * tmp_shipping_id : 49
                 * default_shipping : {"free_money":"¥0.00","format_shipping_fee":"¥0.00","shipping_fee":0,"shipping_id":49,"shipping_name":"申通快递","shipping_code":"sto","default":1,"m_default":1}
                 */

                private int is_freight;
                private int shipping_count;
                private int tmp_shipping_id;
                private DefaultShippingBean default_shipping;
                private List<ShippingBean> shipping;
                private List<?> shipping_rec;

                public int getIs_freight() {
                    return is_freight;
                }

                public void setIs_freight(int is_freight) {
                    this.is_freight = is_freight;
                }

                public int getShipping_count() {
                    return shipping_count;
                }

                public void setShipping_count(int shipping_count) {
                    this.shipping_count = shipping_count;
                }

                public int getTmp_shipping_id() {
                    return tmp_shipping_id;
                }

                public void setTmp_shipping_id(int tmp_shipping_id) {
                    this.tmp_shipping_id = tmp_shipping_id;
                }

                public DefaultShippingBean getDefault_shipping() {
                    return default_shipping;
                }

                public void setDefault_shipping(DefaultShippingBean default_shipping) {
                    this.default_shipping = default_shipping;
                }

                public List<ShippingBean> getShipping() {
                    return shipping;
                }

                public void setShipping(List<ShippingBean> shipping) {
                    this.shipping = shipping;
                }

                public List<?> getShipping_rec() {
                    return shipping_rec;
                }

                public void setShipping_rec(List<?> shipping_rec) {
                    this.shipping_rec = shipping_rec;
                }

                public static class DefaultShippingBean {
                    /**
                     * free_money : ¥0.00
                     * format_shipping_fee : ¥0.00
                     * shipping_fee : 0
                     * shipping_id : 49
                     * shipping_name : 申通快递
                     * shipping_code : sto
                     * default : 1
                     * m_default : 1
                     */

                    private String free_money;
                    private String format_shipping_fee;
                    private int shipping_fee;
                    private int shipping_id;
                    private String shipping_name;
                    private String shipping_code;
                    @SerializedName("default")
                    private int defaultX;
                    private int m_default;

                    public String getFree_money() {
                        return free_money;
                    }

                    public void setFree_money(String free_money) {
                        this.free_money = free_money;
                    }

                    public String getFormat_shipping_fee() {
                        return format_shipping_fee;
                    }

                    public void setFormat_shipping_fee(String format_shipping_fee) {
                        this.format_shipping_fee = format_shipping_fee;
                    }

                    public int getShipping_fee() {
                        return shipping_fee;
                    }

                    public void setShipping_fee(int shipping_fee) {
                        this.shipping_fee = shipping_fee;
                    }

                    public int getShipping_id() {
                        return shipping_id;
                    }

                    public void setShipping_id(int shipping_id) {
                        this.shipping_id = shipping_id;
                    }

                    public String getShipping_name() {
                        return shipping_name;
                    }

                    public void setShipping_name(String shipping_name) {
                        this.shipping_name = shipping_name;
                    }

                    public String getShipping_code() {
                        return shipping_code;
                    }

                    public void setShipping_code(String shipping_code) {
                        this.shipping_code = shipping_code;
                    }

                    public int getDefaultX() {
                        return defaultX;
                    }

                    public void setDefaultX(int defaultX) {
                        this.defaultX = defaultX;
                    }

                    public int getM_default() {
                        return m_default;
                    }

                    public void setM_default(int m_default) {
                        this.m_default = m_default;
                    }
                }

                public static class ShippingBean {
                    /**
                     * free_money : ¥0.00
                     * format_shipping_fee : ¥0.00
                     * shipping_fee : 0
                     * shipping_id : 49
                     * shipping_name : 申通快递
                     * shipping_code : sto
                     * default : 1
                     * m_default : 1
                     */

                    private String free_money;
                    private String format_shipping_fee;
                    private int shipping_fee;
                    private int shipping_id;
                    private String shipping_name;
                    private String shipping_code;
                    @SerializedName("default")
                    private int defaultX;
                    private int m_default;

                    public String getFree_money() {
                        return free_money;
                    }

                    public void setFree_money(String free_money) {
                        this.free_money = free_money;
                    }

                    public String getFormat_shipping_fee() {
                        return format_shipping_fee;
                    }

                    public void setFormat_shipping_fee(String format_shipping_fee) {
                        this.format_shipping_fee = format_shipping_fee;
                    }

                    public int getShipping_fee() {
                        return shipping_fee;
                    }

                    public void setShipping_fee(int shipping_fee) {
                        this.shipping_fee = shipping_fee;
                    }

                    public int getShipping_id() {
                        return shipping_id;
                    }

                    public void setShipping_id(int shipping_id) {
                        this.shipping_id = shipping_id;
                    }

                    public String getShipping_name() {
                        return shipping_name;
                    }

                    public void setShipping_name(String shipping_name) {
                        this.shipping_name = shipping_name;
                    }

                    public String getShipping_code() {
                        return shipping_code;
                    }

                    public void setShipping_code(String shipping_code) {
                        this.shipping_code = shipping_code;
                    }

                    public int getDefaultX() {
                        return defaultX;
                    }

                    public void setDefaultX(int defaultX) {
                        this.defaultX = defaultX;
                    }

                    public int getM_default() {
                        return m_default;
                    }

                    public void setM_default(int m_default) {
                        this.m_default = m_default;
                    }
                }
            }

            public static class GoodsBean {
                /**
                 * rec_id : 1809
                 * user_id : 50050
                 * cat_id : 1107
                 * brand_id : 0
                 * goods_name : 格力空调-润铂变频挂机1级（皓雪白）KFR-35GW/(35553)FNhAb-A1(WIFI)
                 * goods_id : 6066
                 * market_price : 5149.00
                 * market_price_format : ¥5149.00
                 * goods_price : 5149.00
                 * goods_price_format : ¥5149.00
                 * goods_number : 1
                 * goods_attr :
                 * goods_thumb : http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201906/thumb_img/0_thumb_G_1560369137461.jpg
                 * is_real : 1
                 * goods_attr_id :
                 * is_shipping : 0
                 * ru_id : 50059
                 * warehouse_id : 0
                 * stages_qishu : -1
                 * add_time : 2019-11-07 16:42:25
                 * goods_sn : 190601059
                 * product_id : 0
                 * extension_code :
                 * parent_id : 0
                 * is_gift : 0
                 * model_attr : 0
                 * area_id : 0
                 * act_id : 0
                 * store_id : 0
                 */

                private int rec_id;
                private int user_id;
                private int cat_id;
                private int brand_id;
                private String goods_name;
                private int goods_id;
                private String market_price;
                private String market_price_format;
                private String goods_price;
                private String goods_price_format;
                private int goods_number;
                private String goods_attr;
                private String goods_thumb;
                private int is_real;
                private String goods_attr_id;
                private int is_shipping;
                private int ru_id;
                private int warehouse_id;
                private String stages_qishu;
                private String add_time;
                private String goods_sn;
                private String product_id;
                private String extension_code;
                private int parent_id;
                private int is_gift;
                private int model_attr;
                private int area_id;
                private int act_id;
                private int store_id;

                public int getRec_id() {
                    return rec_id;
                }

                public void setRec_id(int rec_id) {
                    this.rec_id = rec_id;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public int getCat_id() {
                    return cat_id;
                }

                public void setCat_id(int cat_id) {
                    this.cat_id = cat_id;
                }

                public int getBrand_id() {
                    return brand_id;
                }

                public void setBrand_id(int brand_id) {
                    this.brand_id = brand_id;
                }

                public String getGoods_name() {
                    return goods_name;
                }

                public void setGoods_name(String goods_name) {
                    this.goods_name = goods_name;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public String getMarket_price() {
                    return market_price;
                }

                public void setMarket_price(String market_price) {
                    this.market_price = market_price;
                }

                public String getMarket_price_format() {
                    return market_price_format;
                }

                public void setMarket_price_format(String market_price_format) {
                    this.market_price_format = market_price_format;
                }

                public String getGoods_price() {
                    return goods_price;
                }

                public void setGoods_price(String goods_price) {
                    this.goods_price = goods_price;
                }

                public String getGoods_price_format() {
                    return goods_price_format;
                }

                public void setGoods_price_format(String goods_price_format) {
                    this.goods_price_format = goods_price_format;
                }

                public int getGoods_number() {
                    return goods_number;
                }

                public void setGoods_number(int goods_number) {
                    this.goods_number = goods_number;
                }

                public String getGoods_attr() {
                    return goods_attr;
                }

                public void setGoods_attr(String goods_attr) {
                    this.goods_attr = goods_attr;
                }

                public String getGoods_thumb() {
                    return goods_thumb;
                }

                public void setGoods_thumb(String goods_thumb) {
                    this.goods_thumb = goods_thumb;
                }

                public int getIs_real() {
                    return is_real;
                }

                public void setIs_real(int is_real) {
                    this.is_real = is_real;
                }

                public String getGoods_attr_id() {
                    return goods_attr_id;
                }

                public void setGoods_attr_id(String goods_attr_id) {
                    this.goods_attr_id = goods_attr_id;
                }

                public int getIs_shipping() {
                    return is_shipping;
                }

                public void setIs_shipping(int is_shipping) {
                    this.is_shipping = is_shipping;
                }

                public int getRu_id() {
                    return ru_id;
                }

                public void setRu_id(int ru_id) {
                    this.ru_id = ru_id;
                }

                public int getWarehouse_id() {
                    return warehouse_id;
                }

                public void setWarehouse_id(int warehouse_id) {
                    this.warehouse_id = warehouse_id;
                }

                public String getStages_qishu() {
                    return stages_qishu;
                }

                public void setStages_qishu(String stages_qishu) {
                    this.stages_qishu = stages_qishu;
                }

                public String getAdd_time() {
                    return add_time;
                }

                public void setAdd_time(String add_time) {
                    this.add_time = add_time;
                }

                public String getGoods_sn() {
                    return goods_sn;
                }

                public void setGoods_sn(String goods_sn) {
                    this.goods_sn = goods_sn;
                }

                public String getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(String product_id) {
                    this.product_id = product_id;
                }

                public String getExtension_code() {
                    return extension_code;
                }

                public void setExtension_code(String extension_code) {
                    this.extension_code = extension_code;
                }

                public int getParent_id() {
                    return parent_id;
                }

                public void setParent_id(int parent_id) {
                    this.parent_id = parent_id;
                }

                public int getIs_gift() {
                    return is_gift;
                }

                public void setIs_gift(int is_gift) {
                    this.is_gift = is_gift;
                }

                public int getModel_attr() {
                    return model_attr;
                }

                public void setModel_attr(int model_attr) {
                    this.model_attr = model_attr;
                }

                public int getArea_id() {
                    return area_id;
                }

                public void setArea_id(int area_id) {
                    this.area_id = area_id;
                }

                public int getAct_id() {
                    return act_id;
                }

                public void setAct_id(int act_id) {
                    this.act_id = act_id;
                }

                public int getStore_id() {
                    return store_id;
                }

                public void setStore_id(int store_id) {
                    this.store_id = store_id;
                }
            }
        }

        public static class ProductBean {
            /**
             * goods : {"rec_id":1809,"user_id":50050,"cat_id":1107,"brand_id":0,"goods_name":"格力空调-润铂变频挂机1级（皓雪白）KFR-35GW/(35553)FNhAb-A1(WIFI)","goods_id":6066,"market_price":"5149.00","market_price_format":"¥5149.00","goods_price":"5149.00","goods_price_format":"¥5149.00","goods_number":1,"goods_attr":"","goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201906/thumb_img/0_thumb_G_1560369137461.jpg","is_real":1,"goods_attr_id":"","is_shipping":0,"ru_id":50059,"warehouse_id":0,"stages_qishu":"-1","add_time":"2019-11-07 16:42:25","goods_sn":"190601059","product_id":"0","extension_code":"","parent_id":0,"is_gift":0,"model_attr":0,"area_id":0,"act_id":0,"store_id":0}
             */

            private GoodsBeanX goods;

            public GoodsBeanX getGoods() {
                return goods;
            }

            public void setGoods(GoodsBeanX goods) {
                this.goods = goods;
            }

            public static class GoodsBeanX {
                /**
                 * rec_id : 1809
                 * user_id : 50050
                 * cat_id : 1107
                 * brand_id : 0
                 * goods_name : 格力空调-润铂变频挂机1级（皓雪白）KFR-35GW/(35553)FNhAb-A1(WIFI)
                 * goods_id : 6066
                 * market_price : 5149.00
                 * market_price_format : ¥5149.00
                 * goods_price : 5149.00
                 * goods_price_format : ¥5149.00
                 * goods_number : 1
                 * goods_attr :
                 * goods_thumb : http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201906/thumb_img/0_thumb_G_1560369137461.jpg
                 * is_real : 1
                 * goods_attr_id :
                 * is_shipping : 0
                 * ru_id : 50059
                 * warehouse_id : 0
                 * stages_qishu : -1
                 * add_time : 2019-11-07 16:42:25
                 * goods_sn : 190601059
                 * product_id : 0
                 * extension_code :
                 * parent_id : 0
                 * is_gift : 0
                 * model_attr : 0
                 * area_id : 0
                 * act_id : 0
                 * store_id : 0
                 */

                private int rec_id;
                private int user_id;
                private int cat_id;
                private int brand_id;
                private String goods_name;
                private int goods_id;
                private String market_price;
                private String market_price_format;
                private String goods_price;
                private String goods_price_format;
                private int goods_number;
                private String goods_attr;
                private String goods_thumb;
                private int is_real;
                private String goods_attr_id;
                private int is_shipping;
                private int ru_id;
                private int warehouse_id;
                private String stages_qishu;
                private String add_time;
                private String goods_sn;
                private String product_id;
                private String extension_code;
                private int parent_id;
                private int is_gift;
                private int model_attr;
                private int area_id;
                private int act_id;
                private int store_id;

                public int getRec_id() {
                    return rec_id;
                }

                public void setRec_id(int rec_id) {
                    this.rec_id = rec_id;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public int getCat_id() {
                    return cat_id;
                }

                public void setCat_id(int cat_id) {
                    this.cat_id = cat_id;
                }

                public int getBrand_id() {
                    return brand_id;
                }

                public void setBrand_id(int brand_id) {
                    this.brand_id = brand_id;
                }

                public String getGoods_name() {
                    return goods_name;
                }

                public void setGoods_name(String goods_name) {
                    this.goods_name = goods_name;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public String getMarket_price() {
                    return market_price;
                }

                public void setMarket_price(String market_price) {
                    this.market_price = market_price;
                }

                public String getMarket_price_format() {
                    return market_price_format;
                }

                public void setMarket_price_format(String market_price_format) {
                    this.market_price_format = market_price_format;
                }

                public String getGoods_price() {
                    return goods_price;
                }

                public void setGoods_price(String goods_price) {
                    this.goods_price = goods_price;
                }

                public String getGoods_price_format() {
                    return goods_price_format;
                }

                public void setGoods_price_format(String goods_price_format) {
                    this.goods_price_format = goods_price_format;
                }

                public int getGoods_number() {
                    return goods_number;
                }

                public void setGoods_number(int goods_number) {
                    this.goods_number = goods_number;
                }

                public String getGoods_attr() {
                    return goods_attr;
                }

                public void setGoods_attr(String goods_attr) {
                    this.goods_attr = goods_attr;
                }

                public String getGoods_thumb() {
                    return goods_thumb;
                }

                public void setGoods_thumb(String goods_thumb) {
                    this.goods_thumb = goods_thumb;
                }

                public int getIs_real() {
                    return is_real;
                }

                public void setIs_real(int is_real) {
                    this.is_real = is_real;
                }

                public String getGoods_attr_id() {
                    return goods_attr_id;
                }

                public void setGoods_attr_id(String goods_attr_id) {
                    this.goods_attr_id = goods_attr_id;
                }

                public int getIs_shipping() {
                    return is_shipping;
                }

                public void setIs_shipping(int is_shipping) {
                    this.is_shipping = is_shipping;
                }

                public int getRu_id() {
                    return ru_id;
                }

                public void setRu_id(int ru_id) {
                    this.ru_id = ru_id;
                }

                public int getWarehouse_id() {
                    return warehouse_id;
                }

                public void setWarehouse_id(int warehouse_id) {
                    this.warehouse_id = warehouse_id;
                }

                public String getStages_qishu() {
                    return stages_qishu;
                }

                public void setStages_qishu(String stages_qishu) {
                    this.stages_qishu = stages_qishu;
                }

                public String getAdd_time() {
                    return add_time;
                }

                public void setAdd_time(String add_time) {
                    this.add_time = add_time;
                }

                public String getGoods_sn() {
                    return goods_sn;
                }

                public void setGoods_sn(String goods_sn) {
                    this.goods_sn = goods_sn;
                }

                public String getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(String product_id) {
                    this.product_id = product_id;
                }

                public String getExtension_code() {
                    return extension_code;
                }

                public void setExtension_code(String extension_code) {
                    this.extension_code = extension_code;
                }

                public int getParent_id() {
                    return parent_id;
                }

                public void setParent_id(int parent_id) {
                    this.parent_id = parent_id;
                }

                public int getIs_gift() {
                    return is_gift;
                }

                public void setIs_gift(int is_gift) {
                    this.is_gift = is_gift;
                }

                public int getModel_attr() {
                    return model_attr;
                }

                public void setModel_attr(int model_attr) {
                    this.model_attr = model_attr;
                }

                public int getArea_id() {
                    return area_id;
                }

                public void setArea_id(int area_id) {
                    this.area_id = area_id;
                }

                public int getAct_id() {
                    return act_id;
                }

                public void setAct_id(int act_id) {
                    this.act_id = act_id;
                }

                public int getStore_id() {
                    return store_id;
                }

                public void setStore_id(int store_id) {
                    this.store_id = store_id;
                }
            }
        }

        public static class CouponsListBean {
            /**
             * uc_id : 114
             * cou_id : 50
             * uc_money : 854
             * get_coupons : {"cou_id":50,"cou_name":"满4749减854","cou_total":500,"cou_man":"4749","cou_money":"854","cou_user_num":5,"cou_goods":"5936","spec_cat":"","cou_start_time":1560392451,"cou_end_time":1592014853,"cou_type":3,"cou_get_man":"0","cou_ok_user":"9","cou_ok_goods":"0","cou_ok_cat":"","cou_intro":"","cou_add_time":1560476773,"ru_id":50059,"cou_order":0,"cou_title":"优铂1.5匹挂","review_status":3,"review_content":""}
             * cou_name : 满4749减854
             * cou_total : 500
             * cou_man : 4749
             * cou_money : 854
             * cou_user_num : 5
             * cou_goods : 5936
             * spec_cat :
             * cou_start_time : 1560392451
             * cou_end_time : 2020-06-13
             * cou_type : 3
             * cou_get_man : 0
             * cou_ok_user : 9
             * cou_ok_goods : 0
             * cou_ok_cat :
             * cou_intro :
             * cou_add_time : 1560476773
             * ru_id : 50059
             * cou_order : 0
             * cou_title : 优铂1.5匹挂
             * review_status : 3
             * review_content :
             * shop_name : 格力空调家用电器专卖
             * cou_type_name : 全场券
             * cou_goods_name : 限商品
             */

            private int uc_id;
            private int cou_id;
            private String uc_money;
            private GetCouponsBean get_coupons;
            private String cou_name;
            private int cou_total;
            private String cou_man;
            private String cou_money;
            private int cou_user_num;
            private String cou_goods;
            private String spec_cat;
            private int cou_start_time;
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
            private String shop_name;
            private String cou_type_name;
            private String cou_goods_name;

            public int getUc_id() {
                return uc_id;
            }

            public void setUc_id(int uc_id) {
                this.uc_id = uc_id;
            }

            public int getCou_id() {
                return cou_id;
            }

            public void setCou_id(int cou_id) {
                this.cou_id = cou_id;
            }

            public String getUc_money() {
                return uc_money;
            }

            public void setUc_money(String uc_money) {
                this.uc_money = uc_money;
            }

            public GetCouponsBean getGet_coupons() {
                return get_coupons;
            }

            public void setGet_coupons(GetCouponsBean get_coupons) {
                this.get_coupons = get_coupons;
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

            public int getCou_start_time() {
                return cou_start_time;
            }

            public void setCou_start_time(int cou_start_time) {
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

            public String getShop_name() {
                return shop_name;
            }

            public void setShop_name(String shop_name) {
                this.shop_name = shop_name;
            }

            public String getCou_type_name() {
                return cou_type_name;
            }

            public void setCou_type_name(String cou_type_name) {
                this.cou_type_name = cou_type_name;
            }

            public String getCou_goods_name() {
                return cou_goods_name;
            }

            public void setCou_goods_name(String cou_goods_name) {
                this.cou_goods_name = cou_goods_name;
            }

            public static class GetCouponsBean {
                /**
                 * cou_id : 50
                 * cou_name : 满4749减854
                 * cou_total : 500
                 * cou_man : 4749
                 * cou_money : 854
                 * cou_user_num : 5
                 * cou_goods : 5936
                 * spec_cat :
                 * cou_start_time : 1560392451
                 * cou_end_time : 1592014853
                 * cou_type : 3
                 * cou_get_man : 0
                 * cou_ok_user : 9
                 * cou_ok_goods : 0
                 * cou_ok_cat :
                 * cou_intro :
                 * cou_add_time : 1560476773
                 * ru_id : 50059
                 * cou_order : 0
                 * cou_title : 优铂1.5匹挂
                 * review_status : 3
                 * review_content :
                 */

                private int cou_id;
                private String cou_name;
                private int cou_total;
                private String cou_man;
                private String cou_money;
                private int cou_user_num;
                private String cou_goods;
                private String spec_cat;
                private int cou_start_time;
                private int cou_end_time;
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

                public int getCou_start_time() {
                    return cou_start_time;
                }

                public void setCou_start_time(int cou_start_time) {
                    this.cou_start_time = cou_start_time;
                }

                public int getCou_end_time() {
                    return cou_end_time;
                }

                public void setCou_end_time(int cou_end_time) {
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
            }
        }

        public static class PaymentListBean {
            /**
             * pay_id : 15
             * pay_code : onlinepay
             * pay_name : 在线支付
             * pay_fee : 0
             * is_online : 0
             * pay_desc : 想要使用在线支付的一系列方法如支付宝,余额支付,就必须安装该插件,否则订单结算页不会显示"在线支付"按钮
             * pay_config : a:0:{}
             * is_cod : 0
             */

            private int pay_id;
            private String pay_code;
            private String pay_name;
            private String pay_fee;
            private int is_online;
            private String pay_desc;
            private String pay_config;
            private int is_cod;

            public int getPay_id() {
                return pay_id;
            }

            public void setPay_id(int pay_id) {
                this.pay_id = pay_id;
            }

            public String getPay_code() {
                return pay_code;
            }

            public void setPay_code(String pay_code) {
                this.pay_code = pay_code;
            }

            public String getPay_name() {
                return pay_name;
            }

            public void setPay_name(String pay_name) {
                this.pay_name = pay_name;
            }

            public String getPay_fee() {
                return pay_fee;
            }

            public void setPay_fee(String pay_fee) {
                this.pay_fee = pay_fee;
            }

            public int getIs_online() {
                return is_online;
            }

            public void setIs_online(int is_online) {
                this.is_online = is_online;
            }

            public String getPay_desc() {
                return pay_desc;
            }

            public void setPay_desc(String pay_desc) {
                this.pay_desc = pay_desc;
            }

            public String getPay_config() {
                return pay_config;
            }

            public void setPay_config(String pay_config) {
                this.pay_config = pay_config;
            }

            public int getIs_cod() {
                return is_cod;
            }

            public void setIs_cod(int is_cod) {
                this.is_cod = is_cod;
            }
        }

        public static class ValueCardBean {
            /**
             * tid : 2
             * vc_id : 62459
             * name : 齐鲁干细胞电子红包
             * card_money : 77.00
             * value_card_sn : 880000008743
             * end_time : 2020-01-08 17:46:40
             */

            private int tid;
            private int vc_id;
            private String name;
            private String card_money;
            private String value_card_sn;
            private String end_time;

            public int getTid() {
                return tid;
            }

            public void setTid(int tid) {
                this.tid = tid;
            }

            public int getVc_id() {
                return vc_id;
            }

            public void setVc_id(int vc_id) {
                this.vc_id = vc_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCard_money() {
                return card_money;
            }

            public void setCard_money(String card_money) {
                this.card_money = card_money;
            }

            public String getValue_card_sn() {
                return value_card_sn;
            }

            public void setValue_card_sn(String value_card_sn) {
                this.value_card_sn = value_card_sn;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }
        }
    }
}

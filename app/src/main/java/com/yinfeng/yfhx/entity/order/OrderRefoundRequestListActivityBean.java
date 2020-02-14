package com.yinfeng.yfhx.entity.order;

import java.util.List;

/**
 * ============================================
 * 描  述：单个店铺多个商品申请售后列表
 * 包  名：com.yinfeng.yfhx.fragments.home
 * 类  名：GeneralPurposeFragment
 * 创建人：liuguodong
 * 创建时间：2019/9/20 15:39
 * ============================================
 **/
public class OrderRefoundRequestListActivityBean  {

    /**
     * status : success
     * data : {"order_id":28775,"main_order_id":0,"order_sn":"2019121015174081383","user_id":50050,"order_status":5,"shipping_status":1,"pay_status":2,"consignee":"刘国栋","country":1,"province":370000,"city":370100,"district":370102,"street":0,"address":"高新区","zipcode":"","tel":"","mobile":"17600065050","email":"","best_time":"","sign_building":"","postscript":"","shipping_id":"37","shipping_name":"安能快递","shipping_code":"ane66","shipping_type":"0","pay_id":15,"pay_name":"在线支付","inv_id":0,"pay_type":"个人付款","how_oos":"等待所有商品备齐后再发","how_surplus":"","pack_name":"","card_name":"","card_message":"","inv_payee":"","inv_content":"不开发票","goods_amount":"101.00","cost_amount":"56.00","shipping_fee":"0.00","insure_fee":"0.00","pay_fee":"0.00","pack_fee":"0.00","card_fee":"0.00","money_paid":"0.00","surplus":"0.00","integral":0,"integral_money":"0.00","bonus":"0.00","order_amount":"0.00","return_amount":"0.00","from_ad":0,"referer":"本站","add_time":1575933217,"confirm_time":1575933217,"pay_time":1575933217,"sure_time":0,"shipping_time":1575933233,"confirm_take_time":0,"auto_delivery_time":15,"pack_id":0,"card_id":0,"bonus_id":0,"invoice_no":"4466666","extension_code":"","extension_id":0,"to_buyer":"","pay_note":"","agency_id":0,"inv_type":"","tax":"0.00","is_separate":0,"parent_id":0,"discount":"5.00","discount_all":"0.00","is_delete":0,"is_settlement":0,"sign_time":null,"is_single":0,"point_id":"0","shipping_dateStr":"","supplier_id":0,"froms":"pc","coupons":"0.00","uc_id":0,"is_zc_order":0,"zc_goods_id":0,"is_frozen":0,"drp_is_separate":0,"team_id":0,"team_parent_id":0,"team_user_id":0,"team_price":"0.00","chargeoff_status":0,"invoice_type":0,"vat_id":0,"tax_id":"","is_update_sale":1,"ru_id":50080,"main_count":0,"rel_name":"","id_num":"","rate_fee":"0.00","company_id":0,"company_name":"","buyer_name":"","buyer_mobile":"","buyer_company":"","buyer_department":"","buyer_duty":"","buyer_role":"","isold":0,"total_fee":"96.00","invoice_id":1,"use_val":96,"vc_dis":"1.00","tid":18,"vc_type":"礼品卡","pay_code":"onlinepay","child_order":0,"formated_goods_amount":"¥101.00","formated_cost_amount":"¥56.00","formated_profit_amount":"¥40.00","formated_discount":"¥5.00","formated_tax":"¥0.00","formated_shipping_fee":"¥0.00","formated_insure_fee":"¥0.00","formated_pay_fee":"¥0.00","formated_pack_fee":"¥0.00","formated_card_fee":"¥0.00","formated_total_fee":"¥96.00","formated_money_paid":"¥0.00","formated_bonus":"¥0.00","formated_coupons":"¥0.00","formated_integral_money":"¥0.00","formated_value_card":"¥96.00","formated_vc_dis":10,"formated_surplus":"¥0.00","formated_order_amount":"¥0.00","formated_realpay_amount":"¥0.00","formated_add_time":"2019-12-10 15:13:37","pay_points":0,"formated_red_amount":"¥0.00","formated_card_amount":0,"goods":[{"goods_name":"拉拉裤纸尿裤婴儿1","goods_id":5979,"goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201906/thumb_img/0_thumb_G_1560276428647.jpg","goods_cause":[{"cause":"1","lang":"七天无理由退货","is_checked":1},{"cause":"2","lang":"换货","is_checked":0},{"cause":"3","lang":"仅退款","is_checked":0}],"market_price":"¥120.00","goods_number":1,"goods_price":"¥50.00","subtotal":"¥50.00","is_refound":0,"goods_attr":"型号:XXL&nbsp;&nbsp;&nbsp;&nbsp;\n性别:男童&nbsp;&nbsp;&nbsp;&nbsp;\n","rec_id":43404,"activation_type":0,"refound_cancel":false,"ret_id":0,"extension_code":""},{"goods_name":"婴儿专用牙刷1","goods_id":6197,"goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201908/thumb_img/0_thumb_G_1566931565508.jpg","goods_cause":[{"cause":"1","lang":"七天无理由退货","is_checked":1},{"cause":"2","lang":"换货","is_checked":0},{"cause":"3","lang":"仅退款","is_checked":0}],"market_price":"¥91.50","goods_number":2,"goods_price":"¥25.50","subtotal":"¥51.00","is_refound":0,"goods_attr":"颜色:红色&nbsp;&nbsp;&nbsp;&nbsp;\n重量:200G&nbsp;&nbsp;&nbsp;&nbsp;\n","rec_id":43405,"activation_type":0,"refound_cancel":false,"ret_id":0,"extension_code":""}]}
     * time : 1576652967
     * timestamp : 1.57665296787608E9
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
         * order_id : 28775
         * main_order_id : 0
         * order_sn : 2019121015174081383
         * user_id : 50050
         * order_status : 5
         * shipping_status : 1
         * pay_status : 2
         * consignee : 刘国栋
         * country : 1
         * province : 370000
         * city : 370100
         * district : 370102
         * street : 0
         * address : 高新区
         * zipcode :
         * tel :
         * mobile : 17600065050
         * email :
         * best_time :
         * sign_building :
         * postscript :
         * shipping_id : 37
         * shipping_name : 安能快递
         * shipping_code : ane66
         * shipping_type : 0
         * pay_id : 15
         * pay_name : 在线支付
         * inv_id : 0
         * pay_type : 个人付款
         * how_oos : 等待所有商品备齐后再发
         * how_surplus :
         * pack_name :
         * card_name :
         * card_message :
         * inv_payee :
         * inv_content : 不开发票
         * goods_amount : 101.00
         * cost_amount : 56.00
         * shipping_fee : 0.00
         * insure_fee : 0.00
         * pay_fee : 0.00
         * pack_fee : 0.00
         * card_fee : 0.00
         * money_paid : 0.00
         * surplus : 0.00
         * integral : 0
         * integral_money : 0.00
         * bonus : 0.00
         * order_amount : 0.00
         * return_amount : 0.00
         * from_ad : 0
         * referer : 本站
         * add_time : 1575933217
         * confirm_time : 1575933217
         * pay_time : 1575933217
         * sure_time : 0
         * shipping_time : 1575933233
         * confirm_take_time : 0
         * auto_delivery_time : 15
         * pack_id : 0
         * card_id : 0
         * bonus_id : 0
         * invoice_no : 4466666
         * extension_code :
         * extension_id : 0
         * to_buyer :
         * pay_note :
         * agency_id : 0
         * inv_type :
         * tax : 0.00
         * is_separate : 0
         * parent_id : 0
         * discount : 5.00
         * discount_all : 0.00
         * is_delete : 0
         * is_settlement : 0
         * sign_time : null
         * is_single : 0
         * point_id : 0
         * shipping_dateStr :
         * supplier_id : 0
         * froms : pc
         * coupons : 0.00
         * uc_id : 0
         * is_zc_order : 0
         * zc_goods_id : 0
         * is_frozen : 0
         * drp_is_separate : 0
         * team_id : 0
         * team_parent_id : 0
         * team_user_id : 0
         * team_price : 0.00
         * chargeoff_status : 0
         * invoice_type : 0
         * vat_id : 0
         * tax_id :
         * is_update_sale : 1
         * ru_id : 50080
         * main_count : 0
         * rel_name :
         * id_num :
         * rate_fee : 0.00
         * company_id : 0
         * company_name :
         * buyer_name :
         * buyer_mobile :
         * buyer_company :
         * buyer_department :
         * buyer_duty :
         * buyer_role :
         * isold : 0
         * total_fee : 96.00
         * invoice_id : 1
         * use_val : 96
         * vc_dis : 1.00
         * tid : 18
         * vc_type : 礼品卡
         * pay_code : onlinepay
         * child_order : 0
         * formated_goods_amount : ¥101.00
         * formated_cost_amount : ¥56.00
         * formated_profit_amount : ¥40.00
         * formated_discount : ¥5.00
         * formated_tax : ¥0.00
         * formated_shipping_fee : ¥0.00
         * formated_insure_fee : ¥0.00
         * formated_pay_fee : ¥0.00
         * formated_pack_fee : ¥0.00
         * formated_card_fee : ¥0.00
         * formated_total_fee : ¥96.00
         * formated_money_paid : ¥0.00
         * formated_bonus : ¥0.00
         * formated_coupons : ¥0.00
         * formated_integral_money : ¥0.00
         * formated_value_card : ¥96.00
         * formated_vc_dis : 10
         * formated_surplus : ¥0.00
         * formated_order_amount : ¥0.00
         * formated_realpay_amount : ¥0.00
         * formated_add_time : 2019-12-10 15:13:37
         * pay_points : 0
         * formated_red_amount : ¥0.00
         * formated_card_amount : 0
         * goods : [{"goods_name":"拉拉裤纸尿裤婴儿1","goods_id":5979,"goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201906/thumb_img/0_thumb_G_1560276428647.jpg","goods_cause":[{"cause":"1","lang":"七天无理由退货","is_checked":1},{"cause":"2","lang":"换货","is_checked":0},{"cause":"3","lang":"仅退款","is_checked":0}],"market_price":"¥120.00","goods_number":1,"goods_price":"¥50.00","subtotal":"¥50.00","is_refound":0,"goods_attr":"型号:XXL&nbsp;&nbsp;&nbsp;&nbsp;\n性别:男童&nbsp;&nbsp;&nbsp;&nbsp;\n","rec_id":43404,"activation_type":0,"refound_cancel":false,"ret_id":0,"extension_code":""},{"goods_name":"婴儿专用牙刷1","goods_id":6197,"goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201908/thumb_img/0_thumb_G_1566931565508.jpg","goods_cause":[{"cause":"1","lang":"七天无理由退货","is_checked":1},{"cause":"2","lang":"换货","is_checked":0},{"cause":"3","lang":"仅退款","is_checked":0}],"market_price":"¥91.50","goods_number":2,"goods_price":"¥25.50","subtotal":"¥51.00","is_refound":0,"goods_attr":"颜色:红色&nbsp;&nbsp;&nbsp;&nbsp;\n重量:200G&nbsp;&nbsp;&nbsp;&nbsp;\n","rec_id":43405,"activation_type":0,"refound_cancel":false,"ret_id":0,"extension_code":""}]
         */

        private int order_id;
        private int main_order_id;
        private String order_sn;
        private int user_id;
        private int order_status;
        private int shipping_status;
        private int pay_status;
        private String consignee;
        private int country;
        private int province;
        private int city;
        private int district;
        private int street;
        private String address;
        private String zipcode;
        private String tel;
        private String mobile;
        private String email;
        private String best_time;
        private String sign_building;
        private String postscript;
        private String shipping_id;
        private String shipping_name;
        private String shipping_code;
        private String shipping_type;
        private int pay_id;
        private String pay_name;
        private int inv_id;
        private String pay_type;
        private String how_oos;
        private String how_surplus;
        private String pack_name;
        private String card_name;
        private String card_message;
        private String inv_payee;
        private String inv_content;
        private String goods_amount;
        private String cost_amount;
        private String shipping_fee;
        private String insure_fee;
        private String pay_fee;
        private String pack_fee;
        private String card_fee;
        private String money_paid;
        private String surplus;
        private int integral;
        private String integral_money;
        private String bonus;
        private String order_amount;
        private String return_amount;
        private int from_ad;
        private String referer;
        private int add_time;
        private int confirm_time;
        private int pay_time;
        private int sure_time;
        private int shipping_time;
        private int confirm_take_time;
        private int auto_delivery_time;
        private int pack_id;
        private int card_id;
        private int bonus_id;
        private String invoice_no;
        private String extension_code;
        private int extension_id;
        private String to_buyer;
        private String pay_note;
        private int agency_id;
        private String inv_type;
        private String tax;
        private int is_separate;
        private int parent_id;
        private String discount;
        private String discount_all;
        private int is_delete;
        private int is_settlement;
        private Object sign_time;
        private int is_single;
        private String point_id;
        private String shipping_dateStr;
        private int supplier_id;
        private String froms;
        private String coupons;
        private int uc_id;
        private int is_zc_order;
        private int zc_goods_id;
        private int is_frozen;
        private int drp_is_separate;
        private int team_id;
        private int team_parent_id;
        private int team_user_id;
        private String team_price;
        private int chargeoff_status;
        private int invoice_type;
        private int vat_id;
        private String tax_id;
        private int is_update_sale;
        private int ru_id;
        private int main_count;
        private String rel_name;
        private String id_num;
        private String rate_fee;
        private int company_id;
        private String company_name;
        private String buyer_name;
        private String buyer_mobile;
        private String buyer_company;
        private String buyer_department;
        private String buyer_duty;
        private String buyer_role;
        private int isold;
        private String total_fee;
        private int invoice_id;
        private int use_val;
        private String vc_dis;
        private int tid;
        private String vc_type;
        private String pay_code;
        private int child_order;
        private String formated_goods_amount;
        private String formated_cost_amount;
        private String formated_profit_amount;
        private String formated_discount;
        private String formated_tax;
        private String formated_shipping_fee;
        private String formated_insure_fee;
        private String formated_pay_fee;
        private String formated_pack_fee;
        private String formated_card_fee;
        private String formated_total_fee;
        private String formated_money_paid;
        private String formated_bonus;
        private String formated_coupons;
        private String formated_integral_money;
        private String formated_value_card;
        private int formated_vc_dis;
        private String formated_surplus;
        private String formated_order_amount;
        private String formated_realpay_amount;
        private String formated_add_time;
        private int pay_points;
        private String formated_red_amount;
        private int formated_card_amount;
        private List<GoodsBean> goods;

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public int getMain_order_id() {
            return main_order_id;
        }

        public void setMain_order_id(int main_order_id) {
            this.main_order_id = main_order_id;
        }

        public String getOrder_sn() {
            return order_sn;
        }

        public void setOrder_sn(String order_sn) {
            this.order_sn = order_sn;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getOrder_status() {
            return order_status;
        }

        public void setOrder_status(int order_status) {
            this.order_status = order_status;
        }

        public int getShipping_status() {
            return shipping_status;
        }

        public void setShipping_status(int shipping_status) {
            this.shipping_status = shipping_status;
        }

        public int getPay_status() {
            return pay_status;
        }

        public void setPay_status(int pay_status) {
            this.pay_status = pay_status;
        }

        public String getConsignee() {
            return consignee;
        }

        public void setConsignee(String consignee) {
            this.consignee = consignee;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getBest_time() {
            return best_time;
        }

        public void setBest_time(String best_time) {
            this.best_time = best_time;
        }

        public String getSign_building() {
            return sign_building;
        }

        public void setSign_building(String sign_building) {
            this.sign_building = sign_building;
        }

        public String getPostscript() {
            return postscript;
        }

        public void setPostscript(String postscript) {
            this.postscript = postscript;
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

        public String getShipping_code() {
            return shipping_code;
        }

        public void setShipping_code(String shipping_code) {
            this.shipping_code = shipping_code;
        }

        public String getShipping_type() {
            return shipping_type;
        }

        public void setShipping_type(String shipping_type) {
            this.shipping_type = shipping_type;
        }

        public int getPay_id() {
            return pay_id;
        }

        public void setPay_id(int pay_id) {
            this.pay_id = pay_id;
        }

        public String getPay_name() {
            return pay_name;
        }

        public void setPay_name(String pay_name) {
            this.pay_name = pay_name;
        }

        public int getInv_id() {
            return inv_id;
        }

        public void setInv_id(int inv_id) {
            this.inv_id = inv_id;
        }

        public String getPay_type() {
            return pay_type;
        }

        public void setPay_type(String pay_type) {
            this.pay_type = pay_type;
        }

        public String getHow_oos() {
            return how_oos;
        }

        public void setHow_oos(String how_oos) {
            this.how_oos = how_oos;
        }

        public String getHow_surplus() {
            return how_surplus;
        }

        public void setHow_surplus(String how_surplus) {
            this.how_surplus = how_surplus;
        }

        public String getPack_name() {
            return pack_name;
        }

        public void setPack_name(String pack_name) {
            this.pack_name = pack_name;
        }

        public String getCard_name() {
            return card_name;
        }

        public void setCard_name(String card_name) {
            this.card_name = card_name;
        }

        public String getCard_message() {
            return card_message;
        }

        public void setCard_message(String card_message) {
            this.card_message = card_message;
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

        public String getGoods_amount() {
            return goods_amount;
        }

        public void setGoods_amount(String goods_amount) {
            this.goods_amount = goods_amount;
        }

        public String getCost_amount() {
            return cost_amount;
        }

        public void setCost_amount(String cost_amount) {
            this.cost_amount = cost_amount;
        }

        public String getShipping_fee() {
            return shipping_fee;
        }

        public void setShipping_fee(String shipping_fee) {
            this.shipping_fee = shipping_fee;
        }

        public String getInsure_fee() {
            return insure_fee;
        }

        public void setInsure_fee(String insure_fee) {
            this.insure_fee = insure_fee;
        }

        public String getPay_fee() {
            return pay_fee;
        }

        public void setPay_fee(String pay_fee) {
            this.pay_fee = pay_fee;
        }

        public String getPack_fee() {
            return pack_fee;
        }

        public void setPack_fee(String pack_fee) {
            this.pack_fee = pack_fee;
        }

        public String getCard_fee() {
            return card_fee;
        }

        public void setCard_fee(String card_fee) {
            this.card_fee = card_fee;
        }

        public String getMoney_paid() {
            return money_paid;
        }

        public void setMoney_paid(String money_paid) {
            this.money_paid = money_paid;
        }

        public String getSurplus() {
            return surplus;
        }

        public void setSurplus(String surplus) {
            this.surplus = surplus;
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

        public String getBonus() {
            return bonus;
        }

        public void setBonus(String bonus) {
            this.bonus = bonus;
        }

        public String getOrder_amount() {
            return order_amount;
        }

        public void setOrder_amount(String order_amount) {
            this.order_amount = order_amount;
        }

        public String getReturn_amount() {
            return return_amount;
        }

        public void setReturn_amount(String return_amount) {
            this.return_amount = return_amount;
        }

        public int getFrom_ad() {
            return from_ad;
        }

        public void setFrom_ad(int from_ad) {
            this.from_ad = from_ad;
        }

        public String getReferer() {
            return referer;
        }

        public void setReferer(String referer) {
            this.referer = referer;
        }

        public int getAdd_time() {
            return add_time;
        }

        public void setAdd_time(int add_time) {
            this.add_time = add_time;
        }

        public int getConfirm_time() {
            return confirm_time;
        }

        public void setConfirm_time(int confirm_time) {
            this.confirm_time = confirm_time;
        }

        public int getPay_time() {
            return pay_time;
        }

        public void setPay_time(int pay_time) {
            this.pay_time = pay_time;
        }

        public int getSure_time() {
            return sure_time;
        }

        public void setSure_time(int sure_time) {
            this.sure_time = sure_time;
        }

        public int getShipping_time() {
            return shipping_time;
        }

        public void setShipping_time(int shipping_time) {
            this.shipping_time = shipping_time;
        }

        public int getConfirm_take_time() {
            return confirm_take_time;
        }

        public void setConfirm_take_time(int confirm_take_time) {
            this.confirm_take_time = confirm_take_time;
        }

        public int getAuto_delivery_time() {
            return auto_delivery_time;
        }

        public void setAuto_delivery_time(int auto_delivery_time) {
            this.auto_delivery_time = auto_delivery_time;
        }

        public int getPack_id() {
            return pack_id;
        }

        public void setPack_id(int pack_id) {
            this.pack_id = pack_id;
        }

        public int getCard_id() {
            return card_id;
        }

        public void setCard_id(int card_id) {
            this.card_id = card_id;
        }

        public int getBonus_id() {
            return bonus_id;
        }

        public void setBonus_id(int bonus_id) {
            this.bonus_id = bonus_id;
        }

        public String getInvoice_no() {
            return invoice_no;
        }

        public void setInvoice_no(String invoice_no) {
            this.invoice_no = invoice_no;
        }

        public String getExtension_code() {
            return extension_code;
        }

        public void setExtension_code(String extension_code) {
            this.extension_code = extension_code;
        }

        public int getExtension_id() {
            return extension_id;
        }

        public void setExtension_id(int extension_id) {
            this.extension_id = extension_id;
        }

        public String getTo_buyer() {
            return to_buyer;
        }

        public void setTo_buyer(String to_buyer) {
            this.to_buyer = to_buyer;
        }

        public String getPay_note() {
            return pay_note;
        }

        public void setPay_note(String pay_note) {
            this.pay_note = pay_note;
        }

        public int getAgency_id() {
            return agency_id;
        }

        public void setAgency_id(int agency_id) {
            this.agency_id = agency_id;
        }

        public String getInv_type() {
            return inv_type;
        }

        public void setInv_type(String inv_type) {
            this.inv_type = inv_type;
        }

        public String getTax() {
            return tax;
        }

        public void setTax(String tax) {
            this.tax = tax;
        }

        public int getIs_separate() {
            return is_separate;
        }

        public void setIs_separate(int is_separate) {
            this.is_separate = is_separate;
        }

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getDiscount_all() {
            return discount_all;
        }

        public void setDiscount_all(String discount_all) {
            this.discount_all = discount_all;
        }

        public int getIs_delete() {
            return is_delete;
        }

        public void setIs_delete(int is_delete) {
            this.is_delete = is_delete;
        }

        public int getIs_settlement() {
            return is_settlement;
        }

        public void setIs_settlement(int is_settlement) {
            this.is_settlement = is_settlement;
        }

        public Object getSign_time() {
            return sign_time;
        }

        public void setSign_time(Object sign_time) {
            this.sign_time = sign_time;
        }

        public int getIs_single() {
            return is_single;
        }

        public void setIs_single(int is_single) {
            this.is_single = is_single;
        }

        public String getPoint_id() {
            return point_id;
        }

        public void setPoint_id(String point_id) {
            this.point_id = point_id;
        }

        public String getShipping_dateStr() {
            return shipping_dateStr;
        }

        public void setShipping_dateStr(String shipping_dateStr) {
            this.shipping_dateStr = shipping_dateStr;
        }

        public int getSupplier_id() {
            return supplier_id;
        }

        public void setSupplier_id(int supplier_id) {
            this.supplier_id = supplier_id;
        }

        public String getFroms() {
            return froms;
        }

        public void setFroms(String froms) {
            this.froms = froms;
        }

        public String getCoupons() {
            return coupons;
        }

        public void setCoupons(String coupons) {
            this.coupons = coupons;
        }

        public int getUc_id() {
            return uc_id;
        }

        public void setUc_id(int uc_id) {
            this.uc_id = uc_id;
        }

        public int getIs_zc_order() {
            return is_zc_order;
        }

        public void setIs_zc_order(int is_zc_order) {
            this.is_zc_order = is_zc_order;
        }

        public int getZc_goods_id() {
            return zc_goods_id;
        }

        public void setZc_goods_id(int zc_goods_id) {
            this.zc_goods_id = zc_goods_id;
        }

        public int getIs_frozen() {
            return is_frozen;
        }

        public void setIs_frozen(int is_frozen) {
            this.is_frozen = is_frozen;
        }

        public int getDrp_is_separate() {
            return drp_is_separate;
        }

        public void setDrp_is_separate(int drp_is_separate) {
            this.drp_is_separate = drp_is_separate;
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

        public int getChargeoff_status() {
            return chargeoff_status;
        }

        public void setChargeoff_status(int chargeoff_status) {
            this.chargeoff_status = chargeoff_status;
        }

        public int getInvoice_type() {
            return invoice_type;
        }

        public void setInvoice_type(int invoice_type) {
            this.invoice_type = invoice_type;
        }

        public int getVat_id() {
            return vat_id;
        }

        public void setVat_id(int vat_id) {
            this.vat_id = vat_id;
        }

        public String getTax_id() {
            return tax_id;
        }

        public void setTax_id(String tax_id) {
            this.tax_id = tax_id;
        }

        public int getIs_update_sale() {
            return is_update_sale;
        }

        public void setIs_update_sale(int is_update_sale) {
            this.is_update_sale = is_update_sale;
        }

        public int getRu_id() {
            return ru_id;
        }

        public void setRu_id(int ru_id) {
            this.ru_id = ru_id;
        }

        public int getMain_count() {
            return main_count;
        }

        public void setMain_count(int main_count) {
            this.main_count = main_count;
        }

        public String getRel_name() {
            return rel_name;
        }

        public void setRel_name(String rel_name) {
            this.rel_name = rel_name;
        }

        public String getId_num() {
            return id_num;
        }

        public void setId_num(String id_num) {
            this.id_num = id_num;
        }

        public String getRate_fee() {
            return rate_fee;
        }

        public void setRate_fee(String rate_fee) {
            this.rate_fee = rate_fee;
        }

        public int getCompany_id() {
            return company_id;
        }

        public void setCompany_id(int company_id) {
            this.company_id = company_id;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getBuyer_name() {
            return buyer_name;
        }

        public void setBuyer_name(String buyer_name) {
            this.buyer_name = buyer_name;
        }

        public String getBuyer_mobile() {
            return buyer_mobile;
        }

        public void setBuyer_mobile(String buyer_mobile) {
            this.buyer_mobile = buyer_mobile;
        }

        public String getBuyer_company() {
            return buyer_company;
        }

        public void setBuyer_company(String buyer_company) {
            this.buyer_company = buyer_company;
        }

        public String getBuyer_department() {
            return buyer_department;
        }

        public void setBuyer_department(String buyer_department) {
            this.buyer_department = buyer_department;
        }

        public String getBuyer_duty() {
            return buyer_duty;
        }

        public void setBuyer_duty(String buyer_duty) {
            this.buyer_duty = buyer_duty;
        }

        public String getBuyer_role() {
            return buyer_role;
        }

        public void setBuyer_role(String buyer_role) {
            this.buyer_role = buyer_role;
        }

        public int getIsold() {
            return isold;
        }

        public void setIsold(int isold) {
            this.isold = isold;
        }

        public String getTotal_fee() {
            return total_fee;
        }

        public void setTotal_fee(String total_fee) {
            this.total_fee = total_fee;
        }

        public int getInvoice_id() {
            return invoice_id;
        }

        public void setInvoice_id(int invoice_id) {
            this.invoice_id = invoice_id;
        }

        public int getUse_val() {
            return use_val;
        }

        public void setUse_val(int use_val) {
            this.use_val = use_val;
        }

        public String getVc_dis() {
            return vc_dis;
        }

        public void setVc_dis(String vc_dis) {
            this.vc_dis = vc_dis;
        }

        public int getTid() {
            return tid;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }

        public String getVc_type() {
            return vc_type;
        }

        public void setVc_type(String vc_type) {
            this.vc_type = vc_type;
        }

        public String getPay_code() {
            return pay_code;
        }

        public void setPay_code(String pay_code) {
            this.pay_code = pay_code;
        }

        public int getChild_order() {
            return child_order;
        }

        public void setChild_order(int child_order) {
            this.child_order = child_order;
        }

        public String getFormated_goods_amount() {
            return formated_goods_amount;
        }

        public void setFormated_goods_amount(String formated_goods_amount) {
            this.formated_goods_amount = formated_goods_amount;
        }

        public String getFormated_cost_amount() {
            return formated_cost_amount;
        }

        public void setFormated_cost_amount(String formated_cost_amount) {
            this.formated_cost_amount = formated_cost_amount;
        }

        public String getFormated_profit_amount() {
            return formated_profit_amount;
        }

        public void setFormated_profit_amount(String formated_profit_amount) {
            this.formated_profit_amount = formated_profit_amount;
        }

        public String getFormated_discount() {
            return formated_discount;
        }

        public void setFormated_discount(String formated_discount) {
            this.formated_discount = formated_discount;
        }

        public String getFormated_tax() {
            return formated_tax;
        }

        public void setFormated_tax(String formated_tax) {
            this.formated_tax = formated_tax;
        }

        public String getFormated_shipping_fee() {
            return formated_shipping_fee;
        }

        public void setFormated_shipping_fee(String formated_shipping_fee) {
            this.formated_shipping_fee = formated_shipping_fee;
        }

        public String getFormated_insure_fee() {
            return formated_insure_fee;
        }

        public void setFormated_insure_fee(String formated_insure_fee) {
            this.formated_insure_fee = formated_insure_fee;
        }

        public String getFormated_pay_fee() {
            return formated_pay_fee;
        }

        public void setFormated_pay_fee(String formated_pay_fee) {
            this.formated_pay_fee = formated_pay_fee;
        }

        public String getFormated_pack_fee() {
            return formated_pack_fee;
        }

        public void setFormated_pack_fee(String formated_pack_fee) {
            this.formated_pack_fee = formated_pack_fee;
        }

        public String getFormated_card_fee() {
            return formated_card_fee;
        }

        public void setFormated_card_fee(String formated_card_fee) {
            this.formated_card_fee = formated_card_fee;
        }

        public String getFormated_total_fee() {
            return formated_total_fee;
        }

        public void setFormated_total_fee(String formated_total_fee) {
            this.formated_total_fee = formated_total_fee;
        }

        public String getFormated_money_paid() {
            return formated_money_paid;
        }

        public void setFormated_money_paid(String formated_money_paid) {
            this.formated_money_paid = formated_money_paid;
        }

        public String getFormated_bonus() {
            return formated_bonus;
        }

        public void setFormated_bonus(String formated_bonus) {
            this.formated_bonus = formated_bonus;
        }

        public String getFormated_coupons() {
            return formated_coupons;
        }

        public void setFormated_coupons(String formated_coupons) {
            this.formated_coupons = formated_coupons;
        }

        public String getFormated_integral_money() {
            return formated_integral_money;
        }

        public void setFormated_integral_money(String formated_integral_money) {
            this.formated_integral_money = formated_integral_money;
        }

        public String getFormated_value_card() {
            return formated_value_card;
        }

        public void setFormated_value_card(String formated_value_card) {
            this.formated_value_card = formated_value_card;
        }

        public int getFormated_vc_dis() {
            return formated_vc_dis;
        }

        public void setFormated_vc_dis(int formated_vc_dis) {
            this.formated_vc_dis = formated_vc_dis;
        }

        public String getFormated_surplus() {
            return formated_surplus;
        }

        public void setFormated_surplus(String formated_surplus) {
            this.formated_surplus = formated_surplus;
        }

        public String getFormated_order_amount() {
            return formated_order_amount;
        }

        public void setFormated_order_amount(String formated_order_amount) {
            this.formated_order_amount = formated_order_amount;
        }

        public String getFormated_realpay_amount() {
            return formated_realpay_amount;
        }

        public void setFormated_realpay_amount(String formated_realpay_amount) {
            this.formated_realpay_amount = formated_realpay_amount;
        }

        public String getFormated_add_time() {
            return formated_add_time;
        }

        public void setFormated_add_time(String formated_add_time) {
            this.formated_add_time = formated_add_time;
        }

        public int getPay_points() {
            return pay_points;
        }

        public void setPay_points(int pay_points) {
            this.pay_points = pay_points;
        }

        public String getFormated_red_amount() {
            return formated_red_amount;
        }

        public void setFormated_red_amount(String formated_red_amount) {
            this.formated_red_amount = formated_red_amount;
        }

        public int getFormated_card_amount() {
            return formated_card_amount;
        }

        public void setFormated_card_amount(int formated_card_amount) {
            this.formated_card_amount = formated_card_amount;
        }

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        public static class GoodsBean {
            /**
             * goods_name : 拉拉裤纸尿裤婴儿1
             * goods_id : 5979
             * goods_thumb : http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201906/thumb_img/0_thumb_G_1560276428647.jpg
             * goods_cause : [{"cause":"1","lang":"七天无理由退货","is_checked":1},{"cause":"2","lang":"换货","is_checked":0},{"cause":"3","lang":"仅退款","is_checked":0}]
             * market_price : ¥120.00
             * goods_number : 1
             * goods_price : ¥50.00
             * subtotal : ¥50.00
             * is_refound : 0
             * goods_attr : 型号:XXL&nbsp;&nbsp;&nbsp;&nbsp;
             性别:男童&nbsp;&nbsp;&nbsp;&nbsp;
             * rec_id : 43404
             * activation_type : 0
             * refound_cancel : false
             * ret_id : 0
             * extension_code :
             */

            private String goods_name;
            private int goods_id;
            private String goods_thumb;
            private String market_price;
            private int goods_number;
            private String goods_price;
            private String subtotal;
            private int is_refound;
            private String goods_attr;
            private int rec_id;
            private int activation_type;
            private boolean refound_cancel;
            private int ret_id;
            private String extension_code;
            private List<GoodsCauseBean> goods_cause;

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

            public String getGoods_thumb() {
                return goods_thumb;
            }

            public void setGoods_thumb(String goods_thumb) {
                this.goods_thumb = goods_thumb;
            }

            public String getMarket_price() {
                return market_price;
            }

            public void setMarket_price(String market_price) {
                this.market_price = market_price;
            }

            public int getGoods_number() {
                return goods_number;
            }

            public void setGoods_number(int goods_number) {
                this.goods_number = goods_number;
            }

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public String getSubtotal() {
                return subtotal;
            }

            public void setSubtotal(String subtotal) {
                this.subtotal = subtotal;
            }

            public int getIs_refound() {
                return is_refound;
            }

            public void setIs_refound(int is_refound) {
                this.is_refound = is_refound;
            }

            public String getGoods_attr() {
                return goods_attr;
            }

            public void setGoods_attr(String goods_attr) {
                this.goods_attr = goods_attr;
            }

            public int getRec_id() {
                return rec_id;
            }

            public void setRec_id(int rec_id) {
                this.rec_id = rec_id;
            }

            public int getActivation_type() {
                return activation_type;
            }

            public void setActivation_type(int activation_type) {
                this.activation_type = activation_type;
            }

            public boolean isRefound_cancel() {
                return refound_cancel;
            }

            public void setRefound_cancel(boolean refound_cancel) {
                this.refound_cancel = refound_cancel;
            }

            public int getRet_id() {
                return ret_id;
            }

            public void setRet_id(int ret_id) {
                this.ret_id = ret_id;
            }

            public String getExtension_code() {
                return extension_code;
            }

            public void setExtension_code(String extension_code) {
                this.extension_code = extension_code;
            }

            public List<GoodsCauseBean> getGoods_cause() {
                return goods_cause;
            }

            public void setGoods_cause(List<GoodsCauseBean> goods_cause) {
                this.goods_cause = goods_cause;
            }

            public static class GoodsCauseBean {
                /**
                 * cause : 1
                 * lang : 七天无理由退货
                 * is_checked : 1
                 */

                private String cause;
                private String lang;
                private int is_checked;

                public String getCause() {
                    return cause;
                }

                public void setCause(String cause) {
                    this.cause = cause;
                }

                public String getLang() {
                    return lang;
                }

                public void setLang(String lang) {
                    this.lang = lang;
                }

                public int getIs_checked() {
                    return is_checked;
                }

                public void setIs_checked(int is_checked) {
                    this.is_checked = is_checked;
                }
            }
        }
    }
}

package com.yinfeng.yfhx.entity.order;

import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.adapter.order
 * 类  名：OrderRefoundActivityBean
 * 创建人：liuguodong
 * 创建时间：2019/12/17 19:38
 * ============================================
 **/
public class OrderRefoundActivityBean {

    /**
     * status : success
     * data : [{"ret_id":130,"return_sn":"2019121719366960352","goods_id":6197,"user_id":50050,"rec_id":43405,"order_id":28775,"order_sn":"2019121015174081383","credentials":0,"maintain":0,"back":1,"goods_attr":"颜色:红色 \n重量:200G \n","exchange":0,"return_type":1,"attr_val":"","cause_id":1,"apply_time":"2019-12-17 19:36:08","return_time":0,"should_return":"¥25.50","actual_return":"0.00","return_shipping_fee":"0.00","return_brief":"212121","remark":"","country":0,"province":0,"city":0,"district":0,"street":110102003,"addressee":"刘国栋","phone":"17600065050","address":"高新区","zipcode":0,"is_check":0,"return_status":0,"refound_status":0,"back_shipping_name":"","back_other_shipping":"","back_invoice_no":"","out_shipping_name":"","out_invoice_no":"","agree_apply":0,"chargeoff_status":0,"activation_number":0,"refund_type":1,"return_trade_data":"","get_goods":{"goods_id":6197,"goods_thumb":"images/201908/thumb_img/0_thumb_G_1566931565508.jpg","goods_name":"婴儿专用牙刷1"},"get_order_goods":{"rec_id":43405,"extension_code":""},"get_return_goods":{"ret_id":130,"return_number":1},"goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201908/thumb_img/0_thumb_G_1566931565508.jpg","goods_name":"婴儿专用牙刷1","order_status":"<span>由用户寄回<\/span>","refound_cancel":true,"reimburse_status":"未退款","activation_type":0},{"ret_id":129,"return_sn":"2019121719397392250","goods_id":5979,"user_id":50050,"rec_id":43404,"order_id":28775,"order_sn":"2019121015174081383","credentials":0,"maintain":0,"back":1,"goods_attr":"型号:XXL \n性别:男童 \n","exchange":0,"return_type":1,"attr_val":"","cause_id":1,"apply_time":"2019-12-17 19:35:15","return_time":0,"should_return":"¥50.00","actual_return":"0.00","return_shipping_fee":"0.00","return_brief":"22222","remark":"","country":0,"province":0,"city":0,"district":0,"street":110102003,"addressee":"刘国栋","phone":"17600065050","address":"高新区","zipcode":0,"is_check":0,"return_status":0,"refound_status":0,"back_shipping_name":"","back_other_shipping":"","back_invoice_no":"","out_shipping_name":"","out_invoice_no":"","agree_apply":0,"chargeoff_status":0,"activation_number":0,"refund_type":1,"return_trade_data":"","get_goods":{"goods_id":5979,"goods_thumb":"images/201906/thumb_img/0_thumb_G_1560276428647.jpg","goods_name":"拉拉裤纸尿裤婴儿1"},"get_order_goods":{"rec_id":43404,"extension_code":""},"get_return_goods":{"ret_id":129,"return_number":1},"goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201906/thumb_img/0_thumb_G_1560276428647.jpg","goods_name":"拉拉裤纸尿裤婴儿1","order_status":"<span>由用户寄回<\/span>","refound_cancel":true,"reimburse_status":"未退款","activation_type":0}]
     * time : 1576582582
     * timestamp : 1.576582582279596E9
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
         * ret_id : 130
         * return_sn : 2019121719366960352
         * goods_id : 6197
         * user_id : 50050
         * rec_id : 43405
         * order_id : 28775
         * order_sn : 2019121015174081383
         * credentials : 0
         * maintain : 0
         * back : 1
         * goods_attr : 颜色:红色
         重量:200G
         * exchange : 0
         * return_type : 1
         * attr_val :
         * cause_id : 1
         * apply_time : 2019-12-17 19:36:08
         * return_time : 0
         * should_return : ¥25.50
         * actual_return : 0.00
         * return_shipping_fee : 0.00
         * return_brief : 212121
         * remark :
         * country : 0
         * province : 0
         * city : 0
         * district : 0
         * street : 110102003
         * addressee : 刘国栋
         * phone : 17600065050
         * address : 高新区
         * zipcode : 0
         * is_check : 0
         * return_status : 0
         * refound_status : 0
         * back_shipping_name :
         * back_other_shipping :
         * back_invoice_no :
         * out_shipping_name :
         * out_invoice_no :
         * agree_apply : 0
         * chargeoff_status : 0
         * activation_number : 0
         * refund_type : 1
         * return_trade_data :
         * get_goods : {"goods_id":6197,"goods_thumb":"images/201908/thumb_img/0_thumb_G_1566931565508.jpg","goods_name":"婴儿专用牙刷1"}
         * get_order_goods : {"rec_id":43405,"extension_code":""}
         * get_return_goods : {"ret_id":130,"return_number":1}
         * goods_thumb : http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201908/thumb_img/0_thumb_G_1566931565508.jpg
         * goods_name : 婴儿专用牙刷1
         * order_status : <span>由用户寄回</span>
         * refound_cancel : true
         * reimburse_status : 未退款
         * activation_type : 0
         */

        private int ret_id;
        private String return_sn;
        private int goods_id;
        private int user_id;
        private int rec_id;
        private int order_id;
        private String order_sn;
        private int credentials;
        private int maintain;
        private int back;
        private String goods_attr;
        private int exchange;
        private int return_type;
        private String attr_val;
        private int cause_id;
        private String apply_time;
        private int return_time;
        private String should_return;
        private String actual_return;
        private String return_shipping_fee;
        private String return_brief;
        private String remark;
        private int country;
        private int province;
        private int city;
        private int district;
        private int street;
        private String addressee;
        private String phone;
        private String address;
        private int zipcode;
        private int is_check;
        private int return_status;
        private int refound_status;
        private String back_shipping_name;
        private String back_other_shipping;
        private String back_invoice_no;
        private String out_shipping_name;
        private String out_invoice_no;
        private int agree_apply;
        private int chargeoff_status;
        private int activation_number;
        private int refund_type;
        private String return_trade_data;
        private GetGoodsBean get_goods;
        private GetOrderGoodsBean get_order_goods;
        private GetReturnGoodsBean get_return_goods;
        private String goods_thumb;
        private String goods_name;
        private String order_status;
        private boolean refound_cancel;
        private String reimburse_status;
        private int activation_type;

        public int getRet_id() {
            return ret_id;
        }

        public void setRet_id(int ret_id) {
            this.ret_id = ret_id;
        }

        public String getReturn_sn() {
            return return_sn;
        }

        public void setReturn_sn(String return_sn) {
            this.return_sn = return_sn;
        }

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getRec_id() {
            return rec_id;
        }

        public void setRec_id(int rec_id) {
            this.rec_id = rec_id;
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

        public int getCredentials() {
            return credentials;
        }

        public void setCredentials(int credentials) {
            this.credentials = credentials;
        }

        public int getMaintain() {
            return maintain;
        }

        public void setMaintain(int maintain) {
            this.maintain = maintain;
        }

        public int getBack() {
            return back;
        }

        public void setBack(int back) {
            this.back = back;
        }

        public String getGoods_attr() {
            return goods_attr;
        }

        public void setGoods_attr(String goods_attr) {
            this.goods_attr = goods_attr;
        }

        public int getExchange() {
            return exchange;
        }

        public void setExchange(int exchange) {
            this.exchange = exchange;
        }

        public int getReturn_type() {
            return return_type;
        }

        public void setReturn_type(int return_type) {
            this.return_type = return_type;
        }

        public String getAttr_val() {
            return attr_val;
        }

        public void setAttr_val(String attr_val) {
            this.attr_val = attr_val;
        }

        public int getCause_id() {
            return cause_id;
        }

        public void setCause_id(int cause_id) {
            this.cause_id = cause_id;
        }

        public String getApply_time() {
            return apply_time;
        }

        public void setApply_time(String apply_time) {
            this.apply_time = apply_time;
        }

        public int getReturn_time() {
            return return_time;
        }

        public void setReturn_time(int return_time) {
            this.return_time = return_time;
        }

        public String getShould_return() {
            return should_return;
        }

        public void setShould_return(String should_return) {
            this.should_return = should_return;
        }

        public String getActual_return() {
            return actual_return;
        }

        public void setActual_return(String actual_return) {
            this.actual_return = actual_return;
        }

        public String getReturn_shipping_fee() {
            return return_shipping_fee;
        }

        public void setReturn_shipping_fee(String return_shipping_fee) {
            this.return_shipping_fee = return_shipping_fee;
        }

        public String getReturn_brief() {
            return return_brief;
        }

        public void setReturn_brief(String return_brief) {
            this.return_brief = return_brief;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
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

        public String getAddressee() {
            return addressee;
        }

        public void setAddressee(String addressee) {
            this.addressee = addressee;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getZipcode() {
            return zipcode;
        }

        public void setZipcode(int zipcode) {
            this.zipcode = zipcode;
        }

        public int getIs_check() {
            return is_check;
        }

        public void setIs_check(int is_check) {
            this.is_check = is_check;
        }

        public int getReturn_status() {
            return return_status;
        }

        public void setReturn_status(int return_status) {
            this.return_status = return_status;
        }

        public int getRefound_status() {
            return refound_status;
        }

        public void setRefound_status(int refound_status) {
            this.refound_status = refound_status;
        }

        public String getBack_shipping_name() {
            return back_shipping_name;
        }

        public void setBack_shipping_name(String back_shipping_name) {
            this.back_shipping_name = back_shipping_name;
        }

        public String getBack_other_shipping() {
            return back_other_shipping;
        }

        public void setBack_other_shipping(String back_other_shipping) {
            this.back_other_shipping = back_other_shipping;
        }

        public String getBack_invoice_no() {
            return back_invoice_no;
        }

        public void setBack_invoice_no(String back_invoice_no) {
            this.back_invoice_no = back_invoice_no;
        }

        public String getOut_shipping_name() {
            return out_shipping_name;
        }

        public void setOut_shipping_name(String out_shipping_name) {
            this.out_shipping_name = out_shipping_name;
        }

        public String getOut_invoice_no() {
            return out_invoice_no;
        }

        public void setOut_invoice_no(String out_invoice_no) {
            this.out_invoice_no = out_invoice_no;
        }

        public int getAgree_apply() {
            return agree_apply;
        }

        public void setAgree_apply(int agree_apply) {
            this.agree_apply = agree_apply;
        }

        public int getChargeoff_status() {
            return chargeoff_status;
        }

        public void setChargeoff_status(int chargeoff_status) {
            this.chargeoff_status = chargeoff_status;
        }

        public int getActivation_number() {
            return activation_number;
        }

        public void setActivation_number(int activation_number) {
            this.activation_number = activation_number;
        }

        public int getRefund_type() {
            return refund_type;
        }

        public void setRefund_type(int refund_type) {
            this.refund_type = refund_type;
        }

        public String getReturn_trade_data() {
            return return_trade_data;
        }

        public void setReturn_trade_data(String return_trade_data) {
            this.return_trade_data = return_trade_data;
        }

        public GetGoodsBean getGet_goods() {
            return get_goods;
        }

        public void setGet_goods(GetGoodsBean get_goods) {
            this.get_goods = get_goods;
        }

        public GetOrderGoodsBean getGet_order_goods() {
            return get_order_goods;
        }

        public void setGet_order_goods(GetOrderGoodsBean get_order_goods) {
            this.get_order_goods = get_order_goods;
        }

        public GetReturnGoodsBean getGet_return_goods() {
            return get_return_goods;
        }

        public void setGet_return_goods(GetReturnGoodsBean get_return_goods) {
            this.get_return_goods = get_return_goods;
        }

        public String getGoods_thumb() {
            return goods_thumb;
        }

        public void setGoods_thumb(String goods_thumb) {
            this.goods_thumb = goods_thumb;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getOrder_status() {
            return order_status;
        }

        public void setOrder_status(String order_status) {
            this.order_status = order_status;
        }

        public boolean isRefound_cancel() {
            return refound_cancel;
        }

        public void setRefound_cancel(boolean refound_cancel) {
            this.refound_cancel = refound_cancel;
        }

        public String getReimburse_status() {
            return reimburse_status;
        }

        public void setReimburse_status(String reimburse_status) {
            this.reimburse_status = reimburse_status;
        }

        public int getActivation_type() {
            return activation_type;
        }

        public void setActivation_type(int activation_type) {
            this.activation_type = activation_type;
        }

        public static class GetGoodsBean {
            /**
             * goods_id : 6197
             * goods_thumb : images/201908/thumb_img/0_thumb_G_1566931565508.jpg
             * goods_name : 婴儿专用牙刷1
             */

            private int goods_id;
            private String goods_thumb;
            private String goods_name;

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

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }
        }

        public static class GetOrderGoodsBean {
            /**
             * rec_id : 43405
             * extension_code :
             */

            private int rec_id;
            private String extension_code;

            public int getRec_id() {
                return rec_id;
            }

            public void setRec_id(int rec_id) {
                this.rec_id = rec_id;
            }

            public String getExtension_code() {
                return extension_code;
            }

            public void setExtension_code(String extension_code) {
                this.extension_code = extension_code;
            }
        }

        public static class GetReturnGoodsBean {
            /**
             * ret_id : 130
             * return_number : 1
             */

            private int ret_id;
            private int return_number;

            public int getRet_id() {
                return ret_id;
            }

            public void setRet_id(int ret_id) {
                this.ret_id = ret_id;
            }

            public int getReturn_number() {
                return return_number;
            }

            public void setReturn_number(int return_number) {
                this.return_number = return_number;
            }
        }
    }
}

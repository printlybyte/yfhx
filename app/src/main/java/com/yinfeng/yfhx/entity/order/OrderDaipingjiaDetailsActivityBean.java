package com.yinfeng.yfhx.entity.order;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity.order
 * 类  名：OrderDaipingjiaDetailsActivityBean
 * 创建人：liuguodong
 * 创建时间：2019/12/20 19:11
 * ============================================
 **/
public class OrderDaipingjiaDetailsActivityBean {

    /**
     * status : success
     * data : {"rec_id":43404,"order_id":28775,"user_id":50050,"cart_recid":"2068","goods_id":5979,"goods_name":"拉拉裤纸尿裤婴儿1","goods_sn":"ECS005979","product_id":526,"goods_number":1,"market_price":"120.00","goods_price":"50.00","cost_price":"45.00","goods_attr":"型号:XXL \n性别:男童 \n","send_number":1,"is_real":1,"extension_code":"","parent_id":0,"is_gift":0,"model_attr":0,"goods_attr_id":"593,594","ru_id":50080,"shopping_fee":"0.00","warehouse_id":1,"area_id":13431,"area_city":13432,"is_single":0,"freight":2,"tid":63,"shipping_fee":"0.00","drp_money":"0.00","is_distribution":0,"commission_rate":"0","stages_qishu":-1,"product_sn":null,"is_reality":-1,"is_return":-1,"is_fast":-1,"rate_price":"0.00","goods_unit":"个","goods_bill_name":"拉拉裤纸尿裤婴儿幼儿1","top_category":"母婴、玩具乐器","shop_price":"¥50.00","goods_thumb":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201906/thumb_img/0_thumb_G_1560276428647.jpg"}
     * time : 1576840328
     * timestamp : 1.576840328589413E9
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
         * rec_id : 43404
         * order_id : 28775
         * user_id : 50050
         * cart_recid : 2068
         * goods_id : 5979
         * goods_name : 拉拉裤纸尿裤婴儿1
         * goods_sn : ECS005979
         * product_id : 526
         * goods_number : 1
         * market_price : 120.00
         * goods_price : 50.00
         * cost_price : 45.00
         * goods_attr : 型号:XXL
         性别:男童
         * send_number : 1
         * is_real : 1
         * extension_code :
         * parent_id : 0
         * is_gift : 0
         * model_attr : 0
         * goods_attr_id : 593,594
         * ru_id : 50080
         * shopping_fee : 0.00
         * warehouse_id : 1
         * area_id : 13431
         * area_city : 13432
         * is_single : 0
         * freight : 2
         * tid : 63
         * shipping_fee : 0.00
         * drp_money : 0.00
         * is_distribution : 0
         * commission_rate : 0
         * stages_qishu : -1
         * product_sn : null
         * is_reality : -1
         * is_return : -1
         * is_fast : -1
         * rate_price : 0.00
         * goods_unit : 个
         * goods_bill_name : 拉拉裤纸尿裤婴儿幼儿1
         * top_category : 母婴、玩具乐器
         * shop_price : ¥50.00
         * goods_thumb : http://yinfenghui.oss-cn-beijing.aliyuncs.com/images/201906/thumb_img/0_thumb_G_1560276428647.jpg
         */

        private int rec_id;
        private int order_id;
        private int user_id;
        private String cart_recid;
        private int goods_id;
        private String goods_name;
        private String goods_sn;
        private int product_id;
        private int goods_number;
        private String market_price;
        private String goods_price;
        private String cost_price;
        private String goods_attr;
        private int send_number;
        private int is_real;
        private String extension_code;
        private int parent_id;
        private int is_gift;
        private int model_attr;
        private String goods_attr_id;
        private int ru_id;
        private String shopping_fee;
        private int warehouse_id;
        private int area_id;
        private int area_city;
        private int is_single;
        private int freight;
        private int tid;
        private String shipping_fee;
        private String drp_money;
        private int is_distribution;
        private String commission_rate;
        private int stages_qishu;
        private Object product_sn;
        private int is_reality;
        private int is_return;
        private int is_fast;
        private String rate_price;
        private String goods_unit;
        private String goods_bill_name;
        private String top_category;
        private String shop_price;
        private String goods_thumb;

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

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getCart_recid() {
            return cart_recid;
        }

        public void setCart_recid(String cart_recid) {
            this.cart_recid = cart_recid;
        }

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

        public String getGoods_sn() {
            return goods_sn;
        }

        public void setGoods_sn(String goods_sn) {
            this.goods_sn = goods_sn;
        }

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
        }

        public int getGoods_number() {
            return goods_number;
        }

        public void setGoods_number(int goods_number) {
            this.goods_number = goods_number;
        }

        public String getMarket_price() {
            return market_price;
        }

        public void setMarket_price(String market_price) {
            this.market_price = market_price;
        }

        public String getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(String goods_price) {
            this.goods_price = goods_price;
        }

        public String getCost_price() {
            return cost_price;
        }

        public void setCost_price(String cost_price) {
            this.cost_price = cost_price;
        }

        public String getGoods_attr() {
            return goods_attr;
        }

        public void setGoods_attr(String goods_attr) {
            this.goods_attr = goods_attr;
        }

        public int getSend_number() {
            return send_number;
        }

        public void setSend_number(int send_number) {
            this.send_number = send_number;
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

        public String getGoods_attr_id() {
            return goods_attr_id;
        }

        public void setGoods_attr_id(String goods_attr_id) {
            this.goods_attr_id = goods_attr_id;
        }

        public int getRu_id() {
            return ru_id;
        }

        public void setRu_id(int ru_id) {
            this.ru_id = ru_id;
        }

        public String getShopping_fee() {
            return shopping_fee;
        }

        public void setShopping_fee(String shopping_fee) {
            this.shopping_fee = shopping_fee;
        }

        public int getWarehouse_id() {
            return warehouse_id;
        }

        public void setWarehouse_id(int warehouse_id) {
            this.warehouse_id = warehouse_id;
        }

        public int getArea_id() {
            return area_id;
        }

        public void setArea_id(int area_id) {
            this.area_id = area_id;
        }

        public int getArea_city() {
            return area_city;
        }

        public void setArea_city(int area_city) {
            this.area_city = area_city;
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

        public int getTid() {
            return tid;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }

        public String getShipping_fee() {
            return shipping_fee;
        }

        public void setShipping_fee(String shipping_fee) {
            this.shipping_fee = shipping_fee;
        }

        public String getDrp_money() {
            return drp_money;
        }

        public void setDrp_money(String drp_money) {
            this.drp_money = drp_money;
        }

        public int getIs_distribution() {
            return is_distribution;
        }

        public void setIs_distribution(int is_distribution) {
            this.is_distribution = is_distribution;
        }

        public String getCommission_rate() {
            return commission_rate;
        }

        public void setCommission_rate(String commission_rate) {
            this.commission_rate = commission_rate;
        }

        public int getStages_qishu() {
            return stages_qishu;
        }

        public void setStages_qishu(int stages_qishu) {
            this.stages_qishu = stages_qishu;
        }

        public Object getProduct_sn() {
            return product_sn;
        }

        public void setProduct_sn(Object product_sn) {
            this.product_sn = product_sn;
        }

        public int getIs_reality() {
            return is_reality;
        }

        public void setIs_reality(int is_reality) {
            this.is_reality = is_reality;
        }

        public int getIs_return() {
            return is_return;
        }

        public void setIs_return(int is_return) {
            this.is_return = is_return;
        }

        public int getIs_fast() {
            return is_fast;
        }

        public void setIs_fast(int is_fast) {
            this.is_fast = is_fast;
        }

        public String getRate_price() {
            return rate_price;
        }

        public void setRate_price(String rate_price) {
            this.rate_price = rate_price;
        }

        public String getGoods_unit() {
            return goods_unit;
        }

        public void setGoods_unit(String goods_unit) {
            this.goods_unit = goods_unit;
        }

        public String getGoods_bill_name() {
            return goods_bill_name;
        }

        public void setGoods_bill_name(String goods_bill_name) {
            this.goods_bill_name = goods_bill_name;
        }

        public String getTop_category() {
            return top_category;
        }

        public void setTop_category(String top_category) {
            this.top_category = top_category;
        }

        public String getShop_price() {
            return shop_price;
        }

        public void setShop_price(String shop_price) {
            this.shop_price = shop_price;
        }

        public String getGoods_thumb() {
            return goods_thumb;
        }

        public void setGoods_thumb(String goods_thumb) {
            this.goods_thumb = goods_thumb;
        }
    }
}

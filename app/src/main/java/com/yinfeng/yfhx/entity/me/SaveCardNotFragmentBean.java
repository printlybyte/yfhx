package com.yinfeng.yfhx.entity.me;

import java.util.List;

/**
 * ============================================
 * 描  述：优惠券-未使用
 * 包  名：com.yinfeng.yfhx.fragments.home
 * 类  名：GeneralPurposeFragment
 * 创建人：liuguodong
 * 创建时间：2019/9/20 15:39
 * ============================================
 **/
public class SaveCardNotFragmentBean  {

    /**
     * status : success
     * data : {"enbale":[{"vid":27,"tid":2,"value_card_sn":"880000000016 ","value_card_password":"A9QY9M22M","user_id":22,"vc_value":"¥1000.00","card_money":"1.00","bind_time":"2018-07-13 11:30:15","end_time":"2021-11-16 01:29:25","company":"齐鲁干细胞","card_title":"","area":"济南济阳","hospital":"济南市济阳县人民医院","jffa":"2018-脐血趸-20","pk_id":"0001C9100000001BOF05","add_time":0,"id":2,"name":"齐鲁干细胞电子红包","use_condition":"全部商品","is_rec":0,"status":true}],"unable":[{"vid":14,"tid":2,"value_card_sn":"880000000003 ","value_card_password":"A9QY9M9M","user_id":22,"vc_value":"¥500.00","card_money":"0.00","bind_time":"2018-07-13 11:30:15","end_time":"2021-11-11 21:16:55","company":"齐鲁干细胞","card_title":"","area":"泰安市区","hospital":"泰安市中心医院","jffa":"2018-脐血趸-20","pk_id":"0001C9100000001BOF29","add_time":0,"id":2,"name":"齐鲁干细胞电子红包","use_condition":"全部商品","is_rec":0,"status":true},{"vid":13,"tid":2,"value_card_sn":"880000000002 ","value_card_password":"A9QY9M8M","user_id":22,"vc_value":"¥100.00","card_money":"0.00","bind_time":"2018-07-13 11:30:14","end_time":"2021-11-11 21:16:54","company":"齐鲁干细胞","card_title":"","area":"泰安市区","hospital":"泰安市中心医院","jffa":"2018-脐血趸-20","pk_id":"0001C9100000001BOF2B","add_time":0,"id":2,"name":"齐鲁干细胞电子红包","use_condition":"全部商品","is_rec":0,"status":true},{"vid":12,"tid":2,"value_card_sn":"880000000001 ","value_card_password":"A9QY9M7M","user_id":22,"vc_value":"¥1000.00","card_money":"836.00","bind_time":"2018-07-11 14:08:06","end_time":"2022-11-11 01:45:53","company":"齐鲁干细胞","card_title":"","area":"滨州市区","hospital":"滨州医学院附属医院","jffa":"2018-脐血趸-20","pk_id":"0001C9100000001BOITV","add_time":0,"id":2,"name":"齐鲁干细胞电子红包","use_condition":"全部商品","is_rec":0,"status":true}]}
     * time : 1571888227
     * timestamp : 1.571888227056407E9
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
        private List<EnbaleBean> enbale;
        private List<UnableBean> unable;

        public List<EnbaleBean> getEnbale() {
            return enbale;
        }

        public void setEnbale(List<EnbaleBean> enbale) {
            this.enbale = enbale;
        }

        public List<UnableBean> getUnable() {
            return unable;
        }

        public void setUnable(List<UnableBean> unable) {
            this.unable = unable;
        }

        public static class EnbaleBean {
            /**
             * vid : 27
             * tid : 2
             * value_card_sn : 880000000016
             * value_card_password : A9QY9M22M
             * user_id : 22
             * vc_value : ¥1000.00
             * card_money : 1.00
             * bind_time : 2018-07-13 11:30:15
             * end_time : 2021-11-16 01:29:25
             * company : 齐鲁干细胞
             * card_title :
             * area : 济南济阳
             * hospital : 济南市济阳县人民医院
             * jffa : 2018-脐血趸-20
             * pk_id : 0001C9100000001BOF05
             * add_time : 0
             * id : 2
             * name : 齐鲁干细胞电子红包
             * use_condition : 全部商品
             * is_rec : 0
             * status : true
             */

            private int vid;
            private int tid;
            private String value_card_sn;
            private String value_card_password;
            private int user_id;
            private String vc_value;
            private String card_money;
            private String bind_time;
            private String end_time;
            private String company;
            private String card_title;
            private String area;
            private String hospital;
            private String jffa;
            private String pk_id;
            private int add_time;
            private int id;
            private String name;
            private String use_condition;
            private int is_rec;
            private boolean status;

            public int getVid() {
                return vid;
            }

            public void setVid(int vid) {
                this.vid = vid;
            }

            public int getTid() {
                return tid;
            }

            public void setTid(int tid) {
                this.tid = tid;
            }

            public String getValue_card_sn() {
                return value_card_sn;
            }

            public void setValue_card_sn(String value_card_sn) {
                this.value_card_sn = value_card_sn;
            }

            public String getValue_card_password() {
                return value_card_password;
            }

            public void setValue_card_password(String value_card_password) {
                this.value_card_password = value_card_password;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getVc_value() {
                return vc_value;
            }

            public void setVc_value(String vc_value) {
                this.vc_value = vc_value;
            }

            public String getCard_money() {
                return card_money;
            }

            public void setCard_money(String card_money) {
                this.card_money = card_money;
            }

            public String getBind_time() {
                return bind_time;
            }

            public void setBind_time(String bind_time) {
                this.bind_time = bind_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getCard_title() {
                return card_title;
            }

            public void setCard_title(String card_title) {
                this.card_title = card_title;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getHospital() {
                return hospital;
            }

            public void setHospital(String hospital) {
                this.hospital = hospital;
            }

            public String getJffa() {
                return jffa;
            }

            public void setJffa(String jffa) {
                this.jffa = jffa;
            }

            public String getPk_id() {
                return pk_id;
            }

            public void setPk_id(String pk_id) {
                this.pk_id = pk_id;
            }

            public int getAdd_time() {
                return add_time;
            }

            public void setAdd_time(int add_time) {
                this.add_time = add_time;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUse_condition() {
                return use_condition;
            }

            public void setUse_condition(String use_condition) {
                this.use_condition = use_condition;
            }

            public int getIs_rec() {
                return is_rec;
            }

            public void setIs_rec(int is_rec) {
                this.is_rec = is_rec;
            }

            public boolean isStatus() {
                return status;
            }

            public void setStatus(boolean status) {
                this.status = status;
            }
        }

        public static class UnableBean {
            /**
             * vid : 14
             * tid : 2
             * value_card_sn : 880000000003
             * value_card_password : A9QY9M9M
             * user_id : 22
             * vc_value : ¥500.00
             * card_money : 0.00
             * bind_time : 2018-07-13 11:30:15
             * end_time : 2021-11-11 21:16:55
             * company : 齐鲁干细胞
             * card_title :
             * area : 泰安市区
             * hospital : 泰安市中心医院
             * jffa : 2018-脐血趸-20
             * pk_id : 0001C9100000001BOF29
             * add_time : 0
             * id : 2
             * name : 齐鲁干细胞电子红包
             * use_condition : 全部商品
             * is_rec : 0
             * status : true
             */

            private int vid;
            private int tid;
            private String value_card_sn;
            private String value_card_password;
            private int user_id;
            private String vc_value;
            private String card_money;
            private String bind_time;
            private String end_time;
            private String company;
            private String card_title;
            private String area;
            private String hospital;
            private String jffa;
            private String pk_id;
            private int add_time;
            private int id;
            private String name;
            private String use_condition;
            private int is_rec;
            private boolean status;

            public int getVid() {
                return vid;
            }

            public void setVid(int vid) {
                this.vid = vid;
            }

            public int getTid() {
                return tid;
            }

            public void setTid(int tid) {
                this.tid = tid;
            }

            public String getValue_card_sn() {
                return value_card_sn;
            }

            public void setValue_card_sn(String value_card_sn) {
                this.value_card_sn = value_card_sn;
            }

            public String getValue_card_password() {
                return value_card_password;
            }

            public void setValue_card_password(String value_card_password) {
                this.value_card_password = value_card_password;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getVc_value() {
                return vc_value;
            }

            public void setVc_value(String vc_value) {
                this.vc_value = vc_value;
            }

            public String getCard_money() {
                return card_money;
            }

            public void setCard_money(String card_money) {
                this.card_money = card_money;
            }

            public String getBind_time() {
                return bind_time;
            }

            public void setBind_time(String bind_time) {
                this.bind_time = bind_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getCard_title() {
                return card_title;
            }

            public void setCard_title(String card_title) {
                this.card_title = card_title;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getHospital() {
                return hospital;
            }

            public void setHospital(String hospital) {
                this.hospital = hospital;
            }

            public String getJffa() {
                return jffa;
            }

            public void setJffa(String jffa) {
                this.jffa = jffa;
            }

            public String getPk_id() {
                return pk_id;
            }

            public void setPk_id(String pk_id) {
                this.pk_id = pk_id;
            }

            public int getAdd_time() {
                return add_time;
            }

            public void setAdd_time(int add_time) {
                this.add_time = add_time;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUse_condition() {
                return use_condition;
            }

            public void setUse_condition(String use_condition) {
                this.use_condition = use_condition;
            }

            public int getIs_rec() {
                return is_rec;
            }

            public void setIs_rec(int is_rec) {
                this.is_rec = is_rec;
            }

            public boolean isStatus() {
                return status;
            }

            public void setStatus(boolean status) {
                this.status = status;
            }
        }
    }
}

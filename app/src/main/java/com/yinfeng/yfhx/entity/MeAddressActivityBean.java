package com.yinfeng.yfhx.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity
 * 类  名：MeAddressActivityBean
 * 创建人：liuguodong
 * 创建时间：2019/10/14 14:38
 * ============================================
 **/
public class MeAddressActivityBean {

    /**
     * status : success
     * data : [{"id":3469,"name":"刘国栋","mobile":"17600065050","email":"","country":1,"province":370000,"city":370100,"district":370102,"country_name":"","province_name":"山东省","city_name":"济南市","district_name":"历下区","street_name":"","address":"东荷苑13号楼2单元902","sign_building":"","best_time":"","tag":"","default":0,"is_checked":1}]
     * time : 1571035147
     * timestamp : 1.571035147984342E9
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
         * id : 3469
         * name : 刘国栋
         * mobile : 17600065050
         * email :
         * country : 1
         * province : 370000
         * city : 370100
         * district : 370102
         * country_name :
         * province_name : 山东省
         * city_name : 济南市
         * district_name : 历下区
         * street_name :
         * address : 东荷苑13号楼2单元902
         * sign_building :
         * best_time :
         * tag :
         * default : 0
         * is_checked : 1
         */

        private int id;
        private String name;
        private String mobile;
        private String email;
        private int country;
        private int province;
        private int city;
        private int district;
        private String country_name;
        private String province_name;
        private String city_name;
        private String district_name;
        private String street_name;
        private String address;
        private String sign_building;
        private String best_time;
        private String tag;
        @SerializedName("default")
        private int defaultX;
        private int is_checked;

        private boolean selected_single;

        public boolean isSelected_single() {
            return selected_single;
        }

        public void setSelected_single(boolean selected_single) {
            this.selected_single = selected_single;
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

        public String getCountry_name() {
            return country_name;
        }

        public void setCountry_name(String country_name) {
            this.country_name = country_name;
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

        public String getStreet_name() {
            return street_name;
        }

        public void setStreet_name(String street_name) {
            this.street_name = street_name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public int getDefaultX() {
            return defaultX;
        }

        public void setDefaultX(int defaultX) {
            this.defaultX = defaultX;
        }

        public int getIs_checked() {
            return is_checked;
        }

        public void setIs_checked(int is_checked) {
            this.is_checked = is_checked;
        }
    }
}

package com.yinfeng.yfhx.entity;

import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity
 * 类  名：MeInvoiceActivityBean
 * 创建人：liuguodong
 * 创建时间：2019/10/12 10:53
 * ============================================
 **/
public class MeInvoiceActivityBean {

    /**
     * status : success
     * data : [{"id":407,"user_id":51620,"company_name":"大叔大婶多","company_address":"大叔大婶多","tax_id":"adsasdasd","company_telephone":"大叔大婶多","bank_of_deposit":"中国银行","bank_account":"6228481832925241619","consignee_name":"d","consignee_mobile_phone":"大萨达多撒多","consignee_address":"敖德萨多阿达","audit_status":1,"add_time":1570819953,"country":1,"province":110000,"city":659009502,"district":110101,"inv_type":1,"region":"北京市 北京市 东城区"}]
     * time : 1570848760
     * timestamp : 1.570848760248125E9
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
         * id : 407
         * user_id : 51620
         * company_name : 大叔大婶多
         * company_address : 大叔大婶多
         * tax_id : adsasdasd
         * company_telephone : 大叔大婶多
         * bank_of_deposit : 中国银行
         * bank_account : 6228481832925241619
         * consignee_name : d
         * consignee_mobile_phone : 大萨达多撒多
         * consignee_address : 敖德萨多阿达
         * audit_status : 1
         * add_time : 1570819953
         * country : 1
         * province : 110000
         * city : 659009502
         * district : 110101
         * inv_type : 1
         * region : 北京市 北京市 东城区
         */

        private int id;
        private int user_id;
        private String company_name;
        private String company_address;
        private String tax_id;
        private String company_telephone;
        private String bank_of_deposit;
        private String bank_account;
        private String consignee_name;
        private String consignee_mobile_phone;
        private String consignee_address;
        private int audit_status;
        private int add_time;
        private int country;
        private int province;
        private int city;
        private int district;
        private int inv_type;
        private String region;
        private boolean selected;
        private boolean selected_single;

        public boolean isSelected_single() {
            return selected_single;
        }

        public void setSelected_single(boolean selected_single) {
            this.selected_single = selected_single;
        }

        public boolean isSeletced() {
            return selected;
        }

        public void setSeletced(boolean seletced) {
            this.selected = seletced;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getCompany_address() {
            return company_address;
        }

        public void setCompany_address(String company_address) {
            this.company_address = company_address;
        }

        public String getTax_id() {
            return tax_id;
        }

        public void setTax_id(String tax_id) {
            this.tax_id = tax_id;
        }

        public String getCompany_telephone() {
            return company_telephone;
        }

        public void setCompany_telephone(String company_telephone) {
            this.company_telephone = company_telephone;
        }

        public String getBank_of_deposit() {
            return bank_of_deposit;
        }

        public void setBank_of_deposit(String bank_of_deposit) {
            this.bank_of_deposit = bank_of_deposit;
        }

        public String getBank_account() {
            return bank_account;
        }

        public void setBank_account(String bank_account) {
            this.bank_account = bank_account;
        }

        public String getConsignee_name() {
            return consignee_name;
        }

        public void setConsignee_name(String consignee_name) {
            this.consignee_name = consignee_name;
        }

        public String getConsignee_mobile_phone() {
            return consignee_mobile_phone;
        }

        public void setConsignee_mobile_phone(String consignee_mobile_phone) {
            this.consignee_mobile_phone = consignee_mobile_phone;
        }

        public String getConsignee_address() {
            return consignee_address;
        }

        public void setConsignee_address(String consignee_address) {
            this.consignee_address = consignee_address;
        }

        public int getAudit_status() {
            return audit_status;
        }

        public void setAudit_status(int audit_status) {
            this.audit_status = audit_status;
        }

        public int getAdd_time() {
            return add_time;
        }

        public void setAdd_time(int add_time) {
            this.add_time = add_time;
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

        public int getInv_type() {
            return inv_type;
        }

        public void setInv_type(int inv_type) {
            this.inv_type = inv_type;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }
    }
}

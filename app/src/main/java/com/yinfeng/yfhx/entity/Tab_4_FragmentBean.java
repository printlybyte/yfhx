package com.yinfeng.yfhx.entity;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity
 * 类  名：Tab_4_FragmentBean
 * 创建人：liuguodong
 * 创建时间：2019/10/11 17:55
 * ============================================
 **/
public class Tab_4_FragmentBean {

    /**
     * status : success
     * data : {"id":22,"name":"Han婷","username":"15953139715","mobile":"15953139715","email":"","avatar":"http://thirdwx.qlogo.cn/mmopen/Q3auHgzwzM7WqMhcEtTks7lXW5KB9GbXLRRWibvCiaYh345ZuTM55Ty1iat8RAlZkjK3leYqQeEV8CY79U4hDl4H0fvFz5qlJNiap8sXwIhReEs/132","question":"","answer":"","sex":2,"birthday":"2000-01-01","user_money":"0.00","bonus":4,"coupons_num":0,"value_card_num":0,"frozen_money":"0.00","pay_points":0,"rank_points":0,"address_id":1252,"user_rank":"钻石会员","drp_parent_id":0,"parent_id":0,"qq":"","office_phone":"","telephone":"","is_validated":0,"credit_line":"0.00","pay_count":79,"team_num":0,"confirmed_count":1,"not_comment":5,"return_count":0,"emp":{"employee_id":232,"company_id":25,"department":"资金运营部","duty":"资金运营主管","employee_name":"韩婷婷","idcard":"370102198410203766","mobile":"15953139715","remark":"银丰地产集团有限公司","add_time":1533577104,"admin_id":151,"company_name":"银丰地产集团有限公司","taxno":"91370100728597305L","pid":22,"admin_mobile":"13626328878"},"wechat_nickname":"","unshippping":8,"use_value_card":"1","user_real":0,"user_real_info":false,"role":"员工","roles":"48","is_wechat_browser":0,"is_drp":1,"is_team":1,"is_bargain":1,"is_suppliers":0,"is_share":1,"invite_code":"1a5014e0ae117b1c12b28d0699966ee9"}
     * time : 1571294755
     * timestamp : 1.571294755327006E9
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
         * id : 22
         * name : Han婷
         * username : 15953139715
         * mobile : 15953139715
         * email :
         * avatar : http://thirdwx.qlogo.cn/mmopen/Q3auHgzwzM7WqMhcEtTks7lXW5KB9GbXLRRWibvCiaYh345ZuTM55Ty1iat8RAlZkjK3leYqQeEV8CY79U4hDl4H0fvFz5qlJNiap8sXwIhReEs/132
         * question :
         * answer :
         * sex : 2
         * birthday : 2000-01-01
         * user_money : 0.00
         * bonus : 4
         * coupons_num : 0
         * value_card_num : 0
         * frozen_money : 0.00
         * pay_points : 0
         * rank_points : 0
         * address_id : 1252
         * user_rank : 钻石会员
         * drp_parent_id : 0
         * parent_id : 0
         * qq :
         * office_phone :
         * telephone :
         * is_validated : 0
         * credit_line : 0.00
         * pay_count : 79
         * team_num : 0
         * confirmed_count : 1
         * not_comment : 5
         * return_count : 0
         * emp : {"employee_id":232,"company_id":25,"department":"资金运营部","duty":"资金运营主管","employee_name":"韩婷婷","idcard":"370102198410203766","mobile":"15953139715","remark":"银丰地产集团有限公司","add_time":1533577104,"admin_id":151,"company_name":"银丰地产集团有限公司","taxno":"91370100728597305L","pid":22,"admin_mobile":"13626328878"}
         * wechat_nickname :
         * unshippping : 8
         * use_value_card : 1
         * user_real : 0
         * user_real_info : false
         * role : 员工
         * roles : 48
         * is_wechat_browser : 0
         * is_drp : 1
         * is_team : 1
         * is_bargain : 1
         * is_suppliers : 0
         * is_share : 1
         * invite_code : 1a5014e0ae117b1c12b28d0699966ee9
         */

        private int id;
        private String name;
        private String username;
        private String mobile;
        private String email;
        private String avatar;
        private String question;
        private String answer;
        private int sex;
        private String birthday;
        private String user_money;
        private int bonus;
        private int coupons_num;
        private int value_card_num;
        private String frozen_money;
        private int pay_points;
        private int rank_points;
        private int address_id;
        private String user_rank;
        private int drp_parent_id;
        private int parent_id;
        private String qq;
        private String office_phone;
        private String telephone;
        private int is_validated;
        private String credit_line;
        private int pay_count;
        private int team_num;
        private int confirmed_count;
        private int not_comment;
        private int return_count;
        private EmpBean emp;
        private String wechat_nickname;
        private int unshippping;
        private String use_value_card;
        private int user_real;
        private boolean user_real_info;
        private String role;
        private String roles;
        private int is_wechat_browser;
        private int is_drp;
        private int is_team;
        private int is_bargain;
        private int is_suppliers;
        private int is_share;
        private String invite_code;

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

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
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

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getUser_money() {
            return user_money;
        }

        public void setUser_money(String user_money) {
            this.user_money = user_money;
        }

        public int getBonus() {
            return bonus;
        }

        public void setBonus(int bonus) {
            this.bonus = bonus;
        }

        public int getCoupons_num() {
            return coupons_num;
        }

        public void setCoupons_num(int coupons_num) {
            this.coupons_num = coupons_num;
        }

        public int getValue_card_num() {
            return value_card_num;
        }

        public void setValue_card_num(int value_card_num) {
            this.value_card_num = value_card_num;
        }

        public String getFrozen_money() {
            return frozen_money;
        }

        public void setFrozen_money(String frozen_money) {
            this.frozen_money = frozen_money;
        }

        public int getPay_points() {
            return pay_points;
        }

        public void setPay_points(int pay_points) {
            this.pay_points = pay_points;
        }

        public int getRank_points() {
            return rank_points;
        }

        public void setRank_points(int rank_points) {
            this.rank_points = rank_points;
        }

        public int getAddress_id() {
            return address_id;
        }

        public void setAddress_id(int address_id) {
            this.address_id = address_id;
        }

        public String getUser_rank() {
            return user_rank;
        }

        public void setUser_rank(String user_rank) {
            this.user_rank = user_rank;
        }

        public int getDrp_parent_id() {
            return drp_parent_id;
        }

        public void setDrp_parent_id(int drp_parent_id) {
            this.drp_parent_id = drp_parent_id;
        }

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getOffice_phone() {
            return office_phone;
        }

        public void setOffice_phone(String office_phone) {
            this.office_phone = office_phone;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public int getIs_validated() {
            return is_validated;
        }

        public void setIs_validated(int is_validated) {
            this.is_validated = is_validated;
        }

        public String getCredit_line() {
            return credit_line;
        }

        public void setCredit_line(String credit_line) {
            this.credit_line = credit_line;
        }

        public int getPay_count() {
            return pay_count;
        }

        public void setPay_count(int pay_count) {
            this.pay_count = pay_count;
        }

        public int getTeam_num() {
            return team_num;
        }

        public void setTeam_num(int team_num) {
            this.team_num = team_num;
        }

        public int getConfirmed_count() {
            return confirmed_count;
        }

        public void setConfirmed_count(int confirmed_count) {
            this.confirmed_count = confirmed_count;
        }

        public int getNot_comment() {
            return not_comment;
        }

        public void setNot_comment(int not_comment) {
            this.not_comment = not_comment;
        }

        public int getReturn_count() {
            return return_count;
        }

        public void setReturn_count(int return_count) {
            this.return_count = return_count;
        }

        public EmpBean getEmp() {
            return emp;
        }

        public void setEmp(EmpBean emp) {
            this.emp = emp;
        }

        public String getWechat_nickname() {
            return wechat_nickname;
        }

        public void setWechat_nickname(String wechat_nickname) {
            this.wechat_nickname = wechat_nickname;
        }

        public int getUnshippping() {
            return unshippping;
        }

        public void setUnshippping(int unshippping) {
            this.unshippping = unshippping;
        }

        public String getUse_value_card() {
            return use_value_card;
        }

        public void setUse_value_card(String use_value_card) {
            this.use_value_card = use_value_card;
        }

        public int getUser_real() {
            return user_real;
        }

        public void setUser_real(int user_real) {
            this.user_real = user_real;
        }

        public boolean isUser_real_info() {
            return user_real_info;
        }

        public void setUser_real_info(boolean user_real_info) {
            this.user_real_info = user_real_info;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getRoles() {
            return roles;
        }

        public void setRoles(String roles) {
            this.roles = roles;
        }

        public int getIs_wechat_browser() {
            return is_wechat_browser;
        }

        public void setIs_wechat_browser(int is_wechat_browser) {
            this.is_wechat_browser = is_wechat_browser;
        }

        public int getIs_drp() {
            return is_drp;
        }

        public void setIs_drp(int is_drp) {
            this.is_drp = is_drp;
        }

        public int getIs_team() {
            return is_team;
        }

        public void setIs_team(int is_team) {
            this.is_team = is_team;
        }

        public int getIs_bargain() {
            return is_bargain;
        }

        public void setIs_bargain(int is_bargain) {
            this.is_bargain = is_bargain;
        }

        public int getIs_suppliers() {
            return is_suppliers;
        }

        public void setIs_suppliers(int is_suppliers) {
            this.is_suppliers = is_suppliers;
        }

        public int getIs_share() {
            return is_share;
        }

        public void setIs_share(int is_share) {
            this.is_share = is_share;
        }

        public String getInvite_code() {
            return invite_code;
        }

        public void setInvite_code(String invite_code) {
            this.invite_code = invite_code;
        }

        public static class EmpBean {
            /**
             * employee_id : 232
             * company_id : 25
             * department : 资金运营部
             * duty : 资金运营主管
             * employee_name : 韩婷婷
             * idcard : 370102198410203766
             * mobile : 15953139715
             * remark : 银丰地产集团有限公司
             * add_time : 1533577104
             * admin_id : 151
             * company_name : 银丰地产集团有限公司
             * taxno : 91370100728597305L
             * pid : 22
             * admin_mobile : 13626328878
             */

            private int employee_id;
            private int company_id;
            private String department;
            private String duty;
            private String employee_name;
            private String idcard;
            private String mobile;
            private String remark;
            private int add_time;
            private int admin_id;
            private String company_name;
            private String taxno;
            private int pid;
            private String admin_mobile;

            public int getEmployee_id() {
                return employee_id;
            }

            public void setEmployee_id(int employee_id) {
                this.employee_id = employee_id;
            }

            public int getCompany_id() {
                return company_id;
            }

            public void setCompany_id(int company_id) {
                this.company_id = company_id;
            }

            public String getDepartment() {
                return department;
            }

            public void setDepartment(String department) {
                this.department = department;
            }

            public String getDuty() {
                return duty;
            }

            public void setDuty(String duty) {
                this.duty = duty;
            }

            public String getEmployee_name() {
                return employee_name;
            }

            public void setEmployee_name(String employee_name) {
                this.employee_name = employee_name;
            }

            public String getIdcard() {
                return idcard;
            }

            public void setIdcard(String idcard) {
                this.idcard = idcard;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public int getAdd_time() {
                return add_time;
            }

            public void setAdd_time(int add_time) {
                this.add_time = add_time;
            }

            public int getAdmin_id() {
                return admin_id;
            }

            public void setAdmin_id(int admin_id) {
                this.admin_id = admin_id;
            }

            public String getCompany_name() {
                return company_name;
            }

            public void setCompany_name(String company_name) {
                this.company_name = company_name;
            }

            public String getTaxno() {
                return taxno;
            }

            public void setTaxno(String taxno) {
                this.taxno = taxno;
            }

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public String getAdmin_mobile() {
                return admin_mobile;
            }

            public void setAdmin_mobile(String admin_mobile) {
                this.admin_mobile = admin_mobile;
            }
        }
    }
}

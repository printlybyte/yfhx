package com.yinfeng.yfhx.entity.t3;

import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity.t3
 * 类  名：ChangeValueArrBean
 * 创建人：liuguodong
 * 创建时间：2019/11/5 18:23
 * ============================================
 **/
public class ChangeValueArrBean {

    /**
     * status : success
     * data : {"change_num":4,"checked_rec_id":[]}
     * time : 1572948710
     * timestamp : 1.572948710069574E9
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
         * change_num : 4
         * checked_rec_id : []
         */

        private int change_num;
        private List<Integer> checked_rec_id;

        public int getChange_num() {
            return change_num;
        }

        public void setChange_num(int change_num) {
            this.change_num = change_num;
        }

        public List<Integer> getChecked_rec_id() {
            return checked_rec_id;
        }

        public void setChecked_rec_id(List<Integer> checked_rec_id) {
            this.checked_rec_id = checked_rec_id;
        }
    }
}

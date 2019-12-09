package com.yinfeng.yfhx.entity.login;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity.login
 * 类  名：LoginBean
 * 创建人：liuguodong
 * 创建时间：2019/10/30 14:59
 * ============================================
 **/
public class LoginBean {

    /**
     * status : success
     * data : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJPbmxpbmUgSldUIEJ1aWxkZXIiLCJhdWQiOiJodHRwczpcL1wvd3d3LmRzY21hbGwuY24iLCJzdWIiOiJqcm9ja2V0QGV4YW1wbGUuY29tIiwiZXhwIjoxNTc1MDEwODE2LCJ1c2VyX2lkIjo1MTYyMH0.M9aO99ek8-Lk2HCz7guzNDD7q6mlfpJ8CR0OcBk8qJ4
     * time : 1572418816
     * timestamp : 1.572418816675992E9
     */

    private String status;
    private String data;
    private int time;
    private double timestamp;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
}

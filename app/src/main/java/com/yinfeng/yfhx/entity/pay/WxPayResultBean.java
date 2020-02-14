package com.yinfeng.yfhx.entity.pay;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity.pay
 * 类  名：WxPayResultBean
 * 创建人：liuguodong
 * 创建时间：2020/1/2 15:10
 * ============================================
 **/
public class WxPayResultBean {

    /**
     * status : success
     * data : {"appid":"","partnerid":"1480109062","prepayid":null,"package":"Sign=WXPay","noncestr":"409fc8ec6594cb430d19f088c48163d2","timestamp":1574740505,"sign":"2928BC6DF0372E90149397F89B5A23C7"}
     * time : 1574740505
     * timestamp : 1.574740505188579E9
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

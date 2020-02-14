package com.yinfeng.yfhx.entity.common;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity
 * 类  名：CommonStatusSuccessBean
 * 创建人：liuguodong
 * 创建时间：2019/10/12 17:46
 * ============================================
 **/
public class CommonStatusDateorTureBean {

    /**
     * status : success
     * data : true
     * time : 1577071928
     * timestamp : 1.577071928537878E9
     */

    private String status;
    private boolean data;
    private int time;
    private double timestamp;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
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

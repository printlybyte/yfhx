package com.yinfeng.yfhx.entity.utils;

import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity.utils
 * 类  名：UploadImgSuessBean
 * 创建人：liuguodong
 * 创建时间：2019/12/20 11:43
 * ============================================
 **/
public class UploadImgSuessBean {

    /**
     * status : success
     * data : ["http://yinfenghui.oss-cn-beijing.aliyuncs.com/uploads/50050_5dfc4320ed282.png"]
     * time : 1576813345
     * timestamp : 1.576813345100418E9
     */

    private String status;
    private int time;
    private double timestamp;
    private List<String> data;

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

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}

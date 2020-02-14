package com.yinfeng.yfhx.entity.pay;

import com.google.gson.annotations.SerializedName;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity.pay
 * 类  名：WxPayDateBean
 * 创建人：liuguodong
 * 创建时间：2020/1/2 15:15
 * ============================================
 **/
public class WxPayDateBean {

    /**
     * appid : wx280b4
     * partnerid : 1480109
     * prepayid : wx021523407ac56ff3a1830173300
     * package : Sign=WXPay
     * noncestr : 644c522677c052e433c842a04cc34762
     * timestamp : 1577949804
     * sign : 393076EC2F62014A6BDD5673CEFD5753
     */

    private String appid;
    private String partnerid;
    private String prepayid;
    @SerializedName("package")
    private String packageX;
    private String noncestr;
    private int timestamp;
    private String sign;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getPrepayid() {
        return prepayid;
    }

    public void setPrepayid(String prepayid) {
        this.prepayid = prepayid;
    }

    public String getPackageX() {
        return packageX;
    }

    public void setPackageX(String packageX) {
        this.packageX = packageX;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}

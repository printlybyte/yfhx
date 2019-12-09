package com.yinfeng.yfhx.entity.child;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity.child
 * 类  名：ChildInvoiceBean
 * 创建人：liuguodong
 * 创建时间：2019/12/9 11:31
 * ============================================
 **/
public   class ChildInvoiceBean {
    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getInv_id() {
        return inv_id;
    }

    public void setInv_id(String inv_id) {
        this.inv_id = inv_id;
    }

    public String getInv_type() {
        return inv_type;
    }

    public void setInv_type(String inv_type) {
        this.inv_type = inv_type;
    }

    public String getInv_payee() {
        return inv_payee;
    }

    public void setInv_payee(String inv_payee) {
        this.inv_payee = inv_payee;
    }

    public String getTax_id() {
        return tax_id;
    }

    public void setTax_id(String tax_id) {
        this.tax_id = tax_id;
    }

    public String getInv_content() {
        return inv_content;
    }

    public void setInv_content(String inv_content) {
        this.inv_content = inv_content;
    }

    public String getNeed_inv() {
        return need_inv;
    }

    public void setNeed_inv(String need_inv) {
        this.need_inv = need_inv;
    }

    String invoice="0";
    String inv_id="0";
    String inv_type="0";
    String inv_payee="0";
    String tax_id="0";
    String inv_content="不开发票";
    String need_inv="0";


}
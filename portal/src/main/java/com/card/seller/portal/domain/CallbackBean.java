package com.card.seller.portal.domain;

public class CallbackBean {

    private String merid;
    private String orderno;
    private String amount;
    private String currencycode;
    private String transdate;
    private String transtype;
    private String status;
    private String checkvalue;
    private String clientIP;


    public String getMerid() {
        return merid;
    }

    public void setMerid(String merid) {
        this.merid = merid;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
    }

    public String getTransdate() {
        return transdate;
    }

    public void setTransdate(String transdate) {
        this.transdate = transdate;
    }

    public String getTranstype() {
        return transtype;
    }

    public void setTranstype(String transtype) {
        this.transtype = transtype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCheckvalue() {
        return checkvalue;
    }

    public void setCheckvalue(String checkvalue) {
        this.checkvalue = checkvalue;
    }

    public String getClientIP() {
        return clientIP;
    }

    public void setClientIP(String clientIP) {
        this.clientIP = clientIP;
    }

    public String toString() {
          String payStatus = "";
        if("1001".equals(status)){
            payStatus = "成功";
        } else if("1004".equals(status)){
            payStatus = "失败";
        }
        return "支付成功: 商号：" + merid + ", 订单号：" + orderno + ", 金额：" + amount + "币种：" + currencycode + ", 支付日期：" + transdate + ", 支付类型：" + transtype + ", 支付状态:" + payStatus + "ip地址:" + clientIP ;
    }
}

package com.card.seller.domain;

/**
 * Created by minjie
 * Date:14-12-31
 * Time:下午2:15
 */
public class HCZFPaymentBean {

    private String merNo;

    private String billNo;

    private String amount;

    private String returnURL;

    private String adviceURL;

    private String paymentURL;

    private String signInfo;

    private String orderTime;

    public String getMerNo() {
        return merNo;
    }

    public void setMerNo(String merNo) {
        this.merNo = merNo;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReturnURL() {
        return returnURL;
    }

    public void setReturnURL(String returnURL) {
        this.returnURL = returnURL;
    }

    public String getAdviceURL() {
        return adviceURL;
    }

    public void setAdviceURL(String adviceURL) {
        this.adviceURL = adviceURL;
    }

    public String getSignInfo() {
        return signInfo;
    }

    public void setSignInfo(String signInfo) {
        this.signInfo = signInfo;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getPaymentURL() {
        return paymentURL;
    }

    public void setPaymentURL(String paymentURL) {
        this.paymentURL = paymentURL;
    }

    public String toString() {
        return "支付前: 商号：" + merNo + ", 订单号：" + billNo + ", 金额：" + amount + ", 支付日期：" + orderTime + ", 支付类型：";
    }
}

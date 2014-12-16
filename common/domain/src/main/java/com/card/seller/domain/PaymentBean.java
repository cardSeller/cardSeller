package com.card.seller.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentBean {

    private String MerId;
    private String OrdId;
    private String TransAmt;
    private String CuryId;
    private String TransDate;
    private String TransType;
    private String Version;
    private String BgRetUrl;
    private String PageRetUrl;
    private String GateId;
    private String Status;
    private String Priv1;
    private String ClientIP;
    private String ChkValue;

    private String TransTime;
    private String CountryId;
    private String TimeZone;
    private String DSTFlag;
    private String ExtFlag;
    private String Priv2;

    private String PaymentUrl;


    public PaymentBean() {

    }

    public String getMerId() {
        return MerId;
    }

    public void setMerId(String merId) {
        MerId = merId;
    }

    public String getOrdId() {
        return OrdId;
    }

    public void setOrdId(String ordId) {
        OrdId = ordId;
    }

    public String getTransAmt() {
        return TransAmt;
    }

    public void setTransAmt(String transAmt) {
        TransAmt = transAmt;
    }

    public String getCuryId() {
        return CuryId;
    }

    public void setCuryId(String curyId) {
        CuryId = curyId;
    }

    public String getTransDate() {
        if(TransDate==null || "".equals(TransDate)){
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
            return sf.format(new Date());
        }
        return TransDate;
    }

    public void setTransDate(String transDate) {
        TransDate = transDate;
    }

    public String getTransType() {
        return TransType;
    }

    public void setTransType(String transType) {
        TransType = transType;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getBgRetUrl() {
        return BgRetUrl;
    }

    public void setBgRetUrl(String bgRetUrl) {
        BgRetUrl = bgRetUrl;
    }

    public String getPageRetUrl() {
        return PageRetUrl;
    }

    public void setPageRetUrl(String pageRetUrl) {
        PageRetUrl = pageRetUrl;
    }

    public String getGateId() {
        return GateId;
    }

    public void setGateId(String gateId) {
        GateId = gateId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getPriv1() {
        return Priv1;
    }

    public void setPriv1(String priv1) {
        Priv1 = priv1;
    }

    public String getPriv2() {
        return Priv2;
    }

    public void setPriv2(String priv2) {
        Priv2 = priv2;
    }

    public String getClientIP() {
        return ClientIP;
    }

    public void setClientIP(String clientIP) {
        ClientIP = clientIP;
    }

    public String getChkValue() {
        return ChkValue;
    }

    public void setChkValue(String chkValue) {
        ChkValue = chkValue;
    }

    public String getTransTime() {
        return TransTime;
    }

    public void setTransTime(String transTime) {
        TransTime = transTime;
    }

    public String getCountryId() {
        return CountryId;
    }

    public void setCountryId(String countryId) {
        CountryId = countryId;
    }

    public String getTimeZone() {
        return TimeZone;
    }

    public void setTimeZone(String timeZone) {
        TimeZone = timeZone;
    }

    public String getDSTFlag() {
        return DSTFlag;
    }

    public void setDSTFlag(String dSTFlag) {
        DSTFlag = dSTFlag;
    }

    public String getExtFlag() {
        return ExtFlag;
    }

    public void setExtFlag(String extFlag) {
        ExtFlag = extFlag;
    }

    public String getPaymentUrl() {
        return PaymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        PaymentUrl = paymentUrl;
    }

    public String toString() {
        return "支付前: 商号：" + MerId + ", 订单号：" + OrdId + ", 金额：" + TransAmt + "币种：" + CuryId + ", 支付日期：" + TransDate + ", 支付类型：" + TransType + ", 客户端ip:" + ClientIP;
    }

    public static void main(String[] args) {
        BigDecimal total = new BigDecimal("3322");
        double price = Double.parseDouble(total.toString());
        String strPrice = String.valueOf(price * 100).split("\\.")[0];
        int length = 12 - strPrice.length();
        StringBuffer bf = new StringBuffer();
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                bf.append(0);
            }
            bf.append(strPrice);
        }
        System.out.println(bf.toString());
    }
}

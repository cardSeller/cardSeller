package com.card.seller.portal.domain;

import java.math.BigDecimal;

/**
 * Created by minjie
 * Date:14-12-31
 * Time:下午2:51
 */
public class HCZFCallbackBean {

    private String BillNo;

    private BigDecimal Amount;

    private String Succeed;

    private String Result;

    private String SignMD5info;

    public String getBillNo() {
        return BillNo;
    }

    public void setBillNo(String billNo) {
        BillNo = billNo;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }

    public String getSucceed() {
        return Succeed;
    }

    public void setSucceed(String succeed) {
        Succeed = succeed;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getSignMD5info() {
        return SignMD5info;
    }

    public void setSignMD5info(String signMD5info) {
        SignMD5info = signMD5info;
    }

    public String toString() {
        String payStatus;
        if("88".equals(Succeed)){
            payStatus = "成功";
        } else {
            payStatus = "失败";
        }
        return "支付成功: 订单号：" + BillNo + ", 金额：" + Amount + ", 订单详情:" + Result + ", 支付状态:" + payStatus;
    }
}

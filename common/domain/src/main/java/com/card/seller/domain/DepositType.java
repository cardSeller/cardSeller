package com.card.seller.domain;

/**
 * Created by minjie
 * Date:15-1-2
 * Time:下午2:11
 */
public enum DepositType {

    CHINAPAY("CHINAPAY", "银联", "CHINAPAY"),
    HCZF("HCZF", "汇潮支付", "HCZF");

    private String englishDescription;
    private String chineseDescription;
    private String payType;

    DepositType(String englishDescription, String chineseDescription, String payType) {
        this.englishDescription = englishDescription;
        this.chineseDescription = chineseDescription;
        this.payType = payType;
    }

    public String getChineseDescription() {
        return chineseDescription;
    }

    public String getPayType() {
        return payType;
    }

    public static DepositType getDepositTypeByPayType(String payType) {
        DepositType[] values = DepositType.values();
        for (DepositType value : values) {
            if(value.getPayType().equalsIgnoreCase(payType)) {
                return value;
            }
        }
        return null;
    }
}

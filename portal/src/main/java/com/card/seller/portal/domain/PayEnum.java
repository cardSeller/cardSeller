package com.card.seller.portal.domain;

/**
 * Created by minjie
 * Date:14-12-14
 * Time:下午3:29
 */
public enum PayEnum {

    CHINAPAY("CHINAPAY", "银联", "CHINAPAY", new PayContext(new ChinaPayProcess())),
    HCZF("HCZF", "汇潮支付", "HCZF", new PayContext(new HCZFProcess()));

    private String payType;
    private String chineseDescription;
    private String englishDescription;
    private PayContext payContext;

    private PayEnum(String payType, String chineseDescription, String englishDescription, PayContext payContext) {
        this.payType = payType;
        this.chineseDescription = chineseDescription;
        this.englishDescription = englishDescription;
        this.payContext = payContext;
    }

    public String getPayType() {
        return payType;
    }

    public String getChineseDescription() {
        return chineseDescription;
    }

    public String getEnglishDescription() {
        return englishDescription;
    }

    public PayContext getPayContext() {
        return payContext;
    }

    public static PayEnum getPayEnumByPayType(String payType) {
        PayEnum[] values = PayEnum.values();
        for (PayEnum value : values) {
            if(value.getPayType().equalsIgnoreCase(payType)) {
                return value;
            }
        }
        return null;
    }
}

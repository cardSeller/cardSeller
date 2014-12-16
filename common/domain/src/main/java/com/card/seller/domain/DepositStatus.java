package com.card.seller.domain;

/**
 * Created by minjie
 * Date:14-12-15
 * Time:下午3:57
 */
public enum DepositStatus {
    NP("待付款", "non-payment"),
    DS("充值成功", "deposit success");


    private String chineseDescription;

    private String englishDescription;

    private DepositStatus(String chineseDescription, String englishDescription) {
        this.chineseDescription = chineseDescription;
        this.englishDescription = englishDescription;
    }

    public String getChineseDescription() {
        return chineseDescription;
    }
}

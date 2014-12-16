package com.card.seller.domain;

/**
 * Created by lumine on 14-3-25.
 */
public enum OrderStatus {

    NP("待付款", "non-payment"),
    HP("已付款", "has-payment"),
    TS("交易完成", "trade success"),
    TC("交易关闭", "trade closed");


    private String chineseDescription;

    private String englishDescription;

    private OrderStatus(String chineseDescription, String englishDescription) {
        this.chineseDescription = chineseDescription;
        this.englishDescription = englishDescription;
    }

    public String getChineseDescription() {
        return chineseDescription;
    }

}

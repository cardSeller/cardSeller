package com.card.seller.backoffice.domain;

import java.util.Date;

/**
 * Created by minjie
 * Date:14-12-21
 * Time:下午6:20
 */
public class SearchOrderRequest {

    private Date orderTimeFrom;

    private Date orderTimeTo;

    private String memberName;

    private int pageIndex = 1;

    private int pageSize = 20;

    public Date getOrderTimeFrom() {
        return orderTimeFrom;
    }

    public void setOrderTimeFrom(Date orderTimeFrom) {
        this.orderTimeFrom = orderTimeFrom;
    }

    public Date getOrderTimeTo() {
        return orderTimeTo;
    }

    public void setOrderTimeTo(Date orderTimeTo) {
        this.orderTimeTo = orderTimeTo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}

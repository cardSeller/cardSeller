package com.card.seller.portal.domain;

import java.util.Date;

/**
 * Created by minjie
 * Date:14-12-28
 * Time:上午10:58
 */
public class SearchPortalOrderRequest {


    private Date orderTimeFrom;

    private Date orderTimeTo;

    private Long memberId;

    private int pageIndex = 1;

    private int pageSize = 2;

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

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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

package com.card.seller.portal.domain;

import java.util.Date;

/**
 * Created by minjie
 * Date:14-12-28
 * Time:下午9:50
 */
public class SearchPortalDepositRequest {

    private Date depositTimeFrom;

    private Date depositTimeTo;

    private Long memberId;

    private int pageIndex = 1;

    private int pageSize = 2;

    public Date getDepositTimeFrom() {
        return depositTimeFrom;
    }

    public void setDepositTimeFrom(Date depositTimeFrom) {
        this.depositTimeFrom = depositTimeFrom;
    }

    public Date getDepositTimeTo() {
        return depositTimeTo;
    }

    public void setDepositTimeTo(Date depositTimeTo) {
        this.depositTimeTo = depositTimeTo;
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

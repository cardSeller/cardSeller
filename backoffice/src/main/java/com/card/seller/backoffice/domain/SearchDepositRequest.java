package com.card.seller.backoffice.domain;

import java.util.Date;

/**
 * Created by minjie
 * Date:14-12-21
 * Time:下午6:20
 */
public class SearchDepositRequest {

    private Date depositTimeFrom;

    private Date depositTimeTo;

    private String memberName;

    private int pageIndex = 1;

    private int pageSize = 8;

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

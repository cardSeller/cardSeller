package com.card.seller.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by minjie
 * Date:14-12-28
 * Time:下午9:57
 */
public class DepositManageSearch {

    private Long id;

    private Long memberId;

    private BigDecimal total;

    private Date depositDate;

    private String depositStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }

    public String getDepositStatus() {
        return DepositStatus.valueOf(depositStatus).getChineseDescription();
    }

    public void setDepositStatus(String depositStatus) {
        this.depositStatus = depositStatus;
    }
}

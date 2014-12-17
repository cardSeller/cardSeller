package com.card.seller.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by minjie
 * Date:14-12-15
 * Time:下午3:18
 */
@Entity(name = "deposit")
@SequenceGenerator(name = "seq_gen", sequenceName = "seq_deposit", allocationSize = 1)
public class Deposit extends IdEntity {

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "total", nullable = false, precision = 12, scale = 3)
    private BigDecimal total;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deposit_date", length = 30, nullable = false)
    private Date depositDate;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "deposit_status", length = 10, nullable = false)
    private DepositStatus depositStatus;

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

    public DepositStatus getDepositStatus() {
        return depositStatus;
    }

    public void setDepositStatus(DepositStatus depositStatus) {
        this.depositStatus = depositStatus;
    }
}

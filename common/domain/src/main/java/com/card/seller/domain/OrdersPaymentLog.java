package com.card.seller.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "order_payment_log")
@SequenceGenerator(name = "seq_gen", sequenceName = "seq_order_payment_log", allocationSize = 1)
public class OrdersPaymentLog extends IdEntity  {

    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "context")
    private String context;

    @Column(name = "log_date", nullable = false)
    private Date logDate;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }
}

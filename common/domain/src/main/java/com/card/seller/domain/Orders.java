package com.card.seller.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by minjie
 * Date:14-12-13
 * Time:下午4:03
 */
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @Column(name = "order_number", length = 30, nullable = false)
    private String orderNumber;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "item_price_id")
    private Long itemPriceId;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "total", nullable = false, precision = 12, scale = 3)
    private BigDecimal total;

    @Column(name = "item_count")
    private Integer itemCount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date", length = 30, nullable = false)
    private Date orderDate;

    @Transient
    private Member member;

    @Transient
    private Item item;

    @Transient
    private ItemPrice itemPrice;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "order_status", length = 10, nullable = false)
    private OrderStatus orderStatus;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getItemPriceId() {
        return itemPriceId;
    }

    public void setItemPriceId(Long itemPriceId) {
        this.itemPriceId = itemPriceId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Enumerated(value = EnumType.STRING)
    @Column(name = "order_status", length = 10, nullable = false)
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Transient
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Transient
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Transient
    public ItemPrice getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(ItemPrice itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}

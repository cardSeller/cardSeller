package com.card.seller.domain;

import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by minjie
 * Date:14-12-21
 * Time:下午10:18
 */
public class OrdersManageSearch {

    private String orderNumber;

    private Long memberId;

    private Long itemPriceId;

    private Long itemId;

    private BigDecimal total;

    private Integer itemCount;

    private Date orderDate;

    private String orderStatus;

    private Member member;

    private ItemPrice itemPrice;

    private Item item;

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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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

    public String getOrderStatus() {
        return OrderStatus.valueOf(orderStatus).getChineseDescription();
    }

    public void setOrderStatus(String orderStatus) {
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
    public ItemPrice getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(ItemPrice itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Transient
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}

package com.card.seller.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;

/**
 * Created by minjie
 * Date:14-12-12
 * Time:下午9:31
 */
@Entity(name = "item_price")
@SequenceGenerator(name = "seq_gen", sequenceName = "seq_item_price", allocationSize = 1)
public class ItemPrice extends IdEntity {

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "face_value", nullable = false, precision = 12, scale = 3)
    private BigDecimal faceValue;

    @Column(name = "price", nullable = false, precision = 12, scale = 3)
    private BigDecimal price;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(BigDecimal faceValue) {
        this.faceValue = faceValue;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

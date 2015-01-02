package com.card.seller.domain;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * Created by minjie
 * Date:14-12-11
 * Time:下午5:02
 */
@Entity
@Table(name = "item")
@SequenceGenerator(name = "seq_gen", sequenceName = "seq_item", allocationSize = 1)
public class Item extends IdEntity {

    //商品名称
    private String name;
    //商品描述
    private String description;
    //商品图片
    private String imageUrl;
    //商品首字母
    private String initial;
    //商品面值和价格
    private List<ItemPrice> itemPriceList;
    //商品位置position为home的是在首页可为空
    private String position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    @Transient
    public List<ItemPrice> getItemPriceList() {
        return itemPriceList;
    }

    public void setItemPriceList(List<ItemPrice> itemPriceList) {
        this.itemPriceList = itemPriceList;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

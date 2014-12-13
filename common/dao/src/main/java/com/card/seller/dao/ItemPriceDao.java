package com.card.seller.dao;

import com.card.seller.dao.hibernate.HibernateSupportDao;
import com.card.seller.domain.ItemPrice;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by minjie
 * Date:14-12-12
 * Time:下午9:51
 */
@Repository
public class ItemPriceDao extends HibernateSupportDao<ItemPrice, Long> {

    public List<ItemPrice> getItemPriceListByItemId(Long itemId) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("itemId", itemId);
        return findByQuery("from " + ItemPrice.class.getName() + " where itemId=:itemId order by id asc", map);
    }
}

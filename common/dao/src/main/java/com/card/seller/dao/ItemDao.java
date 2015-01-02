package com.card.seller.dao;

import com.card.seller.dao.hibernate.HibernateSupportDao;
import com.card.seller.domain.Item;
import com.card.seller.domain.Member;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by minjie
 * Date:14-12-11
 * Time:下午5:33
 */
@Repository
public class ItemDao extends HibernateSupportDao<Item, Long> {
    public List<Item> getItemsByPosition(String position) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("position", position);
        return findByQuery("from " + Item.class.getName() + " where position=:position order by id", map);
    }

    public List<Item> getItemsByInitial(String begin, String end) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("begin", begin);
        map.put("end", end);
        return findByQuery("from " + Item.class.getName() + " where initial >=:begin and initial <=:end order by initial", map);
    }
}

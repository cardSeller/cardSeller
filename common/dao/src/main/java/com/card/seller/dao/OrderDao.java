package com.card.seller.dao;

import com.card.seller.dao.hibernate.HibernateSupportDao;
import com.card.seller.domain.OrderStatus;
import com.card.seller.domain.Orders;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by minjie
 * Date:14-12-13
 * Time:下午5:19
 */
@Repository
public class OrderDao extends HibernateSupportDao<Orders, String> {

    public List<Orders> getOrdersByMemberId(Long memberId) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("memberId", memberId);
        return findUniqueByQuery("from " + Orders.class.getName() + " where memberId=:memberId", map);
    }

}

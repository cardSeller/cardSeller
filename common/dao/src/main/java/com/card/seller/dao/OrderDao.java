package com.card.seller.dao;

import com.card.seller.dao.hibernate.HibernateSupportDao;
import com.card.seller.domain.OrderStatus;
import com.card.seller.domain.Orders;
import com.card.seller.domain.OrdersManageSearch;
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

    public List<OrdersManageSearch> getOrders(String queryString, Map<String, Object> params, int offset, int fetchSize) {
        StringBuilder builder = new StringBuilder();
        builder.append("select o.order_number as orderNumber,o.member_id as memberId,o.item_id as itemId,o,item_price_id as itemPriceId,o.total as total,o.item_count as itemCount,o.order_date as orderDate,o.order_status as orderStatus,null as member,null as item,null as itemPrice ");
        builder.append("from orders o ");
        builder.append("inner join member m on m.id=o.member_id ");
        builder.append("where 1=1 ");
        builder.append(queryString);
        builder.append(" order by o.order_date desc");
        return findBySQLQuery(builder.toString(), null, OrdersManageSearch.class, params, offset, fetchSize);
    }

    public Long getOrdersTotal(String queryString, Map<String, Object> params) {
        StringBuilder builder = new StringBuilder();
        builder.append("select o.order_number as orderNumber,o.member_id as memberId,o.item_id as itemId,o,item_price_id as itemPriceId,o.total as total,o.item_count as itemCount,o.order_date as orderDate,o.order_status as orderStatus,null as member,null as item,null as itemPrice ");
        builder.append("from orders o ");
        builder.append("inner join member m on m.id=o.member_id ");
        builder.append("where 1=1 ");
        builder.append(queryString);
        builder.append(" order by o.order_date desc");
        List<Orders> list = findBySQLQuery(builder.toString(), null, OrdersManageSearch.class, params);
        if (list == null) {
            return 0L;
        }
        return Long.valueOf(list.size());
    }
}

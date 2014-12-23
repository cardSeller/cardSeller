package com.card.seller.backoffice.service;

import com.card.seller.backoffice.domain.SearchOrderRequest;
import com.card.seller.dao.OrderDao;
import com.card.seller.domain.DateUtil;
import com.card.seller.domain.OrderStatus;
import com.card.seller.domain.Orders;
import com.card.seller.domain.OrdersManageSearch;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Map;

/**
 * Created by minjie
 * Date:14-12-14
 * Time:下午2:27
 */
@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Transactional
    public Orders getOrderById(String orderNumber) {
        return orderDao.get(orderNumber);
    }

    @Transactional
    public void updateOrderStatus(String orderNumber, OrderStatus orderStatus) {
        Orders orders = orderDao.get(orderNumber);
        orders.setOrderStatus(orderStatus);
        orderDao.update(orders);
    }

    @Transactional
    public void updateOrderStatus(Orders orders, OrderStatus orderStatus) {
        orders.setOrderStatus(orderStatus);
        orderDao.update(orders);
    }

    @Transactional
    public List<Orders> listAllOrders() {
        return orderDao.getAll();
    }

    @Transactional
    public List<OrdersManageSearch> getOrders(SearchOrderRequest request) {
        Map<String, Object> params = Maps.newHashMap();
        String query = queryString(request, params);
        return orderDao.getOrders(query, params, (request.getPageIndex() - 1) * request.getPageSize(), request.getPageSize());
    }

    @Transactional
    public Long getOrdersTotal(SearchOrderRequest request) {
        Map<String, Object> params = Maps.newHashMap();
        String query = queryString(request, params);
        return orderDao.getOrdersTotal(query, params);
    }

    private String queryString(SearchOrderRequest request, Map<String, Object> params) {
        StringBuilder builder = new StringBuilder();
        if (StringUtils.isNotBlank(request.getMemberName())) {
            builder.append(" AND UPPER(m.name) like :memberName");
            params.put("memberName", "%" + request.getMemberName().toUpperCase() + "%");
        }
        if (request.getOrderTimeFrom() != null) {
            builder.append(" AND o.order_date>=:orderTimeFrom");
            params.put("orderTimeFrom", DateUtil.withTimeAtStartOfDay(request.getOrderTimeFrom()));
        }
        if (request.getOrderTimeTo() != null) {
            builder.append(" AND o.order_date<=:orderTimeTo");
            params.put("orderTimeTo", DateUtil.withTimeAtEndOfDay(request.getOrderTimeTo()));
        }
        return builder.toString();

    }
}

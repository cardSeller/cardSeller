package com.card.seller.portal.service;

import com.card.seller.dao.OrderDao;
import com.card.seller.domain.DateUtil;
import com.card.seller.domain.Orders;
import com.card.seller.domain.OrdersManageSearch;
import com.card.seller.portal.domain.SearchPortalDepositRequest;
import com.card.seller.portal.domain.SearchPortalOrderRequest;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by minjie
 * Date:14-12-15
 * Time:下午3:04
 */
@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Transactional
    public List<OrdersManageSearch> getOrdersByMemberId(SearchPortalOrderRequest searchPortalOrderRequest) {
        Map<String, Object> params = Maps.newHashMap();
        String query = queryString(searchPortalOrderRequest, params);
        return orderDao.getOrders(query, params, (searchPortalOrderRequest.getPageIndex() - 1) * searchPortalOrderRequest.getPageSize(), searchPortalOrderRequest.getPageSize());
    }


    @Transactional
    public Long getOrdersTotal(SearchPortalOrderRequest request) {
        Map<String, Object> params = Maps.newHashMap();
        String query = queryString(request, params);
        return orderDao.getOrdersTotal(query, params);
    }


    private String queryString(SearchPortalOrderRequest request, Map<String, Object> params) {
        StringBuilder builder = new StringBuilder();
        if (request.getMemberId() != null) {
            builder.append(" AND m.id = :memberId");
            params.put("memberId", request.getMemberId());
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

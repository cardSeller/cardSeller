package com.card.seller.portal.service;

import com.card.seller.dao.OrderDao;
import com.card.seller.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<Orders> getOrdersByMemberId(Long memberId) {
        return orderDao.getOrdersByMemberId(memberId);
    }

}

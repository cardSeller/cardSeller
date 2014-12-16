package com.card.seller.backoffice.service;

import com.card.seller.dao.OrderDao;
import com.card.seller.domain.OrderStatus;
import com.card.seller.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public void updateOrderStatus(String orderNumber, OrderStatus orderStatus) {
        Orders orders = orderDao.get(orderNumber);
        orders.setOrderStatus(orderStatus);
        orderDao.update(orders);
    }

    @Transactional
    public List<Orders> listAllOrders() {
        return orderDao.getAll();
    }
}

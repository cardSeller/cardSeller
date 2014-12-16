package com.card.seller.portal.service;

import com.card.seller.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by minjie
 * Date:14-12-15
 * Time:下午3:04
 */
@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

}

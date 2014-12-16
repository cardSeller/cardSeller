package com.card.seller.dao;

import com.card.seller.dao.hibernate.HibernateSupportDao;
import com.card.seller.domain.OrdersPaymentLog;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Repository
public class OrdersPayMentLogDao extends HibernateSupportDao<OrdersPaymentLog, Long> {
    /**
     * 支付日志
     */
    @Transactional
    public void paymentLog(String orderId, String type, String context) {
        OrdersPaymentLog ordersPaymentLog = new OrdersPaymentLog();
        ordersPaymentLog.setOrderId(orderId);
        ordersPaymentLog.setType(type);
        ordersPaymentLog.setContext(context);
        ordersPaymentLog.setLogDate(new Date());
        save(ordersPaymentLog);
    }
}


package com.card.seller.portal.service;

import com.card.seller.dao.OrdersPayMentLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentLog {

    public final static String CHINAPAY = "1";
    public final static String ALIPAY = "2";

    @Autowired
    private OrdersPayMentLogDao ordersPayMentLogDao;

    /**
     * @param orderId 订单id
     * @param type    动作类型
     * @param context 日志详细信息
     */
    @Transactional
    public void log(String orderId, String type, String context) {
        ordersPayMentLogDao.paymentLog(orderId, type, context);
    }
}

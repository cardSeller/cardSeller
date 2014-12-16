package com.card.seller.portal.domain;

import com.card.seller.portal.service.PaymentLog;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * Created by minjie
 * Date:14-12-15
 * Time:下午9:38
 */
public class PayContext {

    private PayProcess payProcess;

    public PayContext(PayProcess payProcess) {
        this.payProcess = payProcess;
    }

    public String process(String orderNumber, BigDecimal total, HttpServletRequest request, PaymentLog paymentLog) {
        return payProcess.process(orderNumber, total, request, paymentLog);
    }
}

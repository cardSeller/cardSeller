package com.card.seller.portal.listener;

import com.card.seller.domain.PaymentUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by minjie
 * Date:14-12-16
 * Time:下午5:26
 */
public class PortalListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(PortalListener.class);

    public static final String PAYMENT_PROPERTIES = "payment.properties";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            LOGGER.info("init PaymentUtil start.");
            PaymentUtil.init(PAYMENT_PROPERTIES);
            LOGGER.info("init PaymentUtil end.");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

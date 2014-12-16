package com.card.seller.portal.domain;

import chinapay.PrivateKey;
import chinapay.SecureLink;
import com.card.seller.domain.PaymentBean;
import com.card.seller.domain.PaymentUtil;
import com.card.seller.portal.service.PaymentLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * Created by minjie
 * Date:14-12-15
 * Time:下午9:57
 */
public class ChinaPayProcess implements PayProcess {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChinaPayProcess.class);

    @Override
    public String process(String orderNumber, BigDecimal total, HttpServletRequest request, PaymentLog paymentLog) {
        PaymentBean paymentBean = new PaymentBean();
        paymentBean.setOrdId(orderNumber);
        double price = Double.parseDouble(total.toString());
        String strPrice = String.valueOf(price * 100).split("\\.")[0];
        int length = 12 - strPrice.length();
        StringBuffer bf = new StringBuffer();
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                bf.append(0);
            }
            bf.append(strPrice);
            paymentBean.setTransAmt(bf.toString());
        }
        paymentBean.setTransType("0001");
        paymentBean.setMerId(PaymentUtil.CHINAPAY_MERID);
        paymentBean.setCuryId(PaymentUtil.CHINAPAY_CURYID);
        paymentBean.setBgRetUrl(PaymentUtil.CHINAPAY_BGRETURL);
        paymentBean.setPageRetUrl(PaymentUtil.CHINAPAY_PAGERETURL);
        paymentBean.setVersion(PaymentUtil.CHINAPAY_VERSION);
        paymentBean.setPaymentUrl(PaymentUtil.CHINAPAY_PAYMENT_URL);
        paymentBean.setTransDate(paymentBean.getTransDate());
        String ClientIp; //获取客户ip.
        if (request.getHeader("X-Forwarded-For") == null) {
            ClientIp = request.getRemoteAddr();
        } else {
            ClientIp = request.getHeader("X-Forwarded-For");
        }
        boolean buildOK;
        int KeyUsage = 0;
        PrivateKey key = new PrivateKey();
        try {   //密钥验证
            buildOK = key.buildKey(paymentBean.getMerId(), KeyUsage, getClass().getResource(PaymentUtil.CHINAPAY_MERKEY_FILEPATH).getPath());
        } catch (Exception e) {
            LOGGER.error("PrivateKey build failure !", e);
            request.setAttribute("error", "PrivateKey build failure !");
            return "/chinapay.submit";
        }
        if (!buildOK) {
            LOGGER.error("buildKey failure key.buildKey return : " + buildOK);
            request.setAttribute("error", "buildKey failure !");
            return "/chinapay.submit";
        }
        String ChkValue;
        try {  //安全签名
            SecureLink sl = new SecureLink(key);
            if ("20070129".equalsIgnoreCase(PaymentUtil.CHINAPAY_VERSION)) {
                ChkValue = sl.Sign(paymentBean.getMerId() + paymentBean.getOrdId() + paymentBean.getTransAmt() + paymentBean.getCuryId() + paymentBean.getTransDate() + paymentBean.getTransType());
            } else if ("20100304".equalsIgnoreCase(PaymentUtil.CHINAPAY_VERSION)) {
                ChkValue = sl.Sign(paymentBean.getMerId() + paymentBean.getOrdId() + paymentBean.getTransAmt() + paymentBean.getCuryId() + paymentBean.getTransDate() + paymentBean.getTransType() + ClientIp);
            } else {
                ChkValue = sl.signOrder(paymentBean.getMerId(), paymentBean.getOrdId(), paymentBean.getTransAmt(), paymentBean.getCuryId(), paymentBean.getTransDate(), paymentBean.getTransType());
            }
        } catch (Exception e) {
            LOGGER.error("ChinaPay Sign failure !", e);
            request.setAttribute("error", "ChinaPay Sign failure !");
            return "/chinapay.submit";
        }
        paymentBean.setChkValue(ChkValue);
        paymentBean.setClientIP(ClientIp);
        request.setAttribute("paymentBean", paymentBean);
        paymentLog.log(paymentBean.getOrdId(), PaymentLog.CHINAPAY, paymentBean.toString());
        return "/chinapay.submit";
    }
}

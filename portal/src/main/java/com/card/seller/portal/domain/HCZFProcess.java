package com.card.seller.portal.domain;

import com.card.seller.domain.DateUtil;
import com.card.seller.domain.HCZFPaymentBean;
import com.card.seller.domain.HCZFPaymentUtil;
import com.card.seller.portal.service.PaymentLog;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by minjie
 * Date:14-12-31
 * Time:上午11:36
 */
public class HCZFProcess implements PayProcess {
    @Override
    public String process(String orderNumber, BigDecimal total, HttpServletRequest request, PaymentLog paymentLog) {
        HCZFPaymentBean hczfPaymentBean = new HCZFPaymentBean();
        hczfPaymentBean.setMerNo(HCZFPaymentUtil.HCZF_MERNO);
        hczfPaymentBean.setBillNo(orderNumber);
        hczfPaymentBean.setAmount(total.toString());
        hczfPaymentBean.setOrderTime(DateUtil.dateToString(DateUtil.YYYYMMDDHHMMSS, new Date()));
        hczfPaymentBean.setReturnURL(HCZFPaymentUtil.RETURN_URL);
        hczfPaymentBean.setAdviceURL(HCZFPaymentUtil.ADVICE_URL);
        hczfPaymentBean.setPaymentURL(HCZFPaymentUtil.PAYMENT_URL);
        String md5src;  //加密字符串
        md5src = HCZFPaymentUtil.HCZF_MERNO +"&"+ orderNumber +"&"+ total +"&"+ HCZFPaymentUtil.RETURN_URL +"&"+ HCZFPaymentUtil.MD5_KEY ;
        MD5 md5 = new MD5();
        String signInfo = md5.getMD5ofStr(md5src);//MD5检验结果
        hczfPaymentBean.setSignInfo(signInfo);
        request.setAttribute("hczfPaymentBean", hczfPaymentBean);
        return "/hczf.submit";
    }
}

package com.card.seller.portal.controller;

import chinapay.PrivateKey;
import chinapay.SecureLink;
import com.card.seller.domain.*;
import com.card.seller.portal.domain.CallbackBean;
import com.card.seller.portal.domain.HCZFCallbackBean;
import com.card.seller.portal.domain.MD5;
import com.card.seller.portal.domain.PayEnum;
import com.card.seller.portal.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by minjie
 * Date:14-12-14
 * Time:下午3:00
 */
@Controller
@RequestMapping("/payment")
public class PayController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private DepositService depositService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private GenerateService generateService;

    @Autowired
    private PaymentLog paymentLog;

    @RequestMapping(value = "toDeposit")
    public String toDeposit() {
        return "toDeposit";
    }

    @RequestMapping(value = "deposit", method = RequestMethod.POST)
    public String deposit(@RequestParam(value = "depositId", required = false) Long depositId, @RequestParam(value = "payType") String payType, @RequestParam(value = "total") BigDecimal total, HttpServletRequest request) {
        String memberName = SecurityContext.getAccount();
        Member member = memberService.getMemberByName(memberName);
        PayEnum payEnum = PayEnum.getPayEnumByPayType(payType);
        if(depositId == null) {
            Deposit deposit = new Deposit();
            deposit.setMemberId(member.getId());
            deposit.setTotal(total);
            deposit.setDepositDate(new Date());
            deposit.setDepositStatus(DepositStatus.NP);
            deposit.setDepositType(DepositType.getDepositTypeByPayType(payType));
            depositService.saveDeposit(deposit);
            return payEnum.getPayContext().process(deposit.getId().toString(), total, request, paymentLog);
        } else {
            return payEnum.getPayContext().process(depositId.toString(), total, request, paymentLog);
        }
    }

    /**
     * 银联应答回调
     */
    @ResponseBody
    @RequestMapping(value = "/getBgReturn", method = RequestMethod.POST)
    public void getBgReturn(HttpServletRequest req, @ModelAttribute CallbackBean callbackBean) {
        callbackBean.setClientIP(AnalyzeIpUtils.getIpAddr(req));
        boolean buildOK = false;
        boolean res = false;
        int KeyUsage = 0;
        PrivateKey key = new PrivateKey();
        try {
            buildOK = key.buildKey("999999999999999", KeyUsage, getClass().getResource(PaymentUtil.CHINAPAY_PUBKEY_FILEPATH).getPath());
        } catch (Exception e) {
            LOGGER.error("BuildKey failure !", e);
        }
        if (!buildOK) {
            return;
        }
        try {
            SecureLink sl = new SecureLink(key);
            LOGGER.info("chinapay getBgReturn | merId : {} | orderNo : {} | amount : {}", callbackBean.getMerid(), callbackBean.getOrderno(), callbackBean.getAmount());
            res = sl.verifyTransResponse(callbackBean.getMerid(), callbackBean.getOrderno(), callbackBean.getAmount(), callbackBean.getCurrencycode(), callbackBean.getTransdate(), callbackBean.getTranstype(), callbackBean.getStatus(), callbackBean.getCheckvalue());
        } catch (Exception e) {
            LOGGER.error("VerifyTransResponse failure !", e);
        }
        try {  //1001成功 //1004失败
            LOGGER.info("getBgReturn res : {}", res);
            if (res && "1001".equals(callbackBean.getStatus())) {
                depositService.depositVerify(callbackBean.getOrderno());
            } else {
                callbackBean.setStatus("1004");
            }
        } catch (Exception e) {
            callbackBean.setStatus("1004");
            LOGGER.info("VerifyTransResponse failure !", e);
        }
        paymentLog.log(callbackBean.getOrderno(), PaymentLog.CHINAPAY, callbackBean.toString());
    }

    /**
     * 汇潮支付应答回调
     */
    @ResponseBody
    @RequestMapping(value = "/hczfNotify", method = RequestMethod.POST)
    public String hczfNotify(HttpServletRequest req, @ModelAttribute HCZFCallbackBean hczfCallbackBean) {
        MD5 md5 = new MD5();
        String md5src = hczfCallbackBean.getBillNo()+"&"+hczfCallbackBean.getAmount()+"&"+hczfCallbackBean.getSucceed()+"&"+HCZFPaymentUtil.MD5_KEY;
        String md5sign; //MD5加密后的字符串
        md5sign = md5.getMD5ofStr(md5src);//MD5检验结果
        if(md5sign.equals(hczfCallbackBean.getSignMD5info())) {
            if("88".equals(hczfCallbackBean.getSucceed())) {
                depositService.depositVerify(hczfCallbackBean.getBillNo());
                paymentLog.log(hczfCallbackBean.getBillNo(), PaymentLog.HCZF, hczfCallbackBean.toString());
                return "ok";
            }
        } else {
            LOGGER.error("hczf md5 error the return signMD5info is {} and the md5Info we generate is {}", hczfCallbackBean.getSignMD5info(), md5sign);
        }
        return "fail";
    }

}

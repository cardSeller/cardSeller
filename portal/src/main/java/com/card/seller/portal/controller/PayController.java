package com.card.seller.portal.controller;

import com.card.seller.domain.*;
import com.card.seller.portal.domain.PayEnum;
import com.card.seller.portal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "deposit", method = RequestMethod.GET)
    public String deposit(@RequestParam(value = "payType") String payType, @RequestParam(value = "total") BigDecimal total, HttpServletRequest request) {
        String memberName = SecurityContext.getAccount();
        Member member = memberService.getMemberByName(memberName);
        Deposit deposit = new Deposit();
        deposit.setMemberId(member.getId());
        deposit.setTotal(total);
        deposit.setDepositDate(new Date());
        deposit.setDepositStatus(DepositStatus.NP);
        depositService.saveDeposit(deposit);
        PayEnum payEnum = PayEnum.getPayEnumByPayType(payType);
        return payEnum.getPayContext().process(deposit.getId().toString(), total, request, paymentLog);
    }

    @RequestMapping(value = "pay", method = RequestMethod.POST)
    public String pay(@RequestParam(value = "total") BigDecimal total) {
        return "paySuccess";
    }

}

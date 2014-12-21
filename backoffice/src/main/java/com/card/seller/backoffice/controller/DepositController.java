package com.card.seller.backoffice.controller;

import com.card.seller.backoffice.service.DepositService;
import com.card.seller.backoffice.service.MemberService;
import com.card.seller.domain.Deposit;
import com.card.seller.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by minjie
 * Date:14-12-18
 * Time:下午9:56
 */
@Controller
@RequestMapping("/deposit")
public class DepositController {

    @Autowired
    private DepositService depositService;

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/depositManager", method = RequestMethod.GET)
    public String memberManager(Map<String, Object> viewObject) {
        List<Deposit> deposits = depositService.getAllDeposits();
        for (Deposit deposit : deposits) {
            deposit.setMember(memberService.getMemberById(deposit.getMemberId()));
        }
        viewObject.put("deposits", deposits);
        viewObject.put("total", deposits.size());
        return "deposit/deposit.manager";
    }
}

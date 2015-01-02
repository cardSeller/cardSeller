package com.card.seller.backoffice.controller;

import com.card.seller.backoffice.domain.SearchDepositRequest;
import com.card.seller.backoffice.domain.SearchOrderRequest;
import com.card.seller.backoffice.service.DepositService;
import com.card.seller.backoffice.service.MemberService;
import com.card.seller.domain.DepositManageSearch;
import com.card.seller.domain.OrdersManageSearch;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String depositManager(Map<String, Object> viewObject) {
        SearchDepositRequest searchDepositRequest = new SearchDepositRequest();
        Long total = depositService.getDepositsTotal(searchDepositRequest);
        List<DepositManageSearch> deposits = depositService.getDeposits(searchDepositRequest);
        for (DepositManageSearch deposit : deposits) {
            deposit.setMember(memberService.getMemberById(deposit.getMemberId()));
        }
        viewObject.put("deposits", deposits);
        viewObject.put("total", total);
        return "deposit/deposit.manager";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> search(@RequestBody SearchDepositRequest request) {
        Map<String, Object> jsonObject = Maps.newHashMap();
        List<DepositManageSearch> depositList = depositService.getDeposits(request);
        for (DepositManageSearch deposit : depositList) {
            deposit.setMember(memberService.getMemberById(deposit.getMemberId()));
        }
        jsonObject.put("depositList", depositList);
        Long totalNumber = depositService.getDepositsTotal(request);
        jsonObject.put("totalNumber", totalNumber);
        jsonObject.put("fetchSize", request.getPageSize());
        return jsonObject;
    }
}

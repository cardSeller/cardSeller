package com.card.seller.portal.controller;


import com.card.seller.domain.*;
import com.card.seller.portal.domain.SearchPortalOrderRequest;
import com.card.seller.portal.service.DepositService;
import com.card.seller.portal.service.ItemService;
import com.card.seller.portal.service.MemberService;
import com.card.seller.portal.service.OrderService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by minjie
 * Date:14-12-23
 * Time:下午9:59
 */
@Controller
@RequestMapping("/member")
public class MemberController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private DepositService depositService;

    @RequestMapping(value = "/orderManage", method = RequestMethod.GET)
    public String orderManage(Map<String, Object> viewObject) {
        SearchPortalOrderRequest searchPortalOrderRequest = new SearchPortalOrderRequest();
        String memberName = SecurityContext.getAccount();
        Member member = memberService.getMemberByName(memberName);
        searchPortalOrderRequest.setMemberId(member.getId());
        Long total = orderService.getOrdersTotal(searchPortalOrderRequest);
        List<OrdersManageSearch> orders = orderService.getOrdersByMemberId(searchPortalOrderRequest);
        for (OrdersManageSearch order : orders) {
            order.setMember(memberService.getMemberById(order.getMemberId()));
            order.setItemPrice(itemService.getItemPriceById(order.getItemPriceId()));
            order.setItem(itemService.getItemById(order.getItemId()));
        }
        viewObject.put("total", total);
        viewObject.put("orders", orders);
        return "member/orderManage";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> search(@RequestBody SearchPortalOrderRequest request) {
        Map<String, Object> jsonObject = Maps.newHashMap();
        List<OrdersManageSearch> ordersList = orderService.getOrdersByMemberId(request);
        for (OrdersManageSearch orders : ordersList) {
            orders.setMember(memberService.getMemberById(orders.getMemberId()));
            orders.setItemPrice(itemService.getItemPriceById(orders.getItemPriceId()));
            orders.setItem(itemService.getItemById(orders.getItemId()));
        }
        jsonObject.put("ordersList", ordersList);
        Long totalNumber = orderService.getOrdersTotal(request);
        jsonObject.put("totalNumber", totalNumber);
        jsonObject.put("fetchSize", request.getPageSize());
        return jsonObject;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Map<String, Object> viewObject) {
        String memberName = SecurityContext.getAccount();
        Member member = memberService.getMemberByName(memberName);
        viewObject.put("member", member);
        return "member/profile";
    }

    @RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
    public int saveProfile(HttpServletRequest request) {
        String memberName = SecurityContext.getAccount();
        Member member = memberService.getMemberByName(memberName);
        setProfile(member, request);
        memberService.updateMember(member);
        return MemberConstants.SUCCESS;
    }

    private void setProfile(Member member, HttpServletRequest request) {
        //TODO set profile
    }

    @RequestMapping(value = "/toModifyPwd", method = RequestMethod.GET)
    public String toModifyPwd() {
        return "member/toModifyPwd";
    }

    @RequestMapping(value = "/checkPwd", method = RequestMethod.POST)
    @ResponseBody
    public int checkPwd(@RequestParam("pwd") String pwd,@RequestParam("newPwd") String newPwd,@RequestParam("confirmNewPwd") String confirmNewPwd) {
        String memberName = SecurityContext.getAccount();
        Member member = memberService.getMemberByName(memberName);
        String realPwd = member.getPwd();
        LOGGER.info("pwd is {} and the relpwd is {}", pwd, realPwd);
        if (!pwd.equals(realPwd)) {
            return MemberConstants.PWD_ERROR;
        }
        if(!newPwd.equals(confirmNewPwd)) {
            return MemberConstants.PWD_CONFIRM_IS_NOT_SAME;
        }
        return MemberConstants.SUCCESS;
    }

    @RequestMapping(value = "/modifyPwd", method = RequestMethod.POST)
    public String changePwd(@RequestParam("pwd") String pwd,@RequestParam("newPwd") String newPwd,@RequestParam("confirmNewPwd") String confirmNewPwd) {
        String memberName = SecurityContext.getAccount();
        Member member = memberService.getMemberByName(memberName);
        memberService.modifyPwd(member, newPwd);
        return "redirect:/logout";
    }

    @RequestMapping(value = "/toDeposit", method = RequestMethod.GET)
    public String toDeposit() {
        return "member/toDeposit";
    }

    @RequestMapping(value = "/depositManage", method = RequestMethod.GET)
    public String depositManage(Map<String, Object> viewObject) {
        String memberName = SecurityContext.getAccount();
        Member member = memberService.getMemberByName(memberName);
        List<Deposit> deposits = depositService.getDepositsByMemberId(member.getId());
        viewObject.put("deposits", deposits);
        return "member/depositManage";
    }

}

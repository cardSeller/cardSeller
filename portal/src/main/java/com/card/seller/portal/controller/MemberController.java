package com.card.seller.portal.controller;


import com.card.seller.domain.Member;
import com.card.seller.domain.Orders;
import com.card.seller.domain.SecurityContext;
import com.card.seller.portal.service.ItemService;
import com.card.seller.portal.service.MemberService;
import com.card.seller.portal.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @Autowired
    private OrderService orderService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/orderManage", method = RequestMethod.GET)
    public String orderManage(Map<String, Object> viewObject) {
        String memberName = SecurityContext.getAccount();
        Member member = memberService.getMemberByName(memberName);
        List<Orders> orders = orderService.getOrdersByMemberId(member.getId());
        for (Orders order : orders) {
            order.setMember(memberService.getMemberById(order.getMemberId()));
            order.setItemPrice(itemService.getItemPriceById(order.getItemPriceId()));
            order.setItem(itemService.getItemById(order.getItemId()));
        }
        viewObject.put("orders", orders);
        return "member/orderManage";
    }

}

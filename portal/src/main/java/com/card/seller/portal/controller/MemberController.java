package com.card.seller.portal.controller;


import com.card.seller.domain.Member;
import com.card.seller.domain.MemberConstants;
import com.card.seller.domain.Orders;
import com.card.seller.domain.SecurityContext;
import com.card.seller.portal.service.ItemService;
import com.card.seller.portal.service.MemberService;
import com.card.seller.portal.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

}

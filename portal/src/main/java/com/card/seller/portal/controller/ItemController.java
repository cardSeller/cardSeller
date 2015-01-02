package com.card.seller.portal.controller;

import com.card.seller.domain.*;
import com.card.seller.portal.service.GenerateService;
import com.card.seller.portal.service.ItemService;
import com.card.seller.portal.service.MemberService;
import com.card.seller.portal.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * Created by minjie
 * Date:14-12-29
 * Time:下午3:04
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private GenerateService generateService;

    @RequestMapping(value = "/detail/{itemId}", method = RequestMethod.GET)
    public String detail(@PathVariable(value = "itemId") Long itemId, Map<String, Object> viewObject) {
        Item item = itemService.getItemById(itemId);
        item.setItemPriceList(itemService.getItemPricesByItemId(item.getId()));
        viewObject.put("item", item);
        viewObject.put("price", item.getItemPriceList().get(0).getPrice());
        viewObject.put("priceId", item.getItemPriceList().get(0).getId());
        return "item/detail";
    }

    @RequestMapping(value = "/submitOrder", method = RequestMethod.POST)
    public String submitOrder(@RequestParam(value = "orderNumber", required = false) String orderNumber, @RequestParam("itemId") Long itemId, @RequestParam("itemPriceId") Long itemPriceId, @RequestParam("total") BigDecimal total, @RequestParam("count") Integer count, Map<String, Object> viewObject) {
        String memberName = SecurityContext.getAccount();
        Member member = memberService.getMemberByName(memberName);
        viewObject.put("member", member);
        Item item = itemService.getItemById(itemId);
        viewObject.put("item", item);
        ItemPrice itemPrice = itemService.getItemPriceById(itemPriceId);
        viewObject.put("itemPrice", itemPrice);
        viewObject.put("count", count);
        viewObject.put("total", total);
        if(orderNumber == null) {
            orderNumber = generateService.generateOrderNumber();
            orderService.saveOrder(orderNumber, member.getId(), itemId, itemPriceId, total, count, OrderStatus.NP, new Date());
        }
        viewObject.put("orderNumber", orderNumber);
        return "item/toPay";
    }

    @RequestMapping(value = "/payOrder", method = RequestMethod.POST)
    public String payOrder(@RequestParam("orderNumber") String orderNumber) {
        Orders orders = orderService.getOrderByOrderNumber(orderNumber);
        orderService.updateOrderStatus(orderNumber, OrderStatus.HP);
        Member member = memberService.getMemberById(orders.getMemberId());
        memberService.balance(member, orders.getTotal());
        return "redirect:/member/orderManage";
    }
}

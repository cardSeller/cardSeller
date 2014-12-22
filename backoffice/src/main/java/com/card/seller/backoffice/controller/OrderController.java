package com.card.seller.backoffice.controller;

import com.card.seller.backoffice.domain.SearchOrderRequest;
import com.card.seller.backoffice.service.ItemService;
import com.card.seller.backoffice.service.MemberService;
import com.card.seller.backoffice.service.OrderService;
import com.card.seller.domain.ItemPrice;
import com.card.seller.domain.OrderStatus;
import com.card.seller.domain.Orders;
import com.card.seller.domain.OrdersManageSearch;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by minjie
 * Date:14-12-21
 * Time:下午1:57
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/orderManager", method = RequestMethod.GET)
    public String orderManager(Map<String, Object> viewObject) {
        SearchOrderRequest searchOrderRequest = new SearchOrderRequest();
        Long total = orderService.getOrdersTotal(searchOrderRequest);
        List<OrdersManageSearch> orderses = orderService.getOrders(searchOrderRequest);
        for (OrdersManageSearch orders : orderses) {
            orders.setMember(memberService.getMemberById(orders.getMemberId()));
            orders.setItemPrice(itemService.getItemPriceById(orders.getItemPriceId()));
            orders.setItem(itemService.getItemById(orders.getItemId()));
        }
        viewObject.put("orderses", orderses);
        viewObject.put("total", total);
        return "order/order.manager";
    }

    @RequestMapping(value = "/process/{orderNumber}", method = RequestMethod.GET)
    public String process(@PathVariable String orderNumber) {
        Orders order = orderService.getOrderById(orderNumber);
        if(order == null || !OrderStatus.HP.equals(order.getOrderStatus())) {
            return "redirect:/order/orderManager";
        }
        orderService.updateOrderStatus(order, OrderStatus.TS);
        return "redirect:/order/orderManager";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> search(@RequestBody SearchOrderRequest request) {
        Map<String, Object> jsonObject = Maps.newHashMap();
        List<OrdersManageSearch> ordersList = orderService.getOrders(request);
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

}

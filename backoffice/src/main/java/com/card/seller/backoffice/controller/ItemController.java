package com.card.seller.backoffice.controller;

import com.card.seller.backoffice.service.ItemService;
import com.card.seller.dao.ItemPriceDao;
import com.card.seller.domain.Item;
import com.card.seller.domain.ItemPrice;
import com.card.seller.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by minjie
 * Date:14-12-11
 * Time:下午9:23
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/itemManager", method = RequestMethod.GET)
    public String memberManager(Map<String, Object> viewObject) {
        List<Item> items = itemService.getAllItems();
        for (Item item : items) {
            item.setItemPriceList(itemService.getItemPricesByItemId(item.getId()));
        }
        viewObject.put("items", items);
        viewObject.put("total", items.size());
        return "item/item.manager";
    }
}

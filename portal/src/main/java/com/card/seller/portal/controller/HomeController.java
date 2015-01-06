package com.card.seller.portal.controller;

import com.card.seller.domain.Item;
import com.card.seller.portal.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by minjie
 * Date:14-11-11
 * Time:下午2:15
 */
@Controller
public class HomeController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home(Map<String,Object> viewObject) {
        List<Item> homeItems = itemService.getHomeItems();
        viewObject.put("homeItems", homeItems);
        List<Item> itemsAtoH = itemService.getItemsByInitial("A", "H");
        List<Item> itemsItoP = itemService.getItemsByInitial("I", "P");
        List<Item> itemsQtoZ = itemService.getItemsByInitial("Q", "Z");
        Map<String,List<Item>> ahMap = new HashMap<String, List<Item>>();
        Map<String,List<Item>> ipMap = new HashMap<String, List<Item>>();
        Map<String,List<Item>> qzMap = new HashMap<String, List<Item>>();
        contructMap(itemsAtoH, ahMap);
        contructMap(itemsItoP, ipMap);
        contructMap(itemsQtoZ, qzMap);
        viewObject.put("ahMap", ahMap);
        viewObject.put("ipMap", ipMap);
        viewObject.put("qzMap", qzMap);
        return "/home";
    }

    private void contructMap(List<Item> itemList, Map<String, List<Item>> map) {
        for (Item item : itemList) {
            String initial = item.getInitial();
            if(!map.containsKey(initial)) {
                List<Item> items = new ArrayList<Item>();
                items.add(item);
                map.put(initial, items);
            } else {
                List<Item> items = map.get(initial);
                items.add(item);
                map.put(initial, items);
            }
        }
    }

    @RequestMapping("/realHome")
    public String realHome() {
        return "/realhome";
    }

    @RequestMapping("/manifesto")
    public String manifesto() {
        return "/manifesto";
    }

    @RequestMapping("/qa")
    public String qa() {
        return "/qa";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "/contact";
    }
}

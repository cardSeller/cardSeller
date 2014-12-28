package com.card.seller.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by minjie
 * Date:14-11-11
 * Time:下午2:15
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home() {
        return "/home";
    }

    @RequestMapping("/realHome")
    public String realHome() {
        return "/realhome";
    }

}

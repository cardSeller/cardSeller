package com.card.seller.backoffice.controller;

import com.card.seller.backoffice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by minjie
 * Date:14-12-9
 * Time:下午9:24
 */
@RequestMapping
@Controller
public class HomeController {

    @Autowired
    private UserService userService;


    @RequestMapping("/")
    public String index() {
        return "forward:/home";
    }

    @RequestMapping("/home")
    public String home() {
        return "/home";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "exception/unauthorized";
    }

    @RequestMapping("change-pwd")
    public String changePwd(String oldPassword, String newPassword) {
        userService.updateUserPassword(oldPassword, newPassword);
        return "redirect:/logout";
    }
}
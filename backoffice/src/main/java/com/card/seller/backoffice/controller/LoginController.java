package com.card.seller.backoffice.controller;

import com.card.seller.domain.SecurityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by minjie
 * Date:14-11-13
 * Time:下午4:32
 */
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public String login() {
        if (SecurityContext.isAuthenticate()) {
            return "redirect:/home";
        }
        return "/login";
    }
}

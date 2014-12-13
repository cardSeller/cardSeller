package com.card.seller.backoffice.controller;

import com.card.seller.backoffice.service.MemberService;
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
 * Time:下午5:45
 */
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/memberManager", method = RequestMethod.GET)
    public String memberManager(Map<String, Object> viewObject) {
        List<Member> members = memberService.getAllMembers();
        viewObject.put("members", members);
        viewObject.put("total", members.size());
        return "member/member.manager";
    }
}

package com.card.seller.portal.controller;

import com.card.seller.domain.AnalyzeIpUtils;
import com.card.seller.domain.CaptchaUtils;
import com.card.seller.domain.Member;
import com.card.seller.domain.MemberConstants;
import com.card.seller.portal.domain.AddMemberRequest;
import com.card.seller.portal.exception.CheckMemberException;
import com.card.seller.portal.service.MemberService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by minjie
 * Date:14-11-10
 * Time:下午9:33
 */
@Controller
public class RegisterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/toRegister", method = RequestMethod.GET)
    public String toRegister(@RequestParam(value = "redirectUrl", required = false) String redirectUrl, Map<String, Object> viewObject) {
        return "/toRegister";
    }

    @RequestMapping("/getCaptcha")
    public ResponseEntity<byte[]> getCaptcha(HttpSession session) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String captcha = CaptchaUtils.getCaptcha(80, 32, 5, outputStream).toLowerCase();

        session.setAttribute("captcha", captcha);
        byte[] bs = outputStream.toByteArray();
        outputStream.close();
        return new ResponseEntity<byte[]>(bs, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/checkRegName", method = RequestMethod.POST)
    @ResponseBody
    public int checkRegName(@Valid @RequestParam("regName") String regName) {
        int resultCode = MemberConstants.SUCCESS;
        try {
            memberService.checkMemberByAccount(regName);
        } catch (CheckMemberException e) {
            LOGGER.error("check regName error" + e.getMessage());
            LOGGER.error("check regName error :" + e.getMessage());
            resultCode = e.getResultCode();
        } catch (Exception e) {
            LOGGER.error("check regName error", e);
            resultCode = MemberConstants.OTHER_ERROR;
        }
        return resultCode;
    }

    @RequestMapping(value = "/checkCaptcha", method = RequestMethod.POST)
    @ResponseBody
    public int checkCaptcha(@Valid @RequestParam("imageCode") String imageCode, HttpSession session) {
        String captcha = (String) session.getAttribute("captcha");
        LOGGER.info("captcha is {} and the imageCode is {}", captcha, imageCode);
        if (imageCode.equalsIgnoreCase(captcha)) {
            return MemberConstants.SUCCESS;
        }
        return MemberConstants.CAPTCHA_ERROR;
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @ResponseBody
    public int regist(HttpServletRequest request, @Valid @RequestBody AddMemberRequest addMemberRequest) {
        String ip = AnalyzeIpUtils.getIpAddr(request);
        memberService.saveMember(addMemberRequest.getRegName(), addMemberRequest.getPwd(), addMemberRequest.getPhone(), addMemberRequest.getRealName(), addMemberRequest.getIdentity(), ip);
        return MemberConstants.SUCCESS;
    }
}

package com.card.seller.backoffice.security;

import com.card.seller.domain.DealWithCookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by minjie
 * Date:14-11-13
 * Time:下午3:56
 */
public class CardSellerBoAuthenticationFilter extends FormAuthenticationFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CardSellerBoAuthenticationFilter.class);

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        String redirectUrl = DealWithCookieUtils.getCookieValue((HttpServletRequest) request, "redirectUrl");
        LOGGER.info("the redirectUrl is {}.", redirectUrl);
        if (StringUtils.isNotBlank(redirectUrl)) {
            super.setSuccessUrl(redirectUrl);
        }

        DealWithCookieUtils.deleteCookie("redirectUrl", null, (HttpServletResponse) response);
        return super.onLoginSuccess(token, subject, request, response);
    }
}

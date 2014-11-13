package com.card.seller.backoffice.interceptor;

import com.card.seller.domain.WebConstants;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: minj
 * Date: 13-12-4
 * Time: 下午5:31
 */
public class AbsolutelyPathInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.getSession().setAttribute(WebConstants.ABSOLUTE_CONTEXT_PATH, getAbsolutePath(request));
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    public static String getAbsolutePath(HttpServletRequest request) {
        String absoluteContextPath;
        if (request.getServerPort() == 80) {
            absoluteContextPath = WebConstants.HTTP_PROTOCOL + request.getServerName() + request.getContextPath();
        } else if (request.getServerPort() == 443) {
            absoluteContextPath = WebConstants.HTTPS_PROTOCOL + request.getServerName() + request.getContextPath();
        } else {
            absoluteContextPath = WebConstants.HTTP_PROTOCOL + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        }
        return absoluteContextPath;
    }
}

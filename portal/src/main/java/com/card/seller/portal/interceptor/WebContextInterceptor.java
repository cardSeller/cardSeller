package com.card.seller.portal.interceptor;

import com.card.seller.portal.domain.WebContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: minj
 * Date: 13-12-4
 * Time: 下午5:21
 */
public class WebContextInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        WebContext.register(request, response);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        WebContext.unRegister();
        super.afterCompletion(request, response, handler, ex);
    }
}

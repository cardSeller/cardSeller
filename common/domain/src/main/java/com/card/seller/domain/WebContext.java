package com.card.seller.domain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: minjie
 * Date: 13-11-25
 * Time: 下午4:48
 */
public class WebContext {

    private static ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal<HttpServletRequest>();
    private static ThreadLocal<HttpServletResponse> responseThreadLocal = new ThreadLocal<HttpServletResponse>();

    public static void unRegister() {
        requestThreadLocal.remove();
        responseThreadLocal.remove();
    }

    public static void register(HttpServletRequest request, HttpServletResponse response) {
        requestThreadLocal.set(request);
        responseThreadLocal.set(response);
    }

    public static HttpServletRequest getRequest() {
        HttpServletRequest request = requestThreadLocal.get();
        if (request == null) {
            throw new RuntimeException("the error seems will not occur . HttpServletRequest null. ");
        }
        return requestThreadLocal.get();
    }

    public static HttpServletResponse getResponse() {
        HttpServletResponse response = responseThreadLocal.get();
        if (response == null) {
            throw new RuntimeException("the error seems will not occur . HttpServletResponse null. ");
        }
        return response;
    }
}

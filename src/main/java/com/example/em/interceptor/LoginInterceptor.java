package com.example.em.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于登录操作的拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user == null) {
            logger.info(request.getRequestURL().toString());
            logger.info("该用户无权限登录");
            request.setAttribute("msg", "请先登录！");
            request.getRequestDispatcher("/index").forward(request, response);
            return false;
        } else {
            return true;
        }
    }
}

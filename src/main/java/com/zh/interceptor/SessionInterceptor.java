package com.zh.interceptor;

import com.zh.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
* 会话拦截器
* */
public class SessionInterceptor implements HandlerInterceptor {

    private static Logger LOGGER = Logger.getLogger(SessionInterceptor.class);


    // 检查当前会话是否有User，如果有放行，没有不放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("SESSION_USER");

        if (user == null) {
            LOGGER.warn("您没有操作权限，请先登录！");
            return false;
        }

        if (user instanceof User) {
            User u = (User) user;
            u.setPassword(null);
            request.getSession().setAttribute("SESSION_USER", u);
            LOGGER.info(u.getName() + " 处于登录状态.");
            return true;
        } else {
            LOGGER.warn("您没有操作权限，请先登录！");
            return false;
        }
    }
}

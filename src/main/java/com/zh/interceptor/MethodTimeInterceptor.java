package com.zh.interceptor;



import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
* 方法耗时统计器
* */
public class MethodTimeInterceptor implements HandlerInterceptor {

    private static Logger LOGGER = Logger.getLogger(MethodTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 定义开始的时间
        long startTime = System.currentTimeMillis();
        // 2. 放到请求域中
        request.setAttribute("startTime", startTime);

        LOGGER.info(request.getRequestURI() + "，请求到达.");
        // 3. 如果返回false，这不进行其他拦截处理，直接返回controller
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 1. 去除startTime
        long startTime = (long) request.getAttribute("startTime");
        // 2. 定义结束时间
        long endTime = System.currentTimeMillis();

        // 3. 计算方法运行时间
        long interval = endTime - startTime;
        if (interval >= 1000) {
            LOGGER.warn("方法耗时验证，耗时：" + interval + " 毫秒. 结果不正常.");
        } else {
            LOGGER.info("方法耗时：" + interval + " 毫秒. 结果正常.");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

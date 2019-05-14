package com.zh.com.zh.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

// 用于获取当前项目路径，不做任何请求的匹配
@WebServlet(urlPatterns = {}, loadOnStartup = 2)
public class WebPathInitServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        config.getServletContext().setAttribute("ctx", config.getServletContext().getContextPath());
        super.init(config);
    }
}

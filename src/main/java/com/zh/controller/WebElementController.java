package com.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/web")
public class WebElementController {

    // 模拟请求
    @RequestMapping("/request")
    public String request(WebRequest request) {
        System.out.println(request.getParameter("girl"));
        return "forward";
    }

    // 真实请求
    @RequestMapping("/request2")
    public String request2(HttpServletRequest request) {
        System.out.println(request.getParameter("boy"));
        return "forward";
    }

    // 真实请求
    @RequestMapping("/request3")
    public String request3(HttpSession session) {
        // session数据
        session.setAttribute("game", "神庙逃亡");
        // application context数据
        session.getServletContext().setAttribute("context","会话");
        return "redirect:/jsp/redirect.jsp";
    }

    // 响应多个路径
    @RequestMapping(value = {"/m1", "/m2"})
    public String m1() {
        System.out.println("m1...");
        return "forward";
    }

    // 响应多个路径
    @RequestMapping(value = {"/m3", "/m4"}, method = RequestMethod.POST)
    public String m2() {
        System.out.println("m2...");
        return "forward";
    }

    // 响应多个路径
    @RequestMapping(value = "/m4", params = {"girl=wangfei","boy!=zhouhong"})
    public String m3() {
        System.out.println("m3...");
        return "forward";
    }

//    @RequestMapping(value = "/m5?")
//    @RequestMapping(value = "/m5*")
    @RequestMapping(value = "/m5/**")
    public String m4() {
        System.out.println("m4...");
        return "forward";
    }

    @RequestMapping(value = "/m6", method = RequestMethod.DELETE)
    @ResponseBody()
    public String m5() {
        System.out.println("m5...");
        return "forward";
    }

    @RequestMapping(value = "/m7", method = RequestMethod.PUT)
    @ResponseBody()
    public String m6(HttpServletRequest request) {
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        System.out.println("m6...");
        System.out.println(name + " " + sex + " " + age);
        return "forward";
    }
}

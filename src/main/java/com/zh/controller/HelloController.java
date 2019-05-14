package com.zh.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController{

    @RequestMapping("/forward")
    public String forward(Model model) {
        System.out.println("111111");
        // spring mvc model默认在请求域存储值
        model.addAttribute("skill", "睡觉");
//        return "hello/forward";
        return "forward";
    }

    @RequestMapping("/redirect")
    public String redirect(Model model) {
        System.out.println("22222");
        model.addAttribute("test", "煮饭");
        // 不带/的写法指向相对路径，根据上下文确定。hello
        // 如果是重定向，跟视图解析规则没有关系，即不会再起前面加上/jsp/和.jsp后缀
        // model里的数据当成参数
//        return "redirect:/jsp/redirect.jsp";
//        return "redirect:/hello/forward";
        return "redirect:forward";
//        return "redirect:/baby/hello";
    }

    @RequestMapping("/forward2")
    public String forwardAnotherController(Model model) {
        System.out.println("333333");
        model.addAttribute("skill", "洗澡");
//        return "forward:/baby/hello";
//        return "forward:/hello/forward";
        return "forward:forward";
    }
}

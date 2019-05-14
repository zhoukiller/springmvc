package com.zh.controller;

import com.zh.pojo.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/user2")
public class User2Controller {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @ModelAttribute
    public User init() {
        System.out.println("init....");
        User u = new User();
        u.setName("周宏");
        u.setPassword("123456");
        u.setBirth(new Date());
        return u;
    }

    @ModelAttribute("user")
    public void user(Model model) {
        System.out.println("init....");
        User u = new User();
        u.setName("周宏");
        u.setPassword("123456");
        u.setBirth(new Date());
        model.addAttribute("user", u);
    }

//    @RequestMapping("/login2")
//    public String login(Model model) {
//        System.out.println("login");
//
//        System.out.println(model.containsAttribute("u"));
//        System.out.println(model.containsAttribute("user"));
//        System.out.println(model.containsAttribute("afhh"));
//
//        return "msg";
//    }

    @RequestMapping("/login2")
    public String login(@ModelAttribute User user) {
        System.out.println(user);
        return "msg";
    }
}

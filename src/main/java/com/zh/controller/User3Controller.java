package com.zh.controller;

import com.zh.pojo.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/user3")
@SessionAttributes("user")
public class User3Controller {

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//    }

//    @ModelAttribute
//    public User init() {
//        System.out.println("init....");
//        User u = new User();
//        u.setName("周宏");
//        u.setPassword("123456");
//        u.setBirth(new Date());
//        return u;
//    }

//    @ModelAttribute("user")
//    public void user(Model model) {
//        System.out.println("init....");
//        User u = new User();
//        u.setName("周宏");
//        u.setPassword("123456");
//        u.setBirth(new Date());
//        model.addAttribute("user", u);
//    }

    @RequestMapping("/login3")
    public String login(User user) {
        System.out.println(user);
        return "redirect:/jsp/user.jsp";
    }
}

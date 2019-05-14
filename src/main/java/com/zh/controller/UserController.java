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
@RequestMapping("/user")
public class UserController {

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
//        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat1.setLenient(false);
//        dateFormat2.setLenient(false);
//        dateFormat3.setLenient(false);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat1, false));
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat2, false));
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat3, false));
//    }


//    @ModelAttribute("u2")
//    public User init() {
//        System.out.println("init....");
//        User u = new User();
//        u.setName("周宏");
//        u.setPassword("123456");
//        u.setBirth(new Date());
//        return u;
//    }

//    @ModelAttribute("u2")
//    public void user(Model model) {
//        System.out.println("init....");
//        User u = new User();
//        u.setName("周宏");
//        u.setPassword("123");
//        u.setBirth(new Date());
//        model.addAttribute("u", u);
//
//    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    @ResponseBody
    public String put(User user) {
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        System.out.println(user.getBirth());
        return "put";
    }

    @RequestMapping("/login")
    public String login(Model model, @ModelAttribute User user) {
        System.out.println("login");
        System.out.println(user);
//        System.out.println(model.containsAttribute("u"));
//        System.out.println(model.containsAttribute("u2"));
//        System.out.println(model.containsAttribute("user"));
//        System.out.println(model.containsAttribute("afhh"));

        return "msg";
    }
}

package com.zh.controller;

import com.zh.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public String login(User user, HttpSession session) {
        System.out.println("login...");
        session.setAttribute("SESSION_USER", user);
        return "user";
    }

    @RequestMapping("/delete")
    public String delete() {
        System.out.println("delete...");
        return "user";
    }
}

package com.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/baby")
public class BabyController {

    @RequestMapping("/hello")
    public String greeting(Model model) {
        model.addAttribute("skill", "上课");
        System.out.println("Baby hello");
        return "forward";
    }
}

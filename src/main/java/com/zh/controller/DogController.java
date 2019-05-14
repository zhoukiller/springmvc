package com.zh.controller;

import com.zh.pojo.Dog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/dog")
public class DogController {


    @RequestMapping("/login")
    public String login(@SessionAttribute Dog dog) {
        System.out.println(dog.getName());
        return "redirect:/jsp/dog.jsp";
    }
}

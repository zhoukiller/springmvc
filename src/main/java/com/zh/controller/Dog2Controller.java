package com.zh.controller;

import com.zh.pojo.Dog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/dog2")
@SessionAttributes("dog")
public class Dog2Controller {

    @RequestMapping("/register")
    public String register(Dog dog) {
        System.out.println(dog.getName());
        return "dog";
    }
}

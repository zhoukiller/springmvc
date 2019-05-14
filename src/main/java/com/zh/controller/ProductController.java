package com.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// restful风格控制器
@Controller
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/add/{id}/{name}/{price}")
    public String addProduct(@PathVariable("id") Integer id, @PathVariable("name") String name,
                             @PathVariable("price") Double price) {
        System.out.println(id + " " + name + " " +price);
        return "forward";
    }
}

package com.zh.controller;

import com.zh.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller // 等于controller + ResponseBody
@RequestMapping("/json2")
public class JsonController2 {

    //前台提交一个User对象
    // User入参，只能通过form表单提交的方式获取数据
    // RequestBody
    @RequestMapping("/add")
    @ResponseBody
    public String add(@RequestBody User user) {
        System.out.println(user);
        return "msg";
    }

    @RequestMapping("/addList")
    @ResponseBody
    public Map<String, Integer> addList(@RequestBody List<User> list) {
        Map<String, Integer> map = new HashMap<>();
        map.put("status", 200);
        System.out.println(list);
        return map;
    }

}

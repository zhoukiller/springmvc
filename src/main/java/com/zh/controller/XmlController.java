package com.zh.controller;

import com.zh.pojo.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/xml")
public class XmlController {
    @RequestMapping(value = "/m1", produces = {MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public User m1() {
        User user = new User();
        user.setName("李四");
        user.setPwd("123456");
        return user;
    }
}

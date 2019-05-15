package com.zh.controller;

import com.zh.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller
@RestController // 等于controller + ResponseBody
@RequestMapping("/json")
public class JsonController {

    @RequestMapping("/m1")
//    @ResponseBody
    public User m1() {
        User user = new User();
        user.setName("张三");
        user.setPwd("123456");
        return user;
    }

    @RequestMapping("/m2")
//    @ResponseBody
    public Map<String, Object> m2() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "徐青青");
        map.put("age", 28);
        return map;
    }

    @RequestMapping("/m3")
//    @ResponseBody
    public User[] m3() {
        User user = new User();
        user.setName("张三");
        user.setPwd("123456");
        User user2 = new User();
        user2.setName("李四");
        user2.setPwd("987654");
        return new User[]{user,user2};
    }

    @RequestMapping("/m4")
//    @ResponseBody
    public List<User> m4() {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setName("张三");
        user.setPwd("123456");
        User user2 = new User();
        user2.setName("李四");
        user2.setPwd("987654");
        list.add(user);
        list.add(user2);
        return list;
    }

    @RequestMapping("/m5")
    public List<Map<String, User>> m5() {
        List<Map<String, User>> list = new ArrayList<>();

        Map<String, User> map1 = new HashMap<>();

        User user = new User();
        user.setName("张三1");
        user.setPwd("123456");

        User user2 = new User();
        user2.setName("李四1");
        user2.setPwd("987654");

        map1.put("u1", user);
        map1.put("u2", user2);

        Map<String, User> map2 = new HashMap<>();

        User user3 = new User();
        user3.setName("张三2");
        user3.setPwd("123456");

        User user4 = new User();
        user4.setName("李四12");
        user4.setPwd("987654");

        map2.put("u3", user3);
        map2.put("u4", user4);

        list.add(map1);
        list.add(map2);
        return list;
    }
}

package com.zh.controller;

import com.zh.constant.ResponseCode;
import com.zh.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/checkName")
    @ResponseBody
    public Map<String, Integer> checkName(@RequestBody User user) {
        int code = ResponseCode.CAN_USE;
        if (user.getName().equals("王菲")) {
            code = ResponseCode.HAS_USED;
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("status", code);
        return map;
    }
}

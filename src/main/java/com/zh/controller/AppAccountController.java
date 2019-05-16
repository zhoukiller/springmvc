package com.zh.controller;

import com.zh.pojo.AppAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/appAccount")
public class AppAccountController {

    @RequestMapping("/index")
    public String index(Model model) {
        List<AppAccount> list = new ArrayList<>();
        AppAccount account1 = new AppAccount(1, "张三","管理员");
        AppAccount account2 = new AppAccount(2, "李四", "员工");
        list.add(account1);
        list.add(account2);
        model.addAttribute("appAccount", list);
        return "appAccount/index";
    }
}
package com.hyb.controller;

import com.hyb.config.WxLoginProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private WxLoginProperties login;

    @GetMapping("/login")
    public void login () {
        System.out.println(login.getAppId());
        System.out.println(login.getSecret());
    }
}

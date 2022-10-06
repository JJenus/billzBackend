package com.onetap.billzBackend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Auth {
    @PostMapping("register")
    public void register(){

    }

    @PostMapping("login")
    public void login(){}

    @PostMapping("reset-password")
    public void resetPassword(){}

    @PostMapping("forgot-password")
    public void forgotPassword(){}
}

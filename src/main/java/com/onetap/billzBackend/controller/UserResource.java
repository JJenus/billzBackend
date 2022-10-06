package com.onetap.billzBackend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserResource {
    @GetMapping
    public void user(){}

    @PutMapping
    public void updateUser(String email){}

    @DeleteMapping
    public void deleteUser(){}
}

package com.example.hostelmanagemant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public String loginIndex(){
        System.out.printf("I am login page");
        return "UserReg/form";
    }

    @RequestMapping("signup")
    public String signUpPage(){
        System.out.println("I am in sign out");
        return "UserReg/signup";
    }
}

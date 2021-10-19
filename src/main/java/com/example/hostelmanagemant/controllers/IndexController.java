package com.example.hostelmanagemant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping({"","/","/index"})
    public String indexpage(){
        System.out.println("I am in");
        return "index";
    }


}

package com.ntt.cinema.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashbaordController {
    @GetMapping("/")
    public String showMyPage() {
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
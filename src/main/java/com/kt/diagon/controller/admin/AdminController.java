package com.kt.diagon.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping("/admin")
    public String admin() {
        return "admin/index";
    }

    @RequestMapping("/login")
    public String login() {
        return "admin/layout/login";
    }
    @RequestMapping("/register")
    public String register() {
        return "admin/layout/register";
    }
}
package com.ice.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf")
    public String showInfo(Model model){

        model.addAttribute("url", "www.mayufeng.club");
        model.addAttribute("owner", "马玉峰");

        return "thymeleaf";
    }
}

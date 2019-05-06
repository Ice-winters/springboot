package com.ice.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ice.springboot.vo.Member;
import com.ice.springboot.vo.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ModelAttributeController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @ModelAttribute
    public void initUser1(@PathVariable("age") int age ,Model model){
        User user1 = new User("ice_1", age);
        model.addAttribute("user1", user1);
    }

    @ModelAttribute
    public void initUser2(@PathVariable("age") int age,Model model){
        User user2 = new User("ice_2", age);
        model.addAttribute("user2", user2);
    }

    @GetMapping("/user/{age}")
    public String getUser(Model model) throws JsonProcessingException {
        List<User> list = new ArrayList<>();

        String s = objectMapper.writeValueAsString(model);
        return "s";


    }
}

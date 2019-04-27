package com.ice.springboot.controller;

import com.ice.springboot.common.service.DateBinder;
import com.ice.springboot.vo.Member;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: Ice-winters
 * @Date: 2019/4/25 21:11
 * @Description:
 */
@Controller
public class MemberController implements DateBinder {

    @RequestMapping(value = "/addPre",method = RequestMethod.GET)
    public String addPre(){
        return "add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Object add(@Valid Member member, BindingResult bindingResult){
//        System.out.println("add method " + bindingResult.hasErrors());
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().forEach(objectError -> {
                System.out.println("[错误信息] code = " + objectError.getCode() + "\t" + objectError.getDefaultMessage().toString());
            });
        }
        return member;
    }


}

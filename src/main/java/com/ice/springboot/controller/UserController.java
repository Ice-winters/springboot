package com.ice.springboot.controller;

import com.ice.springboot.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @GetMapping(value = "/users")
    public String users(Model model) {
        User user = new User("icewinters", 27);
        user.setBirthday(new Date());
        model.addAttribute("myuser", user);
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add("我是第" + i + "个");
        }
        model.addAttribute("mylist", list);
        model.addAttribute("texthtml", "你好呀，我叫<b>马玉峰</b>，你呢？");

        return "user";

    }

    /**
     * <pre>
     * 测试全局异常处理
     * {@link com.ice.springboot.advice.GlobalExceptionAdvice}
     * @return
     * </pre>
     */
    @GetMapping(value = "/users-error")
    public String users_error() {
        int mulResult = 200 / 0;
        return "user";
    }
}

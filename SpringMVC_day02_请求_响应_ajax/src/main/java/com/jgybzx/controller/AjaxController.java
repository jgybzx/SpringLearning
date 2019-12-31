package com.jgybzx.controller;

import com.jgybzx.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: guojy
 * @date: 2019/12/30 14:11
 * @Description: ${TODO}
 * @version:
 */
@Controller
@RequestMapping("/Ajax")
public class AjaxController {
    @RequestMapping("demo1")
    @ResponseBody
    public String demo1() {
        //返回普通数据
        return "ajax请求成功";
    }

    @RequestMapping("demo2")
    @ResponseBody
    public User demo2(@RequestBody User user) {
        User user1 = new User();
        user1 = user;
        //返回json数据，spring自动封装
        return user1;
    }
}

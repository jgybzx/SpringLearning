package com.jgybzx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: guojy
 * @date: 2019/12/31 14:02
 * @Description: ${TODO}
 * @version:
 */
@Controller
public class Mycontroller {
    @RequestMapping("test")
    public String test() {
        System.out.println("Mycontroller    执行");
        return "success";
    }
    //模拟用户登陆
    @RequestMapping("login")
    public String login(HttpServletRequest request) {
        //模拟登陆成功,在本次会话中存取登陆信息,手动放入一个字符串
        //只需要在拦截器中判断，字符串是否为空即可
        request.getSession().setAttribute("login","张三");
        return "success";
    }
    @RequestMapping("update")
    public String update(HttpServletRequest request) {
        System.out.println("update执行");
        return "success";
    }
}

package com.jgybzx.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping()
public class DemoController {
    /**
     * 需要给每个被访问的访问配置一个请求路径
     */
    @RequestMapping("/demo112")
    public String demo1(@RequestParam("username") String username2,
                        String password ,
                        Integer age){
        System.out.println(username2);
        System.out.println(password);
        System.out.println(age);
        return "success";
    }

    @RequestMapping("/Demo")
    public String Demo() {

        return "Success";
    }
}

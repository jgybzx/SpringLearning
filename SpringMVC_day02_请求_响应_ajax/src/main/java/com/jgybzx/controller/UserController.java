package com.jgybzx.controller;

import com.jgybzx.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: guojy
 * @date: 2019/12/30 18:20
 * @Description: ${TODO}
 * @version:
 */
@Controller
public class UserController {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public void save() {
        System.out.println("无参get请求执行");
    }

    @RequestMapping(value = "/user/{username}/{password}", method = RequestMethod.GET)
    public void update(@PathVariable("username") String username,
                       @PathVariable("password") String password) {

        System.out.println("有参get请求执行");
        System.out.println("username = " + username);
        System.out.println("password = " + password);

    }
}

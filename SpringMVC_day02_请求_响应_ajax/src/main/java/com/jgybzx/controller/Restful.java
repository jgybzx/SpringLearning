package com.jgybzx.controller;

import com.jgybzx.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: guojy
 * @date: 2019/12/30 16:40
 * @Description: ${TODO}
 * @version:
 */
@Controller
public class Restful {

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public void save(User user) {
        System.out.println("save 执行");
    }

    @RequestMapping(value = "/person", method = RequestMethod.PUT)
    public void update(User user) {
        System.out.println("update 执行");
    }

    @RequestMapping(value = "/person", method = RequestMethod.DELETE)
    public void delete(String id) {
        System.out.println("delete 执行");
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public void find() {
        System.out.println("find 执行");
    }
}

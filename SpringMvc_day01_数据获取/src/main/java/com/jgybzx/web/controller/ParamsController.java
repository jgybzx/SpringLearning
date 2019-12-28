package com.jgybzx.web.controller;

import com.jgybzx.domain.ListDemo;
import com.jgybzx.domain.MapDemo;
import com.jgybzx.domain.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: guojy
 * @date: 2019/12/27 20:26
 * @Description:
 * @version:
 */
@Controller
@RequestMapping("/param")
public class ParamsController {
    @RequestMapping(value = "/demo1",method = RequestMethod.POST)
    public String demo1(String username ,String password,String age){
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("password = " + password);
        return "Success";
    }
    @RequestMapping(value = "/demo2")
    public String demo2(People people){
        System.out.println("people = " + people);
        return "Success";
    }
    @RequestMapping(value = "/demo3")
    public String demo2(ListDemo listDemo){
        System.out.println("listDemo = " + listDemo);
        return "Success";
    }
    @RequestMapping(value = "/demo4")
    public String demo4(MapDemo mapDemo){
        System.out.println("mapDemo = " + mapDemo);
        return "Success";
    }
}

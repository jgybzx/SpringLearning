package com.jgybzx.controller;

import com.jgybzx.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * @author: guojy
 * @date: 2019/12/30 12:18
 * @Description: ${TODO}
 * @version:
 */
@Controller
public class Mycontroller {
    @RequestMapping("/test")
    public String test() {

        return "forward:/WEB-INF/pages/success2.jsp";
    }

    //接收数组数据 ，
    @RequestMapping("/array")
    public String demo1(String[] hobby) {
        System.out.println("hobby = " + Arrays.toString(hobby));
        return "forward:/WEB-INF/pages/success2.jsp";
    }

    //接收对象及日期
    @RequestMapping("/date")
    public String demo2(User user, @RequestParam("birthday") Date bir) {
        System.out.println("user = " + user);
        System.out.println("date = " + bir);
        return "success";
    }

    //响应方式1：返回值为String，
    @RequestMapping("demo3")
    public String demo3() {

        return "success";
    }

    //响应方式2：返回值为String,请求 转发，
    @RequestMapping("demo4")
    public String demo4(HttpServletRequest request) {
        request.setAttribute("msg", "响应方式1：返回值为String,请求 转发");

        return "forward:/WEB-INF/pages/success.jsp";
    }

    //响应方式3：返回值为String，重定向
    @RequestMapping("demo5")
    public String demo5(HttpServletRequest request) {
        request.setAttribute("msg", "响应方式3：返回值为String，重定向");

        return "redirect:/success2.jsp";
    }

    //响应方式4：返回值void，请求转发，使用原生request对象
    @RequestMapping("demo6")
    public void demo6(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "响应方式4：返回值void，请求转发，使用原生request对象");
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
    }

    //响应方式5：返回值void，重定向，使用原生 response 对象
    @RequestMapping("demo7")
    public void demo7(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "响应方式5：返回值void，重定向，使用原生 response 对象");
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        response.sendRedirect("success2.jsp");
    }

    //响应方式6：返回值ModelAndView，addObject,设置数据，物理视图，请求转发
    @RequestMapping("demo8")
    public ModelAndView demo8() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "响应方式6：返回值ModelAndView，addObject,设置数据，物理视图，请求转发");
        mv.setViewName("forward:/WEB-INF/pages/success.jsp");
        return mv;
    }

    //响应方式7：返回值ModelAndView，addObject,设置数据，物理视图，重定向
    //数据不会丢失，在地址栏上显示
    @RequestMapping("demo9")
    public ModelAndView demo9() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "数据未丢失");
        mv.setViewName("redirect:/success2.jsp");
        return mv;
    }

    //异常演示
    @RequestMapping("/error")
    public String demo10() {
        int i = 1 / 0;
        return "success";
    }

}

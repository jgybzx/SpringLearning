package com.jgybzx.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: guojy
 * @date: 2019/12/30 16:05
 * @Description: ${TODO}
 * @version:
 */
@Component
public class MyException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //使用 ModelAndView 进行响应数据跳转页面，并且  跳转到错误提示页面
        ModelAndView mv = new ModelAndView();

        if (ex instanceof NullPointerException) {
            //模拟：根据不同的异常信息，返回错误码
            mv.addObject("msg", "1001");
        } else if (ex instanceof IndexOutOfBoundsException) {
            mv.addObject("msg", "1002");
        }

        //mv.addObject("msg", ex.getMessage());
        mv.setViewName("forward:/error.jsp");
        return mv;

    }
}

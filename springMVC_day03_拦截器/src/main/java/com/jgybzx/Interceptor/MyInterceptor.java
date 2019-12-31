package com.jgybzx.Interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: guojy
 * @date: 2019/12/31 14:07
 * @Description: ${TODO}
 * @version:
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("拦截器1  preHandle  执行");

        //取出session中的 信息
        String login = (String) request.getSession().getAttribute("login");
        if (StringUtils.isEmpty(login)) {
            //如果session中没有对象，跳转到其他页面
            response.sendRedirect("/error.jsp");
            return false;
        } else {
            //如果有数据，直接放行
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("拦截器1  postHandle  执行");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("拦截器1  afterCompletion  执行");

    }
}

package com.jgybzx.ProxyBean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: guojy
 * @date: 2019/12/26 12:19
 * @Description:
 * @version:
 */
@Component
public class PeopleProxy {
    @Before("execution(* com.jgybzx.TargetBean.*.*(..))")
    public void before() {
        System.out.println("PeopleProxy 的 前置方法");
    }

    @After("execution(* com.jgybzx.TargetBean.*.*(..))")
    public void after() {
        System.out.println("PeopleProxy 的 最终方法");
    }

    @AfterReturning("execution(* com.jgybzx.TargetBean.*.*(..))")
    public void afterReturning() {
        System.out.println("PeopleProxy 的 后置方法");
    }

    @AfterThrowing("execution(* com.jgybzx.TargetBean.*.*(..))")
    public void afterThrowing() {
        System.out.println("PeopleProxy 的 异常方法");
    }
    @Around("execution(* com.jgybzx.TargetBean.*.*(..))")
    public void around(ProceedingJoinPoint pjp) {
        System.out.println("PeopleProxy 的 环绕方法");
        try {
            System.out.println("前置");
            //表示放行
            pjp.proceed();

            System.out.println("后置");
        } catch (Exception e) {
            System.out.println("异常");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            System.out.println("最终");
        }
    }
}

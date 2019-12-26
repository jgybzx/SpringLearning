package com.jgybzx.Cglib;

/**
 * @author: guojy
 * @date: 2019/12/26 11:54
 * @Description:
 * @version:
 */

import com.jgybzx.Impl.ServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 基于类实现代理，跟jdk不一样 jdk是对接口代理
 * jdk 动态代理，返回的是一个接口类型的代理实现类
 * cglib 基于类，那也要跟被代理的类一致才行，所以使用的继承的思想
 * enhancer.setSuperclass(); 告诉增强类，被代理的类是哪个
 */
public class TestDemo {
    public static void main(String[] args) {
        ServiceImpl serviceImpl = new ServiceImpl();
        //创建 一个增强器
        Enhancer enhancer = new Enhancer();
        //告诉增强器 要增强哪个类

        enhancer.setSuperclass(ServiceImpl.class);

        //开始增强，作用等同于  动态代理的 invoke
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object obj = null;
                System.out.println("cglib开始执行");
                if (method.getName().equals("print")) {
                    //System.out.println("拦截成功，不予放行");
                    //直接return  null，表示拦截不再执行 被代理类的方法
                    //return null;
                }
                obj = method.invoke(serviceImpl, objects);
                return obj;
            }
        });

        //创建代理对象
        ServiceImpl ServiceImplproxy = (ServiceImpl)enhancer.create();
        ServiceImplproxy.print();
    }
}

package com.jgybzx.JdkProxy;

import com.jgybzx.Impl.ServiceImpl;
import com.jgybzx.Service;
import org.springframework.test.context.ContextConfiguration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: guojy
 * @date: 2019/12/26 11:45
 * @Description:
 * @version:
 */
public class TestDemo {
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        Service serviceProxy = (Service) Proxy.newProxyInstance(Service.class.getClassLoader(),
                service.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object obj = null;
                        System.out.println("动态代理执行");
                        obj = method.invoke(service, args);
                        return obj;
                    }
                });
        serviceProxy.print();
    }
}

package com.jgybzx.AOP;

import com.jgybzx.Utils.MytransferManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author: guojy
 * @date: 2019/12/26 17:52
 * @Description:
 * @version:
 */
//增强事务管理的类，在所有的service层的方法种  进行增强
@Component
@Aspect
public class AopMytransferManager {
    @Autowired
    private MytransferManager mytransferManager;
    @Around("execution(* com.jgybzx.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws SQLException {
        Object object = null;
        try {
            //前置 开启事务
            mytransferManager.openTransfer();
            System.out.println("开启事务");
            //放行
            object  = pjp.proceed();
            //后置 提交事务
            mytransferManager.commitAndClose();
            System.out.println(object);
            System.out.println("提交事务");
        } catch (Exception e) {
            //异常通知，回滚
            mytransferManager.roolbackAndClose();
            System.out.println("出现异常，回滚");
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            //最终 释放资源
        }
        return object;
    }
}

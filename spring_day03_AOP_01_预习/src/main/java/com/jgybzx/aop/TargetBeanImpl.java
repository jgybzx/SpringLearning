package com.jgybzx.aop;

/**
 * @author: guojy
 * @date: 2019/12/26 10:30
 * @Description:
 * @version:
 */
public class TargetBeanImpl implements  TargetBean {
    @Override
    public void test() {
        System.out.println("实现类方法执行");

    }
}

package com.jgybzx.Test;

import org.junit.Test;

/**
 * @author: guojy
 * @date: 2019/12/25 17:27
 * @Description:
 * @version:
 */
public class TestDemo2 {


    public static void main(String[] args) {
        //案例演示
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("线程1的值");
        new Thread(new Runnable() {
            @Override
            public void run() {
                String s = threadLocal.get();
                System.out.println("线程2取值=====" + s);
            }
        }).start();
        String s1 = threadLocal.get();
        System.out.println("线程1取值=====" + s1);
    }

}

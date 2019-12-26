package com.jgybzx.TargetBean;

/**
 * @author: guojy
 * @date: 2019/12/26 12:16
 * @Description:
 * @version:
 */
public class Peoplempl implements People {
    @Override
    public void run() {
        System.out.println("Peoplempl run方法");
    }

    @Override
    public void eat() {
        System.out.println("Peoplempl eat方法");

    }

    @Override
    public void sleep() {
        System.out.println("Peoplempl sleep方法");

    }
}

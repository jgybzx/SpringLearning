package com.jgybzx.Test;


import com.jgybzx.TargetBean.People;

import com.jgybzx.TargetBean.Peoplempl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: guojy
 * @date: 2019/12/25 20:53
 * @Description:
 * @version:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestDemo {
    @Autowired
    private People people;
    @Test
    public void test (){

        people.eat();
    }
}

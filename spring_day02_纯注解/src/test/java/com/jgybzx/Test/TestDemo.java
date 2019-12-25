package com.jgybzx.Test;

import com.jgybzx.config.Myconfig;
import com.jgybzx.domain.Account;
import com.jgybzx.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: guojy
 * @date: 2019/12/24 16:06
 * @Description:
 * @version:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Myconfig.class)
public class TestDemo {

    @Autowired
    private  AccountService accountService;
    @Test
    public void findAll() {
        /*ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:applicationContext*");
        AccountService accountService = (AccountService) ac.getBean("accountService");*/
        accountService.findAll();
    }
    @Test
    public void insert() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:applicationContext*");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("xml的物理位置");
        //AnnotationConfigApplicationContext 加载配置类
        ApplicationContext ac = new AnnotationConfigApplicationContext(Myconfig.class);
        AccountService accountService = (AccountService) ac.getBean("accountService");
        Account account = new Account(null, "jgybzx", 1212D);
        accountService.insert(account);
    }



    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:applicationContext*");
        AccountService accountService = (AccountService) ac.getBean("accountService");
        accountService.print();
    }
}

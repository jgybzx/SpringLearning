package com.jgybzx.Test;

import com.jgybzx.domain.Account;
import com.jgybzx.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author: guojy
 * @date: 2019/12/24 16:06
 * @Description:
 * @version:
 */
public class TestDemo {
    @Test
    public void insert(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:applicationContext*");
        AccountService accountService= (AccountService) ac.getBean("accountService");
        Account account = new Account(null,"jgybzx",1212D);
        accountService.insert(account);
    }
    @Test
    public void findAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:applicationContext*");
        AccountService accountService= (AccountService) ac.getBean("accountService");
        accountService.findAll();
    }

    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:applicationContext*");
        AccountService accountService= (AccountService) ac.getBean("accountService");
        accountService.print();
    }
}

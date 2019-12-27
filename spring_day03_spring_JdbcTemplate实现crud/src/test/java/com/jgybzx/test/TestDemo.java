package com.jgybzx.test;

import com.jgybzx.domain.Account;
import com.jgybzx.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: guojy
 * @date: 2019/12/26 18:28
 * @Description:
 * @version:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestDemo  {
    @Autowired
    private AccountService accountService;
    @Test
    public void save(){
        Account account = new Account(null,"测试",1000D);
        accountService.save(account);
    }
    @Test
    public void update(){
        Account account = new Account(3,"测试修改",1000D);
        accountService.update(account);
    }
    @Test
    public void delete(){
        accountService.delete(3);
    }
    @Test
    public void find(){
        accountService.find();
    }
}

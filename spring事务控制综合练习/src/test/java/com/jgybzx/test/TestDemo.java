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
 * @date: 2019/12/28 14:56
 * @Description:
 * @version:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class TestDemo {
    @Autowired
    private AccountService accountService;
    @Test //转账 xml版
    public void transfer(){
        Account inAccount =  new Account("jack",100D);
        Account outAccount =  new Account("rose",100D);
        accountService.transfer(inAccount,outAccount);
    }
    @Test //转账 注解版
    public void transfer2(){
        Account inAccount =  new Account("jack",100D);
        Account outAccount =  new Account("rose",100D);
        accountService.transfer2(inAccount,outAccount);
    }
}

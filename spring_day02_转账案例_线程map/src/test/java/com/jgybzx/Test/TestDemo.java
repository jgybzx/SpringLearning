package com.jgybzx.Test;

import com.jgybzx.domain.Account;
import com.jgybzx.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

/**
 * @author: guojy
 * @date: 2019/12/24 16:06
 * @Description:
 * @version:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestDemo {
    @Autowired
    private AccountService accountService;
    @Test //transfer accounts
    //普通事务
    public void transfer() throws SQLException {
        //jack 收到100
        Account inAccount = new Account(1,"jack",100D);
        //rose 转出100
        Account outAccount = new Account(2,"rose",100D);
        accountService.transfer(inAccount,outAccount);
    }

    @Test //transfer accounts
    //由于普通事务，connection出现在了service层，这不合理，所以把关于事务的操作抽取 出来
    public void transferUtils() throws SQLException {
        //jack 收到100
        Account inAccount = new Account(1,"jack",100D);
        //rose 转出100
        Account outAccount = new Account(2,"rose",100D);
        accountService.transferUtils(inAccount,outAccount);
    }
}

package com.jgybzx.Test;

import com.jgybzx.config.MyConfig;
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
@ContextConfiguration(classes = MyConfig.class)
public class TestDemo {
    @Autowired
    private AccountService accountService;
    @Test
    public void transfer() throws SQLException {
        Account inAccount = new Account("jack",100D);//+100
        Account OutAccount = new Account("rose",100D);//-100

        accountService.transfer(inAccount,OutAccount);
    }
}

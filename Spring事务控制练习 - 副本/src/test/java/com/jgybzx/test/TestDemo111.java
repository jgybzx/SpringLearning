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
 * @date: 2019/12/27 17:23
 * @Description:
 * @version:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestDemo111 {

    @Autowired
    private AccountService accountService;

    @Test
    public void transfer1() {
        Account inaccount = new Account();
        inaccount.setName("jack");
        inaccount.setMoney(100D);
        Account outaccount = new Account();
        outaccount.setName("rose");
        outaccount.setMoney(100D);
        accountService.transfer(inaccount, outaccount);
    }
}

package com.jgybzx.service.impl;

import com.jgybzx.dao.AccountDao;
import com.jgybzx.domain.Account;
import com.jgybzx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: guojy
 * @date: 2019/12/24 16:05
 * @Description:
 * @version:
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    //@Autowired
    //@Qualifier("id随便写")
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    public void insert(Account account) {
        //调用dao层
        accountDao.insert(account);
    }

    @Override
    public void findAll() {
        accountDao.findAll();
    }

    @Override
    public void print() {
        System.out.println("Service 打印");
        accountDao.print();
    }

}

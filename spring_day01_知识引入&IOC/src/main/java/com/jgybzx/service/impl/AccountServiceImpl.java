package com.jgybzx.service.impl;

import com.jgybzx.dao.AccountDao;
import com.jgybzx.domain.Account;
import com.jgybzx.service.AccountService;

/**
 * @author: guojy
 * @date: 2019/12/24 16:05
 * @Description:
 * @version:
 */
public class AccountServiceImpl implements AccountService {
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

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}

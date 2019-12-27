package com.jgybzx.service.impl;

import com.jgybzx.dao.AccountDao;
import com.jgybzx.domain.Account;
import com.jgybzx.service.AccountService;

import java.sql.SQLException;

/**
 * @author: guojy
 * @date: 2019/12/27 13:19
 * @Description:
 * @version:
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    @Override
    public void transfer(Account inAccount, Account outAccount) throws SQLException {
        accountDao.out(outAccount);
        int id=1/0;
        accountDao.in(inAccount);
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}

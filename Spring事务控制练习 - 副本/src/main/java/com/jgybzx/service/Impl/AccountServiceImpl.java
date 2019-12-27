package com.jgybzx.service.Impl;

import com.jgybzx.dao.AccountDao;
import com.jgybzx.domain.Account;
import com.jgybzx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: guojy
 * @date: 2019/12/27 17:24
 * @Description:
 * @version:
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,timeout = -1,isolation = Isolation.DEFAULT,readOnly = false)
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public void transfer(Account inaccout, Account outaccount) {
        accountDao.in(inaccout);
        int i  = 1/0;
        accountDao.out(outaccount);
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}

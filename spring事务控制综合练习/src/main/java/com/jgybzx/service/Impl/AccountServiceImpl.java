package com.jgybzx.service.Impl;

import com.jgybzx.dao.AccountDao;
import com.jgybzx.domain.Account;
import com.jgybzx.service.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: guojy
 * @date: 2019/12/28 14:53
 * @Description:
 * @version:
 */

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public void transfer(Account inAccount, Account outAccount) {
        accountDao.in(inAccount);
        accountDao.out(outAccount);
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,timeout = -1,propagation = Propagation.REQUIRED,readOnly = false)
    public void transfer2(Account inAccount, Account outAccount) {
        accountDao.in(inAccount);
        int i =1 / 0;
        accountDao.out(outAccount);
    }

}

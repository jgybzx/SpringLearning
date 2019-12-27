package com.jgybzx.service.impl;

import com.jgybzx.dao.AccountDao;
import com.jgybzx.domain.Account;
import com.jgybzx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * @author: guojy
 * @date: 2019/12/27 13:19
 * @Description:
 * @version:
 */
@Service
@Transactional(propagation = Propagation.REQUIRED , readOnly = false)
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public void transfer(Account inAccount, Account outAccount) throws SQLException {
        accountDao.out(outAccount);
        int id=1/0;
        accountDao.in(inAccount);
    }
    @Transactional(propagation = Propagation.REQUIRED , readOnly = true)
    public  void find(){

    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}

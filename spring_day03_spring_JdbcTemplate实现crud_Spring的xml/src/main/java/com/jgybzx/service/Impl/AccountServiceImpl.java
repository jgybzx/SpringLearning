package com.jgybzx.service.Impl;

import com.jgybzx.dao.AccountDao;
import com.jgybzx.domain.Account;
import com.jgybzx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: guojy
 * @date: 2019/12/26 18:27
 * @Description:
 * @version:
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public void delete(Integer id) {
        accountDao.delete(id);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public void find() {
        accountDao.find();
    }

    @Override
    public void batchSave(List<Account> list) {
        accountDao.batchSave(list);
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}

package com.jgybzx.service.Impl;

import com.jgybzx.dao.AccountDao;
import com.jgybzx.domain.Account;
import com.jgybzx.service.AccountService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: guojy
 * @date: 2019/12/23 20:08
 * @Description:
 * @version:
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    //保存数据
    public void save(Account account) {
        accountDao.save(account);
    }

    public void update(Account account) {
        accountDao.update(account);

    }

    public void delete(Integer id) {

        accountDao.delete(id);

    }

    public List<Account> findall() {
        List<Account> list = null;
        list=accountDao.findall();
        return list;
    }

    public Account findById(Integer id) {
        return accountDao.findById(id);
    }


}

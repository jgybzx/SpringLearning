package com.jgybzx.service;

import com.jgybzx.domain.Account;

/**
 * @author: guojy
 * @date: 2019/12/28 14:52
 * @Description:
 * @version:
 */
public interface AccountService {
    void transfer(Account inAccount, Account outAccount);

    void transfer2(Account inAccount, Account outAccount);
}

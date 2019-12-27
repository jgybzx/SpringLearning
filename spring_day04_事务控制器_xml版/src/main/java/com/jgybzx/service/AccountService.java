package com.jgybzx.service;

import com.jgybzx.domain.Account;

import java.sql.SQLException;

/**
 * @author: guojy
 * @date: 2019/12/24 16:05
 * @Description:
 * @version:
 */
public interface AccountService {
    void transfer(Account inAccount, Account outAccount) throws SQLException;

}

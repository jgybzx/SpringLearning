package com.jgybzx.dao;

import com.jgybzx.domain.Account;

import java.sql.Connection;

/**
 * @author: guojy
 * @date: 2019/12/24 16:04
 * @Description:
 * @version:
 */
public interface AccountDao {


    void outAccount(Account outAccount, Connection connection);

    void inAccount(Account inAccount,Connection connection);

    void outAccountByMap(Account outAccount);

    void inAccountByMap(Account inAccount);
}

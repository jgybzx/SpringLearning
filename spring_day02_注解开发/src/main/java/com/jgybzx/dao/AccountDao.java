package com.jgybzx.dao;

import com.jgybzx.domain.Account;

/**
 * @author: guojy
 * @date: 2019/12/24 16:04
 * @Description:
 * @version:
 */
public interface AccountDao {
    void insert(Account account);

    void findAll();

    void print();
}

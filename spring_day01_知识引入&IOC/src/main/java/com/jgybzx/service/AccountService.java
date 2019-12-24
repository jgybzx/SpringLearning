package com.jgybzx.service;

import com.jgybzx.domain.Account;

/**
 * @author: guojy
 * @date: 2019/12/24 16:05
 * @Description:
 * @version:
 */
public interface AccountService {
    void insert(Account account);

    void findAll();
}

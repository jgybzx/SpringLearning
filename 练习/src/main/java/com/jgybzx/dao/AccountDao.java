package com.jgybzx.dao;

import com.jgybzx.domain.Account;

import java.util.List;

/**
 * @author: guojy
 * @date: 2019/12/23 20:03
 * @Description:
 * @version:
 */
public interface AccountDao {
    void save(Account account);

    void update(Account account);

    void delete(Integer id);

    List<Account> findall();

    Account findById(Integer id);
}

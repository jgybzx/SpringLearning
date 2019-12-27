package com.jgybzx.dao;

import com.jgybzx.domain.Account;

/**
 * @author: guojy
 * @date: 2019/12/26 18:25
 * @Description:
 * @version:
 */
public interface AccountDao {
    public void save(Account account);
    public void delete(Integer id);
    public void update(Account account);
    public void find();
}

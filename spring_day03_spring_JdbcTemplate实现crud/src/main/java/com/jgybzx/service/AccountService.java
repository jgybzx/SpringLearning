package com.jgybzx.service;

import com.jgybzx.domain.Account;

/**
 * @author: guojy
 * @date: 2019/12/26 18:24
 * @Description:
 * @version:
 */
public interface AccountService {
    public void save(Account account);
    public void delete(Integer id);
    public void update(Account account);
    public void find();
}

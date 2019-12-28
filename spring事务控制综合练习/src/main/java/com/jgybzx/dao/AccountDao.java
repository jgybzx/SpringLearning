package com.jgybzx.dao;

import com.jgybzx.domain.Account;

/**
 * @author: guojy
 * @date: 2019/12/28 15:03
 * @Description:
 * @version:
 */
public interface AccountDao {
    void out(Account outAccount);

    void in(Account inAccount);
}

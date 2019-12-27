package com.jgybzx.dao;

import com.jgybzx.domain.Account;

/**
 * @author: guojy
 * @date: 2019/12/27 17:20
 * @Description:
 * @version:
 */
public interface AccountDao {
    public void out(Account outaccount);

    public void in(Account inaccount);
}

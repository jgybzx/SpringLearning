package com.jgybzx.dao;

import com.jgybzx.domain.Account;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: guojy
 * @date: 2019/12/24 16:04
 * @Description:
 * @version:
 */
public interface AccountDao {

    void out(Account outAccount) throws SQLException;

    void in(Account inAccount) throws SQLException;
}

package com.jgybzx.service.impl;

import com.jgybzx.Utils.MytransferManager;
import com.jgybzx.dao.AccountDao;
import com.jgybzx.domain.Account;
import com.jgybzx.service.AccountService;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: guojy
 * @date: 2019/12/24 16:05
 * @Description:
 * @version:
 */
@Repository
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public void transfer(Account inAccount, Account outAccount) throws SQLException {

        //业务功能代码
        accountDao.out(outAccount);//转出
        //int i = 1/0;
        accountDao.in(inAccount);//转入
    }
}

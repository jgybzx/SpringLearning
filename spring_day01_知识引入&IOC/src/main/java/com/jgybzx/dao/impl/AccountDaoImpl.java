package com.jgybzx.dao.impl;

import com.jgybzx.dao.AccountDao;
import com.jgybzx.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: guojy
 * @date: 2019/12/24 16:04
 * @Description:
 * @version:
 */
public class AccountDaoImpl implements AccountDao {
    private QueryRunner queryRunner;
    @Override
    public void insert(Account account) {
        String sql = "insert into account  values(?,?,?)";
        Object[] params = {account.getId(),account.getName(),account.getMoney()};
        try {
            int update = queryRunner.update(sql, params);
            System.out.println("update = " + update);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findAll() {
        String sql = "select * from account";
        try {
            List<Account> query = queryRunner.query(sql, new BeanListHandler<Account>(Account.class));
            System.out.println("query = " + query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }
}

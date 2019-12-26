package com.jgybzx.dao.impl;

import com.jgybzx.Utils.MytransferManager;
import com.jgybzx.dao.AccountDao;
import com.jgybzx.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;

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

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public void outAccount(Account outAccount,Connection connection) {
        String sql = "update account set money =money - 100 where id = ?";
        Object[] params ={outAccount.getId()};
        try {
            queryRunner.update(connection,sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inAccount(Account inAccount,Connection connection) {
        String sql = "update account set money= money+ 100 where id = ?";
        Object[] params ={inAccount.getId()};
        try {
            queryRunner.update(connection,sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Autowired //Map 已经在事务管理器中存在，所以，直接注入，并且事务管理器提供一个返回connection的方法即可
    private MytransferManager mytransferManager;

    @Override
    public void outAccountByMap(Account outAccount) {
        Connection connection = mytransferManager.getConnection();
        String sql = "update account set money =money - 100 where id = ?";
        Object[] params ={outAccount.getId()};
        //从线程Map中获取  connection
        try {
            queryRunner.update(connection,sql,params);
            System.out.println("减少100");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inAccountByMap(Account inAccount) {
        Connection connection = mytransferManager.getConnection();
        String sql = "update account set money =money + 100 where id = ?";
        Object[] params ={inAccount.getId()};
        //从线程Map中获取  connection
        try {
            System.out.println("增加100");
            queryRunner.update(connection,sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setMytransferManager(MytransferManager mytransferManager) {
        this.mytransferManager = mytransferManager;
    }
}

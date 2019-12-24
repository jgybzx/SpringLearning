package com.jgybzx.dao.Impl;

import com.jgybzx.dao.AccountDao;
import com.jgybzx.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: guojy
 * @date: 2019/12/23 20:09
 * @Description:
 * @version:
 */

/**
 * DbUtils是Apache的一款用于简化Dao代码的工具类，它底层封装了JDBC技术。
 * 核心类：
 * QueryRunner 用于执行增删改查的SQL语句
 * ResultSetHandler 这是一个接口，主要作用是将数据库返回的记录封装进实体对象
 * 核心方法：
 * update() 用来执行增、删、改语句
 * query() 用来执行查询语句
 * <dependency>
 * <groupId>commons-dbutils</groupId>
 * <artifactId>commons-dbutils</artifactId>
 * <version>1.7</version>
 * </dependency>
 */
public class AccountDaoImpl implements AccountDao {
    //数据源对象
    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public void save(Account account) {
        //准备sql语句
        String sql = "insert into account values(?,?,?)";
        Object[] params = {account.getId(), account.getName(), account.getMoney()};
        try {
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Account account) {
        //准备sql语句
        String sql = "update account set name = ?,money = ? where id = ?";
        Object[] params = {account.getName(), account.getMoney(), account.getId()};
        try {
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {

        //准备sql语句
        String sql = "delete from account where id = ?";
        Object[] params = {id};
        try {
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Account> findall() {
        List<Account> query = null;
        //准备sql语句
        String sql = "select * from account ";
        try {
            query = queryRunner.query(sql, new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public Account findById(Integer id) {
//        ResultSetHandler
        Account account = null;

        //准备sql语句
        String sql = "select * from account ";
        try {
            account = queryRunner.query(sql, new BeanHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}

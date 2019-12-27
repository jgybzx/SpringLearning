package com.jgybzx.dao.Impl;

import com.jgybzx.dao.AccountDao;
import com.jgybzx.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * @author: guojy
 * @date: 2019/12/27 13:20
 * @Description:
 * @version:
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void out(Account outAccount) throws SQLException {
        String sql = "update account set money = money - ? where  name = ?";
        Object[] params ={outAccount.getMoney(),outAccount.getName()};
        int  count = jdbcTemplate.update(sql,params);
        System.out.println(count);
    }

    @Override
    public void in(Account inAccount) throws SQLException {
        String sql = "update account set money = money + ? where  name = ?";
        Object[] params ={inAccount.getMoney(),inAccount.getName()};
        int  count = jdbcTemplate.update(sql,params);
        System.out.println(count);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

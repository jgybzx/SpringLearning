package com.jgybzx.dao.impl;

import com.jgybzx.dao.AccountDao;
import com.jgybzx.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author: guojy
 * @date: 2019/12/27 17:23
 * @Description:
 * @version:
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void out(Account outaccount) {
        String sql = "update account set money= money - ? where name = ?";
        Object[] params ={outaccount.getMoney(),outaccount.getName()};
        jdbcTemplate.update(sql,params);

    }

    @Override
    public void in(Account inaccount) {
        String sql = "update account set money= money + ? where name = ?";
        Object[] params ={inaccount.getMoney(),inaccount.getName()};
        jdbcTemplate.update(sql,params);

    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

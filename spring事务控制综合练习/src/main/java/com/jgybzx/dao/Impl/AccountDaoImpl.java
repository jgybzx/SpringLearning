package com.jgybzx.dao.Impl;

import com.jgybzx.dao.AccountDao;
import com.jgybzx.domain.Account;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author: guojy
 * @date: 2019/12/28 15:03
 * @Description:
 * @version:
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void out(Account outAccount) {
        String sql = "update account set money = money - ? where name = ?";
        Object[] params = {outAccount.getMoney(),outAccount.getName()};
        jdbcTemplate.update(sql,params);
    }

    @Override
    public void in(Account inAccount) {

        String sql = "update account set money = money + ? where name = ?";
        Object[] params = {inAccount.getMoney(),inAccount.getName()};
        jdbcTemplate.update(sql,params);
    }

}

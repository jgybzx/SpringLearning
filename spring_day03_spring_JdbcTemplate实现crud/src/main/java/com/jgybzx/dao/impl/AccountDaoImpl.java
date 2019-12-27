package com.jgybzx.dao.impl;

import com.jgybzx.Utils.DruidUtils;
import com.jgybzx.dao.AccountDao;
import com.jgybzx.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author: guojy
 * @date: 2019/12/26 18:26
 * @Description:
 * @version:
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public void save(Account account) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "insert into account values(?,?,?)";
        Object[] params = {account.getId(),account.getName(),account.getMoney()};
        jdbcTemplate.update(sql,params);
    }

    @Override
    public void delete(Integer id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "delete from account where id = ?";
        Object[] params = {id};
        jdbcTemplate.update(sql,params);
    }

    @Override
    public void update(Account account) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "update  account set  name = ? where id = ?";
        Object[] params = {account.getName(),account.getId()};
        jdbcTemplate.update(sql,params);
    }

    @Override
    public void find() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "select * from account";
        //3.查询
        /**
         * RowMapper 行映射(将数据库的数据映射到实体类的属性)
         * BeanPropertyRowMapper :  实体类的属性(实体类对象) 行映射(数据库数据)
         * 自动封装 如果数据库的名称和实体类的不对应(字段名称和实体类属性的名称不一致)必然需要手动封装
         */
        List<Account> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Account.class));
        System.out.println(query);
    }
}

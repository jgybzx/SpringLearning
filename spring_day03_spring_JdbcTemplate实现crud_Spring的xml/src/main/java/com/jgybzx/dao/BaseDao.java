package com.jgybzx.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author: guojy
 * @date: 2019/12/26 20:03
 * @Description:
 * @version:
 */
public class BaseDao {
    //将对象注入到 IOC中
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

package com.jgybzx.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author: guojy
 * @date: 2019/12/26 17:21
 * @Description:
 * @version:
 */
@PropertySource("db.properties")
public class DaoConfig {
    //获得 数据源  QueryRunner

    @Bean("queryRunner")
    public QueryRunner creatRueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Value("${jdbc.driver}")
    private String dirve;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource")
    private DataSource creatDataSoucre() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(dirve);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}

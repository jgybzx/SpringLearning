package com.jgybzx.Utils;


import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;

/**
 * 对外提供数据源方法
 */
public class DruidUtils {

    private static DruidDataSource dataSource = null;
    static {
        //创建数据源
        dataSource = new DruidDataSource();
        //基本四项
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring");
        dataSource.setUsername("root");
        dataSource.setPassword("jgybzx");
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
}

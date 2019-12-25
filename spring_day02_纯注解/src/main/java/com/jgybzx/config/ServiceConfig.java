package com.jgybzx.config;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author: guojy
 * @date: 2019/12/25 15:20
 * @Description:
 * @version:
 */
public class ServiceConfig {
    /**
     * 第三方的类无法添加注解，我们直接new，比如 QueryRunner，
     * 同时需要将对象放入容器，提供一个建立对象的方法 使用Bean注解
     *
     * @Baen 该注解只能写在方法上，表明使用此方法创建一个对象，并且放入 spring 容器。
     * 它支持一个name属性，用于其给生成的bean取一个id。
     */
    @Bean(name = "queryRunner") //自己实例化对象放入class,并取名
    //由于需要一个数据源，所以将数据源当作参数传入方法中，构建一个 QueryRunner
    //参数会自动从容器中获得并，并自动注入，只有spring5以上才可以自动注入
    //spring4 以下必须使用 @Qualifier,指定哪个对象
    public QueryRunner CreateQueryRunner(@Qualifier("dataSource") DataSource dataSource) {
        //new 一个QueryRunner 但是需要数据源
        QueryRunner queryRunner = new QueryRunner(dataSource);
        return queryRunner;
    }
}

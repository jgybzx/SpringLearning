package com.jgybzx.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import javax.xml.ws.Service;

/**
 * @author: guojy
 * @date: 2019/12/24 20:53
 * @Description:
 * @version:
 */
@Configuration //声明  配置类 替代xml存在
@ComponentScan(value = "com.jgybzx")//开启 注解扫描
@PropertySource("jdbc.properties")
@Import({DaoConfig.class, ServiceConfig.class})
public class Myconfig {



}

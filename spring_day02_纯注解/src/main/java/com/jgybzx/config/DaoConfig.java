package com.jgybzx.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author: guojy
 * @date: 2019/12/25 15:20
 * @Description:
 * @version:
 */
//所有关于dao的配置
@PropertySource("jdbc.properties")
public class DaoConfig {
    /**
     * <context:property-placeholder location="jdbc.properties"/>
     * <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
     * <property name="driverClassName" value="com."/>
     * <property name="url" value="${jdbc.url}"/>
     * <property name="username" value="${jdbc.username}"/>
     * <property name="password" value="${jdbc.password}"/>
     * </bean>
     */

    //在xml文件中可以使用 <context:property-placeholder>来引入数据库连接的配置文件
    //那么配置类，也可以引入配置文件，使用 @PropertySource("jdbc.properties")
    //配合@Value使用，使用el表达式，为属性注入值
    @Value("${jdbc.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    //配置数据源,并指定在容器中的名字
    @Bean(name = "dataSource")
    public DataSource createDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}

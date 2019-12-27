package com.jgybzx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * @author: guojy
 * @date: 2019/12/26 17:16
 * @Description:
 * @version:
 */
//配置类，代替XMl
@Configuration  //声明这是一个配置类
@ComponentScan("com.jgybzx") //开启注解扫描
@Import(DaoConfig.class) //引入其他的配置类
@EnableAspectJAutoProxy//开启注解AOP
public class MyConfig {

}

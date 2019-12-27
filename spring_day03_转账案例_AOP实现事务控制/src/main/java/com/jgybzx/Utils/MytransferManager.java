package com.jgybzx.Utils;

/**
 * @author: guojy
 * @date: 2019/12/25 16:44
 * @Description: 事务管理
 * @version:
 */

import org.apache.commons.dbutils.DbUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 将 获取连接 以及开启事务，抽取出来
 * 核心目的，控制事务
 * 提供方法：
 *      获得连接，开启事务
 *      提交事务并关闭连接
 *      回滚事务，关闭连接
 * 必须需要 一个数据源
 */
//配置文件 中将该类加入容器
@Component
public class MytransferManager {
    @Autowired
    private DataSource dataSource;
    //由于出现线程安全问题，所以此时不能只出现一个connection，使用ThreadLocal
    private ThreadLocal<Connection> local = new ThreadLocal<>();

    /*private Connection connection;*/
    //获得数据源  di注入
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    /**
     * 问题1：线程问题,如果两个人同时拿到了 connection，B的操作可能会对A产生影响
     * 既然是线程会有问题，那么就利用线程解决问题，
     * 每个线程过来，都是自己拿自己的 connection
     * 1、绝对不是一个 connection  ，必须是多个
     * 2、每个线程都不会重复，
     * 3、每个线程id都不会重复，
     * 4、每个线程名字都不会重复
     * 综上，根据key获得 connection ，所以技术选择 线程map，
     * key = 线程名字  value = connection
     * 就能保证 每个线程根据 线程名字取到自己的connection ，
     */
    //开启事务，
    public void openTransfer() throws SQLException {
        Connection connection = dataSource.getConnection();
        //将connection 放入线程Map
        local.set(connection);
        connection.setAutoCommit(false);
    }

    //提交并并关闭
    public void commitAndClose() throws SQLException {
        //从线程Map中获取 connection
        Connection connection = local.get();
        DbUtils.commitAndClose(connection);
        /**
         * 当本次连接使用完之后，要记得将连接从map中移除，要不然会浪费资源，
         * 因为每个线程仅仅只能 用自己的 connection，一旦执行完，connection就再也不会用了
         */
        local.remove();
    }

    //回滚并关闭
    public void roolbackAndClose() throws SQLException {
        //从线程Map中获取 connection
        Connection connection = local.get();
        DbUtils.rollbackAndClose(connection);
        /**
         * 当本次连接使用完之后，要记得将连接从map中移除，要不然会浪费资源，
         * 因为每个线程仅仅只能 用自己的 connection，一旦执行完，connection就再也不会用了
         */
        local.remove();
    }

    /**
     * 对外  提供连接 必须从线程Map中获得
     * @return
     */
    public Connection getConnection() {
        return local.get();
    }
}

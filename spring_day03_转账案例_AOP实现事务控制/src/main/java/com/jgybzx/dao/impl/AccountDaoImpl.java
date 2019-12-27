package com.jgybzx.dao.impl;

import com.jgybzx.Utils.MytransferManager;
import com.jgybzx.dao.AccountDao;
import com.jgybzx.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: guojy
 * @date: 2019/12/24 16:04
 * @Description:
 * @version:
 */
@Service
public class AccountDaoImpl implements AccountDao {

    //dao层需要获得连接，以及使用dbUtils执行sql语句
    //从事务控制管理其中获取链接
    @Autowired
    private MytransferManager mytransferManager;
    @Autowired
    private QueryRunner queryRunner;

    @Override
    public void out(Account outAccount) throws SQLException {
        //转出功能,
        Connection connection = mytransferManager.getConnection();
        String sql = "update account set money = money-? where name=?";
        //参数
        Object[] params = {outAccount.getMoney(), outAccount.getName()};
        //执行
        queryRunner.update(connection, sql, params);
    }

    @Override
    public void in(Account inAccount) throws SQLException {
        //转出功能,
        Connection connection = mytransferManager.getConnection();
        String sql = "update account set money = money+? where name=?";
        //参数
        Object[] params = {inAccount.getMoney(), inAccount.getName()};
        //执行
        queryRunner.update(connection, sql, params);
    }
}

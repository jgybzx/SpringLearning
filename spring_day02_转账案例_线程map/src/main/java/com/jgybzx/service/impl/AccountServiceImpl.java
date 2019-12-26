package com.jgybzx.service.impl;

import com.jgybzx.Utils.MytransferManager;
import com.jgybzx.dao.AccountDao;
import com.jgybzx.domain.Account;
import com.jgybzx.service.AccountService;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: guojy
 * @date: 2019/12/24 16:05
 * @Description:
 * @version:
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    //方便获取数据源
    private DataSource dataSource;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //当转账动作出现异常的时候，应该回滚，要想开启事务手动提交以及回滚，自然需要connection
    @Override
    public void transfer(Account inAccount, Account outAccount) throws SQLException {
        //整个事务，取决于一个 connection，connection来自于数据源 dataSource
        Connection connection = dataSource.getConnection();
        try {
            //开启事务
            connection.setAutoCommit(false);
            //一个connection，相当于一个黑窗口，但是只是在service层获取了连接，并没有传到dao层，
            // dao操作的时候，并没有控制住事务，所以需要将service层获取的连接，传递到dao层
            accountDao.outAccount(outAccount, connection);
            //模拟转账异常，
            int i = 1 / 0;
            accountDao.inAccount(inAccount, connection);

            //如果没有异常，直接提交，DbUtils提供了提交并关闭的方法
            DbUtils.commitAndClose(connection);
        } catch (Exception e) {
            System.out.println("转账异常");

            //有异常 直接回滚
            DbUtils.rollbackAndClose(connection);
        }
    }


    private MytransferManager mytransferManager;

    public void setMytransferManager(MytransferManager mytransferManager) {
        this.mytransferManager = mytransferManager;
    }

    @Override
    public void transferUtils(Account inAccount, Account outAccount) throws SQLException {
        //开启事务
        mytransferManager.openTransfer();
        try {
            //由于已经将connection放入map中，所以，此时不需要传递给dao  connection
            accountDao.outAccountByMap(outAccount);

            //模拟异常
            int  i = 1/0;

            accountDao.inAccountByMap(inAccount);
            //提交并关闭
            mytransferManager.commitAndClose();
        } catch (Exception e) {
            //回滚 并关闭
            System.out.println("转账异常");
            mytransferManager.roolbackAndClose();
        }
    }

}

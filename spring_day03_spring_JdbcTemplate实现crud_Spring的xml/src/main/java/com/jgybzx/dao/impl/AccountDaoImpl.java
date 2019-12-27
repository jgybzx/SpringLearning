package com.jgybzx.dao.impl;

import com.jgybzx.Utils.DruidUtils;
import com.jgybzx.dao.AccountDao;
import com.jgybzx.dao.BaseDao;
import com.jgybzx.domain.Account;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: guojy
 * @date: 2019/12/26 18:26
 * @Description:
 * @version:
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    /**
     * 这句代码的意思是，每次获取一个 JdbcTemplate 对象,问题是，如果有100和Dao，每个都要写这句代码
     * 于是再进行 抽取，将这个  JdbcTemplate  抽取到一个父类中
     * 所有的dao 继承父类，父类提供 set方法，方便注入，提供get方法，方便获取
     *
     * spring 已经提供了该父类  JdbcDaoSupport
     * 并且在内部已经自己进行了 JdbcTemplate 的创建，所以我们只需要在dao中注入数据源即可
     * private JdbcTemplate jdbcTemplate;
     * @param account
     */

    @Override
    public void save(Account account) {
        String sql = "insert into account values(?,?,?)";
        Object[] params = {account.getId(),account.getName(),account.getMoney()};
        getJdbcTemplate().update(sql,params);
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from account where id = ?";
        Object[] params = {id};
        /*jdbcTemplate.update(sql,params);*/
        getJdbcTemplate().update(sql,params);
    }

    @Override
    public void update(Account account) {
        String sql = "update  account set  name = ? where id = ?";
        Object[] params = {account.getName(),account.getId()};
        //jdbcTemplate.update(sql,params);
        getJdbcTemplate().update(sql,params);
    }

    @Override
    public void find() {
        String sql = "select * from account";
        //3.查询
        /**
         * RowMapper 行映射(将数据库的数据映射到实体类的属性)
         * BeanPropertyRowMapper :  实体类的属性(实体类对象) 行映射(数据库数据)
         * 自动封装 如果数据库的名称和实体类的不对应(字段名称和实体类属性的名称不一致)必然需要手动封装
         */
        //List<Account> query = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Account.class));
        //手动封装
        List<Account> query = getJdbcTemplate().query(sql, new RowMapper<Account>() {
            @Override //手动封装
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setName(rs.getString("name"));
                account.setMoney(rs.getDouble("money"));
                return account;
            }
        });
        System.out.println(query);
    }

    @Override
    public void batchSave(List<Account> list) {
        System.out.println("批量插入");
        System.out.println(list);
        String sql = "insert into account values(?,?,?)";

        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                //将每一个数据赋值到 响应的位置上  i 表示遍历的索引
                /**
                 * setInt(1,list.get(i).getId());
                 * 1：表示 第几个参数 即预编译sql语句的第几个 ？
                 * list.get(i).getId()：表示要操作的集合的 对象 的具体的值，get(i) 取出集合的元素
                 */
                System.out.println("为什么不能执行");
                ps.setInt(1,list.get(i).getId());
                //根据表中的字段类型 使用不同的set方法
                ps.setString(2,list.get(i).getName());
                ps.setDouble(3,list.get(i).getMoney());
            }

            @Override
            public int getBatchSize() {
                return 0;
            }
        });

    }

/*    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/
}

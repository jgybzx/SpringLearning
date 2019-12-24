package com.jgybzx.dao.impl;

import com.jgybzx.dao.AccountDao;
import com.jgybzx.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.stereotype.Repository;


//说明在容器中的id
@Repository("id随便写")
public class AccountDaoimpl22 implements AccountDao {
    private QueryRunner queryRunner;
    @Override
    public void insert(Account account) {

    }

    @Override
    public void findAll() {

    }

    @Override
    public void print() {
        System.out.println("AccountDaoimpl22 打印");
    }
}

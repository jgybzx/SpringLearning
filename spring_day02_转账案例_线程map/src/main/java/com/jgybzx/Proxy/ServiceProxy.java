package com.jgybzx.Proxy;

import com.jgybzx.service.AccountService;
import com.jgybzx.service.impl.AccountServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @author: guojy
 * @date: 2019/12/25 18:17
 * @Description:
 * @version:
 */
public class ServiceProxy  {
    private AccountService accountService = new AccountServiceImpl();

}

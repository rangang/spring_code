package com.rg.service.impl;

import com.rg.dao.AccountDao;
import com.rg.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: spring_aop_xml
 * @Author: RG
 * @CreateTime: 2022/10/18 7:23 下午
 * @Description:
 */
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    /**
     *  目标方法（切入点 要进行拦截增强的方法）
     */
    @Override
    public void transfer() {
        System.out.println("转账业务...");
        accountDao.out("tom",100d);
        // int i = 1 / 0;
        accountDao.in("jerry",100d);
    }
}

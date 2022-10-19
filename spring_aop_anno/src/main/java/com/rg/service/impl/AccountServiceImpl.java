package com.rg.service.impl;

import com.rg.dao.AccountDao;
import com.rg.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: spring_aop_anno
 * @Author: RG
 * @CreateTime: 2022/10/19 9:50 上午
 * @Description:
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void transfer() {
        System.out.println("转账业务...");
        accountDao.out("tom",100d);
        int i = 1 / 0;
        accountDao.in("jerry",100d);
    }

}

package com.rg.service.impl;

import com.rg.dao.AccountDao;
import com.rg.service.AccountService;
import com.rg.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: spring_transfer
 * @Author: RG
 * @CreateTime: 2022/10/18 10:01 上午
 * @Description:
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void transfer(String outUser, String inUser, Double money) {

        // 调用转出接口
        accountDao.out(outUser,money);

        // 测试
        int i = 1 / 0;

        // 调用转入接口
        accountDao.in(inUser,money);

    }
}

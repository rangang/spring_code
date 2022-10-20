package com.rg.service.impl;

import com.rg.dao.AccountDao;
import com.rg.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @BelongsProject: spring_transfer_tx
 * @Author: RG
 * @CreateTime: 2022/10/19 7:01 下午
 * @Description:
 */
@Service
@Transactional  // 配置所有事务
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    // @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ,timeout = -1,readOnly = false)
    @Override
    public void transfer(String outUser, String inUser, Double money) {
        accountDao.out(outUser,money);
        // int i = 1 / 0;
        accountDao.in(inUser,money);
    }
}

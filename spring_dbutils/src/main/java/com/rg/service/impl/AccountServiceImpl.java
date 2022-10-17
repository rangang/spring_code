package com.rg.service.impl;

import com.rg.dao.AccountDao;
import com.rg.domain.Account;
import com.rg.service.AccountService;

import java.util.List;

/**
 * @BelongsProject: spring_dbutils
 * @Author: RG
 * @CreateTime: 2022/10/17 2:00 下午
 * @Description:
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public void delete(Integer id) {
        accountDao.delete(id);
    }
}

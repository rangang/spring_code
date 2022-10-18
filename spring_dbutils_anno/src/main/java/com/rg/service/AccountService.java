package com.rg.service;

import com.rg.domain.Account;

import java.util.List;

/**
 * @BelongsProject: spring_dbutils_anno
 * @Author: RG
 * @CreateTime: 2022/10/17 6:56 下午
 * @Description:
 */
public interface AccountService {

    public List<Account> findAll();

    public Account findById(Integer id);

    public void save(Account account);

    public void update(Account account);

    public void delete(Integer id);

}

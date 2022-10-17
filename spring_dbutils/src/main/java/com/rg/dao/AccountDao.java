package com.rg.dao;

import com.rg.domain.Account;

import java.util.List;

/**
 * @BelongsProject: spring_dbutils
 * @Author: RG
 * @CreateTime: 2022/10/17 9:58 上午
 * @Description:
 */
public interface AccountDao {

    public List<Account> findAll();

    public Account findById(Integer id);

    public void save(Account account);

    public void update(Account account);

    public void delete(Integer id);

}

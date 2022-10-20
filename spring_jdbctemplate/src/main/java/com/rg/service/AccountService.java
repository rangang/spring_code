package com.rg.service;

import com.rg.domain.Account;

import java.util.List;

/**
 * @BelongsProject: spring_jdbctemplate
 * @Author: RG
 * @CreateTime: 2022/10/19 4:58 下午
 * @Description:
 */
public interface AccountService {

    /**
     * 查询所有账户
     * @return
     */
    public List<Account> findAll();

    /**
     * 根据ID查询账户
     * @param id
     * @return
     */
    public Account findById(Integer id);

    /**
     * 添加账户
     * @param account
     */
    public void save(Account account);

    /**
     * 修改账户
     * @param account
     */
    public void update(Account account);

    /**
     * 根据ID删除账户
     * @param id
     */
    public void delete(Integer id);

}

package com.rg.dao.impl;

import com.rg.dao.AccountDao;
import com.rg.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @BelongsProject: spring_jdbctemplate
 * @Author: RG
 * @CreateTime: 2022/10/19 4:47 下午
 * @Description:
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询所有账户
     * @return
     */
    @Override
    public List<Account> findAll() {
        // 编写sql
        String sql = "select * from account";
        // 执行sql
        List<Account> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));

        return list;
    }

    /**
     * 根据ID查询账户
     * @param id
     * @return
     */
    @Override
    public Account findById(Integer id) {
        // 编写sql
        String sql = "select * from account where id = ?";
        // 执行sql
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class),id);
        return account;
    }

    /**
     * 添加账户
     * @param account
     */
    @Override
    public void save(Account account) {
        // 编写sql
        String sql = "insert into account values(null, ?, ?)";
        // 执行sql
        jdbcTemplate.update(sql,account.getName(),account.getMoney());
    }

    @Override
    public void update(Account account) {
        // 编写sql
        String sql = "update account set name = ?, money = ? where id = ?";
        // 执行sql
        jdbcTemplate.update(sql,account.getName(),account.getMoney(),account.getId());
    }

    /**
     * 根据ID删除账户
     * @param id
     */
    @Override
    public void delete(Integer id) {
        // 编写sql
        String sql = "delete from account where id = ?";
        // 执行sql
        jdbcTemplate.update(sql,id);
    }
}

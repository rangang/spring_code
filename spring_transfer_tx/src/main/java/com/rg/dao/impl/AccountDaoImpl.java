package com.rg.dao.impl;

import com.rg.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: spring_transfer_tx
 * @Author: RG
 * @CreateTime: 2022/10/19 6:57 下午
 * @Description:
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void out(String outUser, Double money) {
        // 编写sql
        String sql = "update account set money = money - ? where name = ?";
        // 执行sql
        jdbcTemplate.update(sql,money,outUser);
    }

    @Override
    public void in(String inUser, Double money) {
        // 编写sql
        String sql = "update account set money = money + ? where name = ?";
        // 执行sql
        jdbcTemplate.update(sql,money,inUser);
    }
}

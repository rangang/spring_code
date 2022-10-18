package com.rg.dao.impl;

import com.rg.dao.AccountDao;
import com.rg.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
* @BelongsProject: spring_dbutils_anno
* @Author: RG
* @CreateTime: 2022/10/17 6:53 下午
* @Description: 
*/
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner queryRunner;

    @Override
    public List<Account> findAll() {

        List<Account> accountList = null;
        // 编写sql
        String sql = "select * from account";
        // 执行sql
        try {
            accountList = queryRunner.query(sql, new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;
    }

    @Override
    public Account findById(Integer id) {

        Account account = null;
        // 编写sql
        String sql = "select * from account where id = ?";
        // 执行sql
        try {
            account = queryRunner.query(sql, new BeanHandler<Account>(Account.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void save(Account account) {
        // 编写sql
        String sql = "insert into account(id,name,money) values(null,?,?)";
        // 执行sql
        try {
            queryRunner.update(sql,account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Account account) {
        // 编写sql
        String sql = "update account set name = ?,money = ? where id = ?";
        // 执行sql
        try {
            queryRunner.update(sql,account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        // 编写sql
        String sql = "delete from account where id = ?";
        // 执行sql
        try {
            queryRunner.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

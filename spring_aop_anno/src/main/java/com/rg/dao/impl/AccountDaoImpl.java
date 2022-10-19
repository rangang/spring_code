package com.rg.dao.impl;

import com.rg.dao.AccountDao;
import com.rg.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * @BelongsProject: spring_aop_anno
 * @Author: RG
 * @CreateTime: 2022/10/19 2:49 下午
 * @Description:
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner queryRunner;

    @Autowired
    private ConnectionUtils connectionUtils;

    @Override
    public void out(String outUser, Double money) {

        // 编写sql
        String sql = "update account set money = money - ? where name = ?";
        try {
            // 执行sql
            queryRunner.update(connectionUtils.getThreadConnection(),sql,money,outUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void in(String inUser, Double money) {
        // 编写sql
        String sql = "update account set money = money + ? where name = ?";
        try {
            // 执行sql
            queryRunner.update(connectionUtils.getThreadConnection(),sql,money,inUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

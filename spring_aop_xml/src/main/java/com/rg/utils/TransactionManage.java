package com.rg.utils;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

/**
 * @BelongsProject: spring_aop_xml
 * @Author: RG
 * @CreateTime: 2022/10/19 2:07 下午
 * @Description: 事务管理器工具类：包含开启事务、提交事务、回滚事务、释放资源
 */
public class TransactionManage {

    @Autowired
    private ConnectionUtils connectionUtils;

    /**
     * 开启事务
     */
    public void beginTransaction() {
        try {
            // 获取connection对象，开启一个手动事务
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     */
    public void release() {
        try {
            // 将手动事务改回为自定提交事务
            connectionUtils.getThreadConnection().setAutoCommit(true);
            // 将连接归还给连接池
            connectionUtils.getThreadConnection().close();
            // 解除线程绑定
            connectionUtils.removeThreadConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

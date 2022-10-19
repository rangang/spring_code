package com.rg.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @BelongsProject: spring_aop_anno
 * @Author: RG
 * @CreateTime: 2022/10/19 3:22 下午
 * @Description:
 */
@Component
@Aspect // 表面该类为切面类
public class TransactionManage {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.rg.service.impl.AccountServiceImpl.*(..))")
    public void myPointcut(){}

    @Around("TransactionManage.myPointcut()")
    public Object around(ProceedingJoinPoint pjp) {

        Object proceed = null;
        try {
            beginTransaction();
            proceed = pjp.proceed();
            commit();
        } catch (Throwable e) {
            e.printStackTrace();
            rollback();
        } finally {
            release();
        }

        return proceed;
    }

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
            // 将手动事务改回为自动提交事务
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

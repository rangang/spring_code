package com.rg.utils;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @BelongsProject: spring_aop_xml
 * @Author: RG
 * @CreateTime: 2022/10/19 2:00 下午
 * @Description:
 */
public class ConnectionUtils {

    @Autowired
    private DataSource dataSource;

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    /**
     * 获取当前线程上绑定连接：如果获取到的连接为空，那么就从数据源中获取连接，并且放到ThreadLocal中（绑定到当前线程）
     * @return
     */
    public Connection getThreadConnection() {
        // 1.先从ThreadLocal上获取连接
        Connection connection = threadLocal.get();
        // 2.判断当前是否有Connection
        if (connection == null) {
            try {
                // 3.从数据源中获取一个连接，并且存入ThreadLocal
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * 解除当前线程的连接绑定
     */
    public void removeThreadConnection() {
        threadLocal.remove();
    }

}

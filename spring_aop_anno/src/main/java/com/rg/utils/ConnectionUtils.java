package com.rg.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @BelongsProject: spring_aop_anno
 * @Author: RG
 * @CreateTime: 2022/10/19 3:08 下午
 * @Description:
 */
@Component
public class ConnectionUtils {

    @Autowired
    private DataSource dataSource;

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    /**
     * 获取当前线程上绑定连接：如果获取到的连接为空，那么就从数据源中获取连接，并且放到ThreadLocal中（绑定到当前线程）
     * @return
     */
    public Connection getThreadConnection() {
        // 1.先从ThreadLocal中获取连接
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

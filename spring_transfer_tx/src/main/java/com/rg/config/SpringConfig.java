package com.rg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @BelongsProject: spring_transfer_tx
 * @Author: RG
 * @CreateTime: 2022/10/19 8:48 下午
 * @Description:
 */
@Configuration
@ComponentScan("com.rg")
@Import(DataSourceConfig.class)
@EnableTransactionManagement
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate(@Autowired DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager getPlatformTransactionManage(@Autowired DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}

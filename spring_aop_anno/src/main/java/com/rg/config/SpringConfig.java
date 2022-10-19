package com.rg.config;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * @BelongsProject: spring_aop_anno
 * @Author: RG
 * @CreateTime: 2022/10/19 11:36 上午
 * @Description:
 */
@Configuration
@ComponentScan("com.rg")
@Import(DataSourceConfig.class)
@EnableAspectJAutoProxy // 开启AOP的自动代理 替代了<aop:aspectj-autoproxy />
public class SpringConfig {

    @Bean("queryRunner")
    public QueryRunner getQueryRunner(@Autowired DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

}

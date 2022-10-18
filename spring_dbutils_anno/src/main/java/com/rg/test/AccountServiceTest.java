package com.rg.test;

import com.rg.config.SpringConfig;
import com.rg.domain.Account;
import com.rg.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @BelongsProject: spring_dbutils_anno
 * @Author: RG
 * @CreateTime: 2022/10/17 7:25 下午
 * @Description:
 */
// @RunWith制定junit的运行环境 SpringJUnit4ClassRunner是spring提供的作为junit运行环境的类
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    // 测试查询所有
    @Test
    public void testFindAll() {

        List<Account> accountList = accountService.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }

    }

    // 测试查询
    @Test
    public void testFindById() {
        Account account = accountService.findById(2);
        System.out.println(account);
    }

    // 测试保存
    @Test
    public void testSave() {

        Account account = new Account();
        account.setName("rg");
        account.setMoney(100d);
        accountService.save(account);
    }

    // 测试修改
    @Test
    public void testUpdate() {
        Account account = new Account();
        account.setId(4);
        account.setName("rg3");
        account.setMoney(200d);
        accountService.update(account);
    }

    // 测试删除
    @Test
    public void testDelete() {
        accountService.delete(4);
    }


}

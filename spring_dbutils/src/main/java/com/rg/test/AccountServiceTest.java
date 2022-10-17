package com.rg.test;

import com.rg.domain.Account;
import com.rg.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @BelongsProject: spring_dbutils
 * @Author: RG
 * @CreateTime: 2022/10/17 2:34 下午
 * @Description:
 */
public class AccountServiceTest {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    AccountService accountService = (AccountService) applicationContext.getBean("accountService");

    // 测试保存
    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("lucy");
        account.setMoney(100d);
        accountService.save(account);

    }

    // 测试查询
    @Test
    public void testFindById() {
        Account account = accountService.findById(3);
        System.out.println(account);
    }

    // 测试查询所有
    @Test
    public void testFindAll() {
        List<Account> accountList = accountService.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    // 测试修改
    @Test
    public void testUpdate() {
        Account account = new Account();
        account.setId(3);
        account.setName("jack");
        account.setMoney(2000d);
        accountService.update(account);
    }

    // 测试删除
    @Test
    public void testDelete() {
        accountService.delete(3);
    }

}

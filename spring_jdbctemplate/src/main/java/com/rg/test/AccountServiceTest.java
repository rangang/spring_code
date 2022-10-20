package com.rg.test;

import com.rg.domain.Account;
import com.rg.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @BelongsProject: spring_jdbctemplate
 * @Author: RG
 * @CreateTime: 2022/10/19 5:41 下午
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    /**
     * 测试添加账户
     */
    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("lucy");
        account.setMoney(1000d);
        accountService.save(account);
    }

    /**
     * 测试查询所有账户
     */
    @Test
    public void testFindAll() {
        List<Account> list = accountService.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }

    /**
     * 测试根据ID查询账户
     */
    @Test
    public void testFindById() {
        Account account = accountService.findById(4);
        System.out.println(account);
    }

    /**
     * 测试修改账户
     */
    @Test
    public void testUpdate() {
        Account account = new Account();
        account.setId(4);
        account.setMoney(2000d);
        account.setName("rg");
        accountService.update(account);
    }

    /**
     * 测试删除账户
     */
    @Test
    public void testDelete() {
        accountService.delete(4);
    }

}

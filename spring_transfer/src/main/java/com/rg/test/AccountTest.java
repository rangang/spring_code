package com.rg.test;

import com.rg.proxy.CglibProxyFactory;
import com.rg.proxy.JDKProxyFactory;
import com.rg.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @BelongsProject: spring_transfer
 * @Author: RG
 * @CreateTime: 2022/10/18 10:38 上午
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JDKProxyFactory proxyFactory;

    @Autowired
    private CglibProxyFactory cglibProxyFactory;

    @Test
    public void testTransfer() {

        accountService.transfer("tom","jerry",100d);

    }

    /**
     * 测试JDK动态代理优化转账案例
     */
    @Test
    public void testTransferProxyJDK() {

        // 当前返回的实际上是AccountService的代理对象proxy
        AccountService accountServiceJDKProxy = proxyFactory.createAccountServiceJDKProxy();
        // 代理对象proxy调用接口中的任意方法时，，都会执行底层的invoke方法
        accountServiceJDKProxy.transfer("tom","jerry",100d);

    }

    /**
     * 测试cglib动态代理优化转账案例
     */
    @Test
    public void testTransferProxyCglib() {

        AccountService accountServiceCglib = cglibProxyFactory.createAccountServiceCglib();
        accountServiceCglib.transfer("tom","jerry",100d);

    }

}

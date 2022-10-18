package com.rg.proxy;

import com.rg.service.AccountService;
import com.rg.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @BelongsProject: spring_transfer
 * @Author: RG
 * @CreateTime: 2022/10/18 3:51 下午
 * @Description: JDK动态代理工厂类
 */
@Component
public class JDKProxyFactory {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionManager transactionManager;

    /**
     * 采用JDK动态代理技术来生成目标类的代理对象
     * ClassLoader loader : 类加载器，借助被代理对象获取到类加载器
     * Class<?>[] interfaces : 被代理类所需要实现的全部接口
     * InvocationHandler : 当代理对象调用接口中的任意方法时，那么都会执行InvocationHandler中invoke方法
     * @return
     */
    public AccountService createAccountServiceJDKProxy() {

        AccountService accountServiceProxy = (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {

            /**
             *
             * @param proxy 当前的代理对象引用
             * @param method 被调用的目标方法的引用
             * @param args  被调用的目标方法所用到的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                try {
                    // 手动开启事务：调用事务管理器类中的开启事务方法
                    transactionManager.beginTransaction();

                    // 让被代理对象的原方法执行
                    method.invoke(accountService, args);

                    // 手动提交事务
                    transactionManager.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    // 手动回滚事务
                    transactionManager.rollback();
                } finally {
                    // 手动释放资源
                    transactionManager.release();
                }

                return null;
            }
        });

        return accountServiceProxy;
    }

}

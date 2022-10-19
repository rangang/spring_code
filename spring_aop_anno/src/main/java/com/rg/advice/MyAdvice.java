package com.rg.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: spring_aop_anno
 * @Author: RG
 * @CreateTime: 2022/10/19 9:51 上午
 * @Description:
 */
@Component
// @Aspect // 切面：配置切入点和通知的关系
public class MyAdvice {

    // 切点表达式的抽取
    @Pointcut("execution(* com.rg.service.impl.AccountServiceImpl.*(..))")
    public void myPoint(){}

    // @Before("MyAdvice.myPoint()")
    // public void before() {
    //     System.out.println("前置通知...");
    // }
    //
    // @AfterReturning("MyAdvice.myPoint()")
    // public void afterReturning() {
    //     System.out.println("后置通知...");
    // }
    //
    // @AfterThrowing("MyAdvice.myPoint()")
    // public void afterThrowing() {
    //     System.out.println("异常通知...");
    // }
    //
    // @After("MyAdvice.myPoint()")
    // public void after() {
    //     System.out.println("最终通知...");
    // }

    @Around("MyAdvice.myPoint()")
    public Object around(ProceedingJoinPoint pjp) {

        Object proceed = null;
        try {
            System.out.println("前置通知...");
            proceed = pjp.proceed();
            System.out.println("后置通知...");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("异常通知...");
        } finally {
            System.out.println("最终通知...");
        }

        return proceed;
    }

}

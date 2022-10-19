package com.rg.advice;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @BelongsProject: spring_aop_xml
 * @Author: RG
 * @CreateTime: 2022/10/18 7:25 下午
 * @Description: 通知类
 */
public class MyAdvice {

    public void before() {
        System.out.println("前置通知...");
    }

    public void afterReturning() {
        System.out.println("后置通知...");
    }

    public void afterThrowing() {
        System.out.println("异常通知...");
    }

    public void after() {
        System.out.println("最终通知...");
    }

    /**
     *
     * @param pjp   正在执行的连接点：切点
     * @return
     */
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

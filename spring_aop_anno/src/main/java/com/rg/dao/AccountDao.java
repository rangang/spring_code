package com.rg.dao;

/**
 * @BelongsProject: spring_aop_anno
 * @Author: RG
 * @CreateTime: 2022/10/19 2:48 下午
 * @Description:
 */
public interface AccountDao {

    public void out(String outUser,Double money);

    public void in(String inUser, Double money);

}

package com.rg.dao;

/**
 * @BelongsProject: spring_transfer
 * @Author: RG
 * @CreateTime: 2022/10/18 9:55 上午
 * @Description:
 */
public interface AccountDao {

    // 转出
    public void out(String outUser, Double money);

    // 转入
    public void in(String inUser, Double money);

}

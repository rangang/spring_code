package com.rg.service;

/**
 * @BelongsProject: spring_transfer
 * @Author: RG
 * @CreateTime: 2022/10/18 10:00 上午
 * @Description:
 */
public interface AccountService {

    // 转账
    public void transfer(String outUser,String inUser,Double money);

}

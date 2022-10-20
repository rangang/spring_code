package com.rg.service;

/**
 * @BelongsProject: spring_transfer_tx
 * @Author: RG
 * @CreateTime: 2022/10/19 7:00 下午
 * @Description:
 */
public interface AccountService {

    public void transfer(String outUser, String inUser, Double money);

}

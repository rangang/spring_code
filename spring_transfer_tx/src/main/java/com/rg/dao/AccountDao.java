package com.rg.dao;

/**
 * @BelongsProject: spring_transfer_tx
 * @Author: RG
 * @CreateTime: 2022/10/19 6:53 下午
 * @Description:
 */
public interface AccountDao {

    /**
     * 减钱：转出操作
     * @param outUser
     * @param money
     */
    public void out(String outUser,Double money);

    /**
     * 加钱：转入操作
     * @param inUser
     * @param money
     */
    public void in(String inUser,Double money);

}

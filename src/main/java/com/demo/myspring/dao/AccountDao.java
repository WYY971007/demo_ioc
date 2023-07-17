package com.demo.myspring.dao;


import com.demo.myspring.entity.Account;
import org.springframework.stereotype.Repository;


public interface AccountDao {

    public void test();
    //根据id查询客户id
    public Account queryAccountById(String id)throws Exception;
    //根据id修改客户信息
    public int updateAccountById(Account account) throws Exception;
}

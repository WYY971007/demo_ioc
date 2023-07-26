package com.demo.myspring.utils.stock.Dao;

import com.demo.myspring.entity.Account;
import com.demo.myspring.utils.stock.entity.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface StockTransDao {

    public Account queryAccountById(@Param("id") String id) throws Exception;
    //根据id修改客户信息
    public int updateAccountById(@Param("account") Account account) throws Exception;

}

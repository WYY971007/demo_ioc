package com.demo.myspring.utils.stock.Dao;

import com.demo.myspring.utils.stock.entity.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@Mapper
public interface StockDao {

    List<Stock> queryStock(@Param("map") Map<String,String> stock) throws SQLException;
}

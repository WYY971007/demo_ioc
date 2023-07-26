package com.demo.myspring.utils.stock.Service;

import com.demo.myspring.utils.stock.entity.Stock;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface StockService {

    public List<Stock> selectStock(Map<String,String> data) throws Exception;
}

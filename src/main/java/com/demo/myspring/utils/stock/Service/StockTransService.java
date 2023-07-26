package com.demo.myspring.utils.stock.Service;

import com.demo.myspring.entity.Account;
import com.demo.myspring.utils.stock.entity.Stock;

import java.util.List;
import java.util.Map;


public interface StockTransService {

    public void transfer(String fromid, String toid, int money) throws Exception;


}

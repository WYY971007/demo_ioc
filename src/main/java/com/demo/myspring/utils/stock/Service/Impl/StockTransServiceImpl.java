package com.demo.myspring.utils.stock.Service.Impl;


import com.demo.myspring.entity.Account;

import com.demo.myspring.utils.stock.Dao.StockTransDao;
import com.demo.myspring.utils.stock.Service.StockTransService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("StockTransService")
public class StockTransServiceImpl implements StockTransService {

    @Autowired
    StockTransDao stockTransDao;

    @Override
    public void transfer(String fromid, String toid, int money) throws Exception {

        try {

            Account a = stockTransDao.queryAccountById(fromid);
            Account b = stockTransDao.queryAccountById(toid);

            a.setMoney(a.getMoney() - money);

            b.setMoney(b.getMoney() + money);


            stockTransDao.updateAccountById(a);

            int c = 1/0;

            stockTransDao.updateAccountById(b);

        } catch (Exception e) {
            throw e;
        }
    }
}

package com.demo.myspring.service.impl;


import com.demo.myspring.dao.AccountDao;
import com.demo.myspring.entity.Account;
import com.demo.myspring.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("transferService")
public class TransferServiceImpl implements TransferService {

    @Autowired
    private AccountDao accountDao;



    public void test() {
        accountDao.test();
    }

    public void transfer(String fromid, String toid, int money) throws Exception {
        //关闭自动提交
        try {

            Account a = accountDao.queryAccountById(fromid);
            Account b = accountDao.queryAccountById(toid);

            a.setMoney(a.getMoney() - money);

            b.setMoney(b.getMoney() + money);


            accountDao.updateAccountById(a);


            accountDao.updateAccountById(b);

        } catch (Exception e) {
            throw e;
        }

    }
}

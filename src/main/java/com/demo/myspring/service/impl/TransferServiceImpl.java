package com.demo.myspring.service.impl;


import com.demo.myspring.dao.AccountDao;
import com.demo.myspring.entity.Account;
import com.demo.myspring.service.TransferService;

public class TransferServiceImpl implements TransferService {

    private AccountDao accountDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

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

            int i = 1/0;

            accountDao.updateAccountById(b);

        } catch (Exception e) {
            throw e;
        }

    }
}

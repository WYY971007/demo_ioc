package com.demo.myspring.dao.impl;


import com.demo.myspring.dao.AccountDao;
import com.demo.myspring.entity.Account;
import com.demo.myspring.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDaoImpl implements AccountDao {


    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void test() {
        System.out.println("AccountDaoImpl____");
    }

    public Account queryAccountById(String id) throws Exception {
        Connection conn = connectionUtils.getCurrentThreadConn();
        String sql = "select * from account where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,id);
        ResultSet result = ps.executeQuery();

        Account account = new Account();
        while (result.next()) {
            account.setId(result.getString("id"));
            account.setUsername(result.getString("username"));
            account.setMoney(result.getInt("money"));
        }

        result.close();
        ps.close();

        return account;
    }

    public int updateAccountById(Account account) throws Exception {
        Connection conn = connectionUtils.getCurrentThreadConn();
        String sql = "update account set money = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,account.getMoney());
        ps.setString(2,account.getId());

        int i = ps.executeUpdate();
        ps.close();
        return i;
    }
}

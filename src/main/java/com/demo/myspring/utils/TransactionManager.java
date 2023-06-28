package com.demo.myspring.utils;

import java.sql.SQLException;

public class TransactionManager {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    //    public TransactionManager() {
//    }

//    private static TransactionManager instance = new TransactionManager();
//
//    public static TransactionManager getInstance() {
//        return instance;
//    }

    //开启事务管理
    public  void beginTransactionManager() throws SQLException {
        //关闭自动提交事务
        connectionUtils.getCurrentThreadConn().setAutoCommit(false);
    }
    //提交事务
    public void commitTransactionManager() throws SQLException {
        connectionUtils.getCurrentThreadConn().commit();
    }
    //回滚事务
    public void rollback() throws SQLException {
        connectionUtils.getCurrentThreadConn().rollback();
    }


}

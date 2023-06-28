package com.demo.myspring.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {


    //饿汉式单例线程安全
//    private ConnectionUtils() {
//    }
//    private static ConnectionUtils instence = new ConnectionUtils();
//
//    public static ConnectionUtils getInstence() {
//        return instence;
//    }

    private ThreadLocal<Connection> threadLocal = new ThreadLocal();

    /*从当前线程获取连接*/
    public Connection getCurrentThreadConn() throws SQLException {
        Connection connection = threadLocal.get();

        if (connection == null) {
            //从连接池拿
            connection = DruidUtils.getInstance().getConnection();
            threadLocal.set(connection);
        }

        return connection;
    }

}

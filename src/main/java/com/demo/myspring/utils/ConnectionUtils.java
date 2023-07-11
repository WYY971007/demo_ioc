package com.demo.myspring.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {



    private void init() {
        System.out.println("init<<<<<<<<<<<<");
    }

    private void destroy() {
        System.out.println("destroy<<<<<<<<<<<<");
    }
    //饿汉式单例线程安全
//    private ConnectionUtils() {
//    }
//    private static ConnectionUtils instence = new ConnectionUtils();
//
//    public static ConnectionUtils getInstence() {
//        return instence;
//    }

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private Integer count = 0;
    /*从当前线程获取连接*/
    public Connection getCurrentThreadConn() throws SQLException {
        Connection connection = threadLocal.get();
        System.out.println(connection);
        Thread t = Thread.currentThread();
        System.out.println("getCurrentThreadConn"+t.getName());
        if (connection == null) {
            System.out.println("connection第"+count+"次进入if");
            //从连接池拿
            connection = DruidUtils.getInstance().getConnection();
            threadLocal.set(connection);
            count++;
        }

        return connection;
    }

}

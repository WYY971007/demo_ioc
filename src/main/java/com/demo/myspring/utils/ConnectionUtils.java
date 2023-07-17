package com.demo.myspring.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component("connectionUtils")
public class ConnectionUtils {

    private String username;
    private Integer age;
    private float money;

    public ConnectionUtils() {}

    public ConnectionUtils(String username, Integer age, float money) {
        this.username = username;
        this.age = age;
        this.money = money;
    }

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

    @Autowired
    private DruidDataSource datasource;

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private Integer count = 0;
    /*从当前线程获取连接*/
    public Connection getCurrentThreadConn() throws SQLException {
        Connection connection = threadLocal.get();
        Thread t = Thread.currentThread();
        System.out.println(  "getCurrentThreadConn"+t.getName() + "connection:"+            System.identityHashCode(connection));
        if (connection == null) {
            System.out.println("connection第"+count+"次进入if");
            //从连接池拿
            connection = datasource.getConnection();
            threadLocal.set(connection);
            count++;
        }

        return connection;
    }

}

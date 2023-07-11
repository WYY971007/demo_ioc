package com.demo.myspring.spring.Factory;

import com.demo.myspring.utils.ConnectionUtils;

public class CreatBeanFactory {

    public static ConnectionUtils getInstanceStaticConnectionUtils() {
        return new ConnectionUtils();
    }

    public ConnectionUtils getInstanceConnectionUtils() {
        return new ConnectionUtils();
    }
}

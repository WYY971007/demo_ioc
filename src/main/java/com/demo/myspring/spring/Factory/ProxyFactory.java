package com.demo.myspring.spring.Factory;



import com.demo.myspring.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//代理工厂
@Component("proxyFactory")
public class ProxyFactory {

    @Autowired
    private TransactionManager transactionManager;



//    private ProxyFactory() {}

//    //单例
//    private static ProxyFactory instance = new ProxyFactory();
//
//    public static ProxyFactory getinstance(){
//        return instance;
//    }

    public Object getProxy(final Object object)  {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                transactionManager.beginTransactionManager();
                Object result = null;
                try {
                    result = method.invoke(object, args);
                    transactionManager.commitTransactionManager();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("事务回滚");
                    transactionManager.rollback();
                }
                return result;
            }
        });
    }


}

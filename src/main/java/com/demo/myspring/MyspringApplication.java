package com.demo.myspring;


import com.demo.myspring.service.TransferService;
import com.demo.myspring.spring.Factory.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyspringApplication {


    public static void main(String[] args) {

        //ioc容器指定加载xml文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //根据id获取指定bean
        TransferService transferService = (TransferService)applicationContext.getBean("transferService");
        //获取代理工厂
        ProxyFactory proxyFactory = (ProxyFactory)applicationContext.getBean("ProxyFactory");
        //获取实际代理对象
        TransferService jdkproxy = (TransferService)proxyFactory.getProxy(transferService);


    }

}

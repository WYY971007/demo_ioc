package com.demo.myspring;


import com.demo.myspring.config.SpringConfiguration;
import com.demo.myspring.service.TransferService;
import com.demo.myspring.spring.Factory.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class MyspringApplication {


    public static void main(String[] args) throws Exception {
//
//        //ioc容器指定加载xml文件
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        //根据id获取指定bean
//        TransferService transferService = (TransferService)applicationContext.getBean("transferService");
//        //获取代理工厂
//        ProxyFactory proxyFactory = (ProxyFactory)applicationContext.getBean("ProxyFactory");
//        //获取实际代理对象
//        TransferService jdkproxy = (TransferService)proxyFactory.getProxy(transferService);
//
//        jdkproxy.transfer("1","2",20);

        //通过xml
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        //通过注解
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
////        System.out.println("bean:  " + applicationContext.getBean("company"));
////        System.out.println("工厂bean:  " + applicationContext.getBean("&company"));
//        System.out.println("aaa");
//        System.out.println("工厂bean:  " + applicationContext.getBean("lazyResult"));
//        ((AnnotationConfigApplicationContext) applicationContext).close();
//
//        JedisPoolConfig config = new JedisPoolConfig();//设置最大连接数
//        config.setMaxTotal(30);//设置最大的空闲连接数
//        JedisPool jedisPool = new JedisPool(config,"127.0.0.1",6379);//获得核心对象：jedis
//        Jedis jedis = null;
//        jedis =jedisPool.getResource();//设置数据
//        jedis.set("name","lccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");//获取数据
//        String value = jedis.get("name");
//        System.out.println("value值是："+value);

    }

}

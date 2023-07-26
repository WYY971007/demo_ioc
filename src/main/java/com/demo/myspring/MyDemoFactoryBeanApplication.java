package com.demo.myspring;

import com.demo.myspring.config.SpringConfiguration;
import com.demo.myspring.entity.MyDemoService;
import com.demo.myspring.spring.Factory.MyDemoFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyDemoFactoryBeanApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        String[] myDemoTactoryBeanNames = applicationContext.getBeanNamesForType(MyDemoFactoryBean.class);
        String[] myDemoServicBeanNames = applicationContext.getBeanNamesForType(MyDemoService.class);
        MyDemoFactoryBean myDemoFactoryBean = applicationContext.getBean(MyDemoFactoryBean.class);
        System.out.println(myDemoTactoryBeanNames[0]);
        System.out.println(myDemoServicBeanNames[0]);

    }
}

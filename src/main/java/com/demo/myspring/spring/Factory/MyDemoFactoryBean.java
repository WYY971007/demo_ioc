package com.demo.myspring.spring.Factory;

import com.demo.myspring.entity.MyDemoService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("myDemoService")
public class MyDemoFactoryBean implements FactoryBean<MyDemoService> {
    @Override
    public MyDemoService getObject() throws Exception {
        return new MyDemoService();
    }

    @Override
    public Class<?> getObjectType() {
        return MyDemoService.class;
    }
}

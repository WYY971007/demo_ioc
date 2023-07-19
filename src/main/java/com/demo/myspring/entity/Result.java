package com.demo.myspring.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@ToString

@Component("lazyResult")
public class Result implements BeanNameAware, BeanFactoryAware , ApplicationContextAware, InitializingBean ,  DisposableBean {

    private String status;
    private String message;

    @Override
    public void setBeanName(String name) {
        System.out.println("bean生命周期第三步BeanNameAware的setBeanName方法。。。。注册我成为Bean时注册的id为:" + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("bean生命周期第四步BeanFactoryAware的setBeanFactory方法。。。。管理我的bean工厂为:" + beanFactory);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("bean生命周期第五步，高级容器接口的applicationcontext为:" + applicationContext);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("bean生命周期第七步，afterPropertiesSet" );

    }

    @PostConstruct
    public void initmethod() {
        System.out.println("bean生命周期第八步，initmethod" );

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("bean销毁，DisposableBean的destroy方法");
    }

    @PreDestroy
    public void destroymethod() {
        System.out.println("bean销毁，destroymethod");
    }
}

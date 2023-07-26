package com.demo.myspring.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.demo.myspring.entity.Company;
import com.demo.myspring.spring.Factory.CompanyFactoryBean;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.sql.DataSource;
import java.io.IOException;


@Configuration
@ComponentScan({"com.demo.myspring"}) //自动扫描注解
@PropertySource({"classpath:jdbc.properties","classpath:redis.properties"})
@Import(MybatisConfig.class)
public class SpringConfiguration {

    @Value("${jdbc.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;


    @Value("${redis.maxTotal}")
    private Integer maxTotal;
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private Integer port;


    public JedisPoolConfig jedisPoolConfig(){    //这个是修改redis性能的时候需要的对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        return jedisPoolConfig;
    }



    @Bean("jedisPool")  //这个注解注入工厂的名称是方法名
    public JedisPool jedisPool() {
        JedisPoolConfig jedisPoolConfig = jedisPoolConfig();
        return new JedisPool(jedisPoolConfig,host,port);
    }


    //创建Bean实例
    @Bean("datasource")
    public DruidDataSource Creatdatasource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }
//
//    @Bean("company")
//    public Company CreateCompany() {
//        CompanyFactoryBean companyFactoryBean = new CompanyFactoryBean();
//        companyFactoryBean.setCompanyinfo("wyy,中关村,999");
//        Company company = null;
//
//        try {
//            company = companyFactoryBean.getObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return company;
//
//
//    }
//
//



}

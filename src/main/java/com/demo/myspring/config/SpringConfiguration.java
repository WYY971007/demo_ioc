package com.demo.myspring.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.demo.myspring.entity.Company;
import com.demo.myspring.spring.Factory.CompanyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.demo.myspring"}) //自动扫描注解
@PropertySource("classpath:jdbc.properties") //加载指定位置配置资源文件
public class SpringConfiguration {

    @Value("${jdbc.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;




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

    @Bean("company")
    public Company CreateCompany() {
        CompanyFactoryBean companyFactoryBean = new CompanyFactoryBean();
        companyFactoryBean.setCompanyinfo("wyy,中关村,999");
        Company company = null;

        try {
            company = companyFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;


    }





}

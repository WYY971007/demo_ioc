package com.demo.myspring.spring.Factory;

import com.demo.myspring.entity.Company;
import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

@Data
public class CompanyFactoryBean implements FactoryBean<Company> {


    private String companyinfo;

    @Override
    public Company getObject() throws Exception {
        Company company = new Company();
        String[] strings = companyinfo.split(",");
        company.setName(strings[0]);
        company.setAddress(strings[1]);
        company.setScale(strings[2]);
        return company;
    }

    //规定返回的类型
    @Override
    public Class<?> getObjectType() {
        return Company.class;
    }

    //规定是否是单例
    @Override
    public boolean isSingleton() {
        return true;
    }
}

package com.demo.myspring.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

public class MybatisConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {

        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setDataSource(dataSource);//设置数据源
        ssfb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:" + "mapper/*.xml"));

        return ssfb;

    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){

        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.demo.myspring.utils.stock.Dao");
        return msc;
    }
}

package com.smile.druid;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @作者 liutao
 * @时间 2020/3/8 10:31
 * @描述 druid配置类 , 若是使用自动配置数据库参数，需要加入DataSourceAutoConfiguration类
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource masterDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.slaver")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.slaver", name = "enabled", havingValue = "true")
    public DataSource slaverDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.slaver2")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.slaver2", name = "enabled", havingValue = "true")
    public DataSource slaverDataSource2(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicRoutingDataSource")
    @Primary
    public DynamicRoutingDataSource dataSource(DataSource masterDataSource,  DataSource slaverDataSource, DataSource slaverDataSource2){
        Map<Object,Object> targetDataSourceMap = new HashMap<>();
        targetDataSourceMap.put(DataSourceKey.MASTER.getName(), masterDataSource);
        targetDataSourceMap.put(DataSourceKey.SLAVER.getName(), slaverDataSource);
        targetDataSourceMap.put(DataSourceKey.SLAVER2.getName(), slaverDataSource2);
        return new DynamicRoutingDataSource(masterDataSource, targetDataSourceMap);
    }

}

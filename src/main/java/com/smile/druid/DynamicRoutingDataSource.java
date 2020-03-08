package com.smile.druid;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @作者 liutao
 * @时间 2020/3/8 10:28
 * @描述
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    public DynamicRoutingDataSource(DataSource defaultDataSource, Map<Object,Object> targetDataSourceMap) {
        super.setDefaultTargetDataSource(defaultDataSource);
        super.setTargetDataSources(targetDataSourceMap);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("-----------DynamicRoutingDataSource.----------" + DynamicDataSourceContextHolder.getDataSourceKey());
        return DynamicDataSourceContextHolder.getDataSourceKey();
    }
}

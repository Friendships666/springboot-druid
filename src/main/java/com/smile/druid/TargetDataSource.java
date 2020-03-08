package com.smile.druid;

import java.lang.annotation.*;

/**
 * @作者 liutao
 * @时间 2020/3/8 10:18
 * @描述  自定义一个注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetDataSource {

    DataSourceKey value() default DataSourceKey.MASTER;
}

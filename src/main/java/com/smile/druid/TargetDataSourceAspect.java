package com.smile.druid;

import com.smile.utils.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @作者 liutao
 * @时间 2020/3/8 10:40
 * @描述 切面
 */
@Aspect
@Component
@Order(1)
public class TargetDataSourceAspect {

    @Pointcut("@annotation(com.smile.druid.TargetDataSource)")
    public void pointcut(){

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        TargetDataSource annotation = method.getAnnotation(TargetDataSource.class);

        if(StringUtils.isNotNull(annotation)){
            // 先进行赋值 方法上的数据库唯一的key切换
            System.out.println("切面方法上切换了数据库>>>>>>" + annotation.value().getName());
            DynamicDataSourceContextHolder.setDataSourceKey(annotation.value().getName());
        }

        try {
            return joinPoint.proceed();
        } finally {
            // 清除key
            DynamicDataSourceContextHolder.clearDataSourceKey();
        }

    }



}

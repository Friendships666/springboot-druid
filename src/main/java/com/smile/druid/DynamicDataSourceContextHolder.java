package com.smile.druid;

/**
 * @作者 liutao
 * @时间 2020/3/8 10:23
 * @描述  主要用于数据库标识的切换，使用ThreadLocal
 */
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<String> CONTEXT_LOCAL = new ThreadLocal<>();

    /**
     * 设置key
     * @param key
     */
    public static void setDataSourceKey(String key){
        System.out.println("切换数据库>>>>>" + key);
        CONTEXT_LOCAL.set(key);
    }

    /**
     * 获取key
     * @return
     */
    public static String getDataSourceKey(){
        System.out.println("-------ThreadLocal-----" + CONTEXT_LOCAL.get());
        return CONTEXT_LOCAL.get();
    }

    /**
     * 清除key, 在切换过数据源执行方法之后，需要销毁ThreadLocal里面的key
     */
    public static void clearDataSourceKey(){
        CONTEXT_LOCAL.remove();
    }


}

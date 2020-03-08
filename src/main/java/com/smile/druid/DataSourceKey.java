package com.smile.druid;

/**
 * @作者 liutao
 * @时间 2020/3/8 10:20
 * @描述 枚举类，主要是用于数据库切换的标识
 */
public enum DataSourceKey {

    MASTER("master"),
    SLAVER("slaver"),
    SLAVER2("slaver2");

    private String name;

    private DataSourceKey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.smile.service.impl;

import com.smile.druid.DataSourceKey;
import com.smile.druid.TargetDataSource;
import com.smile.mapper.LoginMapper;
import com.smile.pojo.Login;
import com.smile.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @作者 liutao
 * @时间 2020/3/4 0:30
 * @描述
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @TargetDataSource(DataSourceKey.SLAVER)
    @Override
    public List<Login> selectLoginList() {
        return loginMapper.selectLoginList();
    }

    @TargetDataSource(DataSourceKey.SLAVER2)
    @Override
    public List<Login> selectLogin2List() {
        return loginMapper.selectLoginList();
    }
}

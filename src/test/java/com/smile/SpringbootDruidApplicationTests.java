package com.smile;


import com.smile.pojo.Login;
import com.smile.pojo.User;
import com.smile.service.LoginService;
import com.smile.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = DruidApp.class)
@RunWith(SpringRunner.class)
public class SpringbootDruidApplicationTests {


    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;



    @Test
    public void contextLoads() {
        List<User> list = userService.selectUserList();
        if(list != null && list.size() > 0){
            for(User user : list){
                System.out.println("用户信息：" + user);
            }
        }

        //**************登录信息表************
        List<Login> loginList = loginService.selectLoginList();
        if(loginList != null && loginList.size() > 0){
            for(Login login : loginList){
                System.out.println("登录信息：" + login);
            }
        }

        //**************登录信息表2222************
        List<Login> loginList2 = loginService.selectLogin2List();
        if(loginList2 != null && loginList2.size() > 0){
            for(Login login : loginList2){
                System.out.println("登录信息3333：" + login);
            }
        }

        //******************添加主数据库信息*************
        userService.insertUserElement(new User().setName("校长").setNo("wertiosd94"));
    }

}

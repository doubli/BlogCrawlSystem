package com.xiyou.BCS.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiyou.BCS.model.User;
import com.xiyou.BCS.service.UserService;

public class testUserInsert {
	private UserService userService;
    
    @Before
    public void before(){                                                                   
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml"
                ,"classpath:spring-mybatis.xml"});
        userService = (UserService) context.getBean("userServiceImpl");
    }
     
    @Test
    public void addUser(){
        User user = new User();
        user.setName("aaa");
        System.out.println(userService.insertUser(user));
    }
}

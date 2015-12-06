package com.xiyou.BCS.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiyou.BCS.dao.UserDAO;

public class testUserDAO {
	private UserDAO userDAO;
	 @Before
	    public void before(){                                                                   
	       /* ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml"
	                ,"classpath:spring-mybatis.xml"});*/
		 ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml"
	                ,"classpath:spring-mybatis.xml"});
	        userDAO = (UserDAO) context.getBean("userDAO");
	    }
	 @Test
	 public void test(){
		 System.out.println(userDAO);
	 }
}

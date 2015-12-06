package com.xiyou.BCS.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xiyou.BCS.model.User;
import com.xiyou.BCS.service.UserService;

//@Controller注解把该class指定为controller，@RequestMapping 注解的 value值指定该controller所映射的请求。
/**
 *方法上的@RequestMapping 注解指定该方法为一个action，value 值指定该action所映射的请求，method 中的RequestMethod.GET指定该action只接受get请求。
 *ModelAndView 中的setViewName指定了该action所对应的视图名称，解析视图时会在spring.xml文件指定的视图文件夹中寻找对应的视图。
 */
@Controller
@RequestMapping(value = "/")
public class HelloWorldController {
    @Autowired  
    private  HttpServletRequest request;  
    
    @Autowired
    private UserService userServiceImpl;
	
	//http://localhost:8080/BlogCrawlSystem/helloworld/views/main.do
    @RequestMapping(value="/main", method = {RequestMethod.GET})
    public ModelAndView index(){
    	System.out.println("访问Hello Controller!");
    	
        ModelAndView modelAndView = new ModelAndView();
        String name = (String) request.getParameter("name");
        modelAndView.addObject("message", "Hello World!");  
        modelAndView.addObject("name",name);
        
        User user = new User();
        user.setName(name);
        modelAndView.setViewName("main");  
        userServiceImpl.insertUser(user);
        return modelAndView;
    }
    
}
package com.xiyou.BCS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {

//	@RequestMapping(value="index",method=RequestMethod.GET)
	@RequestMapping("/index")
	public ModelAndView index(){
		System.out.println(111);
		return new ModelAndView("index");
//	 return "index";
	}
	
}

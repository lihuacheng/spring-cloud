package com.alimaomao.controller;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {
	
	private static final Logger log = Logger.getLogger(SecurityController.class);

	@RequestMapping("/test")
	public String test(){
		log.info("----------测试Security服务------------");
		return "测试Security服务";
	}
	
	@RequestMapping("/login")
	public String login(){
		log.info("----------测试登陆页面------------");
		return "测试登陆页面";
	}
	
	@RequestMapping("/loginAfter")
	public String loginAfter(){
		log.info("----------测试需要登陆后的页面------------");
		return "测试需要登陆后的页面";
	}
}

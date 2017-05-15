package com.alimaomao.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alimaomao.service.MessageClient;
import com.alimaomao.service.MessageServerClient;

@RestController
@RequestMapping("/feign-message")
public class MessageController {
	
	private Logger log = Logger.getLogger(MessageController.class);
	
	@Autowired
	MessageClient messageClient;
	
	@Autowired
	MessageServerClient messageServerClient;
	
	@RequestMapping("/test")
	public String test(){
		log.info("进入feign/test方法");
		String info = messageClient.test();
		log.info("return:"+info);
		return info;
	}
	
	@RequestMapping("/hystrixTest")
	public String hystrixTest(){
		log.info("进入feign/hystrix/test方法");
		String info = messageServerClient.test();
		log.info("return:"+info);
		return info;
	}
}

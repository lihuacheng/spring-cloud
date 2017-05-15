package com.alimaomao.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	private final Logger log = Logger.getLogger(AccountController.class);
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/test")
	public String test(){
		log.info("-----------测试account服务--------------");
		return "测试account服务";
	}
	
	@RequestMapping("/show")
	public String showAccount(String str){
		ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
		log.info("方法：showAccount , host:"+serviceInstance.getHost()+
				" , service_id:"+serviceInstance.getServiceId()+" , result:"+str);
		return str;
	}
}

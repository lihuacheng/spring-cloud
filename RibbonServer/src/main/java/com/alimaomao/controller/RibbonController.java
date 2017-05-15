package com.alimaomao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alimaomao.ribbonService.RibbonService;

@RestController
@RequestMapping("/Ribbon")
public class RibbonController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	RibbonService ribbonService;
	
	@RequestMapping("/test")
	public String test(){
		return "测试负载均衡器Ribbon：11111111";
	}
	
	
	@RequestMapping("/message-server")
	public String messageServer(){
		return restTemplate.getForEntity("http://message-server/message/test", String.class).getBody();
	}
	
	@RequestMapping("/message-test")
	public String messageTest(){
		return ribbonService.messageTest();
	}
}

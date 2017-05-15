package com.alimaomao.ribbonService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RibbonService {
	
	private Logger log = Logger.getLogger(RibbonService.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="messageFallback")
	public String messageTest(){
		log.info("进入RibbonService.messageTest方法");
		return restTemplate.getForEntity("http://message-server/message/test", String.class).getBody();
	}
	
	public String messageFallback(){
		return "Ribbon系统异常";
	}
}

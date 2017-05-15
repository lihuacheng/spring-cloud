package com.alimaomao.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alimaomao.hystrix.MessageServerClientHystrix;

@FeignClient(value="ribbon-server",fallback=MessageServerClientHystrix.class)
public interface MessageServerClient {
	
	@RequestMapping("/Ribbon/message-server")
	public String test();
}

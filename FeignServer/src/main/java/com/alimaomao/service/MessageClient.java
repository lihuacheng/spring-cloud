package com.alimaomao.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "ribbon-server")
public interface MessageClient {

	@RequestMapping("/Ribbon/message-test")
	public String test();
}

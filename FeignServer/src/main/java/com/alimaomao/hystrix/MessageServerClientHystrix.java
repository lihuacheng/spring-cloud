package com.alimaomao.hystrix;

import org.springframework.stereotype.Component;

import com.alimaomao.service.MessageServerClient;

@Component
public class MessageServerClientHystrix implements MessageServerClient {

	@Override
	public String test() {
		return "Feign系统异常";
	}

}

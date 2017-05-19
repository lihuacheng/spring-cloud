package com.alimaomao.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(AccessFilter.class);
	
	@Override
	public Object run() {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		
		log.info("%s request to %s", request.getMethod());
		
		Object accessToken = request.getParameter("accessToken");
		if(accessToken == null){
			
			log.warn("access Token is empty(accessToken是空的)");
			
			requestContext.setSendZuulResponse(false);
			requestContext.setResponseStatusCode(401);
			requestContext.setResponseBody("accessToken不能为空");
			return null;
			
		}
		log.info("access Token is ok(accessToken验证通过)");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}

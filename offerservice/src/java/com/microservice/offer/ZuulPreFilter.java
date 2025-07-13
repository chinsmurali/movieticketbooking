package com.microservice.offer;
import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Configuration
public class ZuulPreFilter extends ZuulFilter {

	@Override 
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true; // by default it will be false
	}

	@Override
	public Object run() throws ZuulException {
		// logics are executed on pre or post processing
		System.out.println("*********** pre processing *********");
		RequestContext ctx = RequestContext.getCurrentContext();
		
		ctx.addZuulRequestHeader("time", LocalDateTime.now().toString());
		// this needs to be done in another filter while post process
		LocalDateTime requestTime = LocalDateTime.parse(ctx.getZuulRequestHeaders().get("time"));
		LocalDateTime curentTime = LocalDateTime.now();
		Duration.between(requestTime, curentTime);
		return null;
	}

	@Override
	public String filterType() {
		// it can return pre or post
		return "pre"; // here you can write "post" for post filtering
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}

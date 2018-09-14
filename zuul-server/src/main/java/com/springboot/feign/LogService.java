package com.springboot.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.model.Log;

@FeignClient("log-service")
public interface LogService {
	
	@PostMapping(value = "/log")
	public void recordZuulInteractions(Log log); 
}

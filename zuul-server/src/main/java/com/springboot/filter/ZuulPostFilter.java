package com.springboot.filter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.springboot.feign.LogService;
import com.springboot.model.Log;

@Component
public class ZuulPostFilter extends ZuulFilter {

	@Autowired
	private LogService logService;

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return FilterConstants.POST_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		RequestContext requestContext = RequestContext.getCurrentContext();
		System.out.println("FilterConstants.SEND_RESPONSE_FILTER_ORDER ---- " + FilterConstants.SEND_RESPONSE_FILTER_ORDER);
		System.out.println("FilterConstants.SEND_FORWARD_FILTER_ORDER ---- " + FilterConstants.SEND_FORWARD_FILTER_ORDER);
		System.out.println("FilterConstants.SEND_ERROR_FILTER_ORDER ---- " + FilterConstants.SEND_ERROR_FILTER_ORDER);
		System.out.println("FilterConstants.PRE_DECORATION_FILTER_ORDER ---- " + FilterConstants.PRE_DECORATION_FILTER_ORDER);
		HttpServletRequest httpServletRequest = requestContext.getRequest();
		Log log = new Log();
		try {
			String requestBody = StreamUtils.copyToString(httpServletRequest.getInputStream(),
					Charset.forName("UTF-8"));
			String responsBody = StreamUtils.copyToString(requestContext.getResponseDataStream(),
					Charset.forName("UTF-8"));
			requestContext.setResponseBody(responsBody);
			log.setRequest(requestBody);
			log.setResponse(responsBody);
			log.setCreateTime(new Date());
			logService.recordZuulInteractions(log);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

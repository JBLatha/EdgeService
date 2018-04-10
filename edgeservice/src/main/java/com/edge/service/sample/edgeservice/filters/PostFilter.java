package com.edge.service.sample.edgeservice.filters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PostFilter extends ZuulFilter {
	
	   private static final String REQUEST_PATH = "/first";
	    private static final String TARGET_SERVICE = "second-service";
	    private static final String HTTP_METHOD = "POST";

	    //private final DiscoveryClient discoveryClient;

	   /* public PostFilter(DiscoveryClient discoveryClient) {
	        this.discoveryClient = discoveryClient;
	    }*/
 
  @Override
  public String filterType() {
    return "post";
  }
 
  @Override
  public int filterOrder() {
    return 1;
  }
 
  @Override
  public boolean shouldFilter() {
	  RequestContext context = RequestContext.getCurrentContext();
      HttpServletRequest request = context.getRequest();
      String method = request.getMethod();
      String requestURI = request.getRequestURI();
      return HTTP_METHOD.equalsIgnoreCase(method) && requestURI.startsWith(REQUEST_PATH);
    //return true;
  }
 
  @Override
  public Object run() {
   System.out.println("Inside Response Filter");
   RequestContext context = RequestContext.getCurrentContext();
   
   return null;
	   
	   
	   
   //return ctx;
  }
}
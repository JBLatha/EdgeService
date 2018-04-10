package com.edge.service.sample.edgeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.edge.service.sample.edgeservice.filters.ErrorFilter;
import com.edge.service.sample.edgeservice.filters.PostFilter;
import com.edge.service.sample.edgeservice.filters.PreFilter;
import com.edge.service.sample.edgeservice.filters.RouteFilter;


@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class EdgeserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdgeserviceApplication.class, args);
	}
	
	@Bean
	public PreFilter preFilter() {
	    return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
	    return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
	    return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
	    return new RouteFilter();
	}
}

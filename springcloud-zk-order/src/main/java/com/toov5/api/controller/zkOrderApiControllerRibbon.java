package com.toov5.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
@EnableDiscoveryClient //如果服务使用consul或者zk使用这个注解 向注册中心注册服务
public class zkOrderApiControllerRibbon {
	@Value("${server.port}")
	private String serverPort;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/orderToMember")
  public String orderToMember() {
		String url ="http://zk-member/getMember"; 
	    return restTemplate.getForObject(url, String.class);
  }
	
	@RequestMapping("/discoveryMember")
	public List<ServiceInstance> discoveryMember() {
		List<ServiceInstance> instances = discoveryClient.getInstances("zk-member");
		for (ServiceInstance serviceInstance : instances) {
			System.out.println("url"+serviceInstance.getUri());
		}
		return instances;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(zkOrderApiControllerRibbon.class, args);
	}
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

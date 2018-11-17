package com.toov5.Consul;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDiscoveryClient //如果服务使用consul或者zk使用这个注解 向注册中心注册服务
public class consulMemberApiController {
	@Value("${server.port}")
	private String serverPort;
	
	
	@RequestMapping("/getMember")
  public String getMember() {
	    return "会员服务prot:"+serverPort;
  }
	
	public static void main(String[] args) {
		SpringApplication.run(consulMemberApiController.class, args);
	}
}

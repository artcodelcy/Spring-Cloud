package com.toov5.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.spring4all.swagger.EnableSwagger2Doc;

@SpringBootApplication
@EnableEurekaClient   
@EnableSwagger2Doc //开启swagger文档)
public class AppMember {
   
	public static void main(String[] args) {
		SpringApplication.run(AppMember.class, args);
	}
	
}  

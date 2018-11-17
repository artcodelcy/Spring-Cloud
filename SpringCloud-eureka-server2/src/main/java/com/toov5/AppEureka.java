package com.toov5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer   //����ע������
@SpringBootApplication 
public class AppEureka {
  
	 public static void main(String[] args) {
		   SpringApplication.run(AppEureka.class, args);
	}
	
}

package com.toov5.api.service.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.spring4all.swagger.EnableSwagger2Doc;

@SpringBootApplication (scanBasePackages={"com.toov5.*"})
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2Doc //开启swagger文档)
public class AppMember {
  public static void main(String[] args) {
	SpringApplication.run(AppMember.class, args);
}
}

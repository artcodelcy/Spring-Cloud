package com.toov5.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages={"com.toov5.*"})
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class AppOrder {
   public static void main(String[] args) {
	SpringApplication.run(AppOrder.class, args);
}
}

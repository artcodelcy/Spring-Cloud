package com.toov5.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDiscoveryClient //�������ʹ��consul����zkʹ�����ע�� ��ע������ע�����
public class zkMemberApiController {
	@Value("${server.port}")
	private String serverPort;
	
	
	@RequestMapping("/getMember")
  public String getMember() {
	    return "��Ա����prot:"+serverPort;
  }
	
	public static void main(String[] args) {
		SpringApplication.run(zkMemberApiController.class, args);
	}
}

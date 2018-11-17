package com.toov5.api.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toov5.api.entity.UserEntity;
import com.toov5.base.ResponseBase;

@RestController
public interface IMemberService {
 
	@RequestMapping("/getMember")  //接口加@RequestMapping 被其他项目调用时候 feign客户端可以继承
	public UserEntity getMember(@RequestParam("name") String name);
	
	@RequestMapping("/getUserInfo")
	public ResponseBase getUserInfo();
	
}

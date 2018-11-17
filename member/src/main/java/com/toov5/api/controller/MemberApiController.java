package com.toov5.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("会员服务接口")
public class MemberApiController {
	@Value("${server.port}")
	private String serverPort;

	@RequestMapping("/getMember")
	public String getMember() {
		return "服务端口号是" + serverPort;
	}

	@ApiOperation(value = "获取会员信息接口") // 具体描述
	@ApiImplicitParam(name = "userName", value = "用户信息参数", required = true, dataType = "String") // 传入的参数 ,描述 , 必须传递true																									// , 类型String
	@GetMapping("/getMembe")
	public String getMember(String userName) {
		System.out.println(userName);
		return "userName" + userName;
	}

}

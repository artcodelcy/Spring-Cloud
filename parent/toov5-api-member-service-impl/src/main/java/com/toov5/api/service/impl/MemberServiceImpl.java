package com.toov5.api.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toov5.api.entity.UserEntity;
import com.toov5.api.service.IMemberService;
import com.toov5.base.BaseApiService;
import com.toov5.base.ResponseBase;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

  
@RestController
@Api("会员服务接口")
public class MemberServiceImpl extends BaseApiService implements IMemberService {
	@Value("${server.port}")
	private String serverPort; 
	
	 @RequestMapping("/getMember")  
	public UserEntity getMember(@RequestParam("name") String name) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(name);
		userEntity.setAge(10);
		return userEntity;
	}
	 
	 @RequestMapping("/getUserInfo") 
	 public ResponseBase getUserInfo() {
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
			
		}
		return setResultSuccess("getUserInfo调用成功....");
	}
	 
	  
	 @RequestMapping("/") 
	 public String Index() {
		return "我是member"+serverPort;
	} 
	 
	    @ApiOperation(value = "获取会员信息接口") // 具体描述
		@ApiImplicitParam(name = "userName", value = "用户信息参数", required = true, dataType = "String") // 传入的参数 ,描述 , 必须传递true																									// , 类型String
		@GetMapping("/getMemberInfo")
		public String getMemberInfo(String userName) {
			System.out.println(userName);
			return "userName" + userName;
		}
 
}

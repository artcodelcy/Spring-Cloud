package com.toov5.api.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toov5.api.entity.UserEntity;
import com.toov5.base.ResponseBase;

@RestController
public interface IMemberService {
 
	@RequestMapping("/getMember")  //�ӿڼ�@RequestMapping ��������Ŀ����ʱ�� feign�ͻ��˿��Լ̳�
	public UserEntity getMember(@RequestParam("name") String name);
	
	@RequestMapping("/getUserInfo")
	public ResponseBase getUserInfo();
	
}

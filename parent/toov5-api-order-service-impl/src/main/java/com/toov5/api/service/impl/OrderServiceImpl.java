package com.toov5.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.toov5.api.entity.UserEntity;
import com.toov5.api.feign.MemberServiceFeign;
import com.toov5.api.service.IOrderService;
import com.toov5.base.BaseApiService;
import com.toov5.base.ResponseBase;

@RestController
public class OrderServiceImpl extends BaseApiService implements IOrderService {
	@Autowired
	private MemberServiceFeign memberServiceFeign;
    
	@RequestMapping("/orderToMmeber")
	public String orderToMember(String name) {
		UserEntity user = memberServiceFeign.getMember(name);
		return user == null ? "没有" : user.toString();
	}

	@RequestMapping("/orderToMemberUserInfo")
	public ResponseBase orderToMemberUserInfo() {
		return memberServiceFeign.getUserInfo();
	}

	@HystrixCommand(fallbackMethod = "orderToMemberUserInfoHystrixFallback")
	@RequestMapping("/orderToMemberUserInfoHystrix")
	public ResponseBase orderToMemberUserInfoHystrix() {
		System.out.println("orderToMemberUserInfoHystrix" + "线程池名称" + Thread.currentThread().getName());
		return memberServiceFeign.getUserInfo();
	}

	public ResponseBase orderToMemberUserInfoHystrixFallback() {
		return setResultSuccess("请稍后再试~");
	}

	@RequestMapping("/orderToMemberUserInfoHystrixdSecond")
	public ResponseBase orderToMemberUserInfoHystrix_demo02() {
		System.out.println("orderToMemberUserInfoHystrix" + "线程池名称" + Thread.currentThread().getName());
		return memberServiceFeign.getUserInfo();
	}

	@RequestMapping("/orderInfo")
	public ResponseBase orderInfo() {
		System.out.println("orderInfo" + "线程池名称" + Thread.currentThread().getName());
		return setResultSuccess();
	}
    
	 @RequestMapping("/") 
	 public String Index() {
		return "我是order";
	} 	
}

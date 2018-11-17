package com.toov5.api.service;

import org.springframework.web.bind.annotation.RequestMapping;

import com.toov5.base.ResponseBase;

public interface IOrderService {
	@RequestMapping("/orderToMember")
	public String orderToMember(String name);

	@RequestMapping("/orderToMemberUserInfo")
	public ResponseBase orderToMemberUserInfo();

	@RequestMapping("/orderInfo")
	public ResponseBase orderInfo();
}

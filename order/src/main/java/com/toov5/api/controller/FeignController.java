package com.toov5.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toov5.Feign.MemberFeign;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("订单接口")
public class FeignController {
	 @Autowired
	 private MemberFeign memberFeign;
	
     @RequestMapping("/getFeignMember")
	 public String feignMember() {
		return memberFeign.getMember();
	 }
     
     @ApiOperation("订单服务接口")
     @PostMapping("/getOrder")
     public String getOrder() {
    	 return "getOrder";
     }
     
     
     
}

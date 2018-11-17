package com.toov5.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api("swaggerdemo控制器")  //接口描述
@RestController
public class SwaggerController {
    @ApiOperation(value = "swagger演示接口")   //具体描述
    @GetMapping("/swaggerIndex")
	public String swaggerIndex() {
		
		return "swaggerIndex";
	}
    
    @ApiOperation(value = "获取会员信息接口")   //具体描述
    @ApiImplicitParam(name="userName",value="用户信息参数",required=true,dataType="String")  //传入的参数  ,描述 , 必须传递true , 类型String
    @GetMapping("/getMembe")
	public String getMember(String userName) {
		System.out.println(userName);
		return "userName"+userName;
	}
    
    
}

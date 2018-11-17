package com.toov5.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api("swaggerdemo������")  //�ӿ�����
@RestController
public class SwaggerController {
    @ApiOperation(value = "swagger��ʾ�ӿ�")   //��������
    @GetMapping("/swaggerIndex")
	public String swaggerIndex() {
		
		return "swaggerIndex";
	}
    
    @ApiOperation(value = "��ȡ��Ա��Ϣ�ӿ�")   //��������
    @ApiImplicitParam(name="userName",value="�û���Ϣ����",required=true,dataType="String")  //����Ĳ���  ,���� , ���봫��true , ����String
    @GetMapping("/getMembe")
	public String getMember(String userName) {
		System.out.println(userName);
		return "userName"+userName;
	}
    
    
}

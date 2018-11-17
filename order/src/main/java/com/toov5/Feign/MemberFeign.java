package com.toov5.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="app-toov5-member")   //name就是服务名称
public interface MemberFeign {
   //Feign书写方式 以Spring mvc接口形式书写
	
	@RequestMapping("/getMember") 
	public String getMember();  //底层自动转换成http协议实现rpc远程调用
	
}

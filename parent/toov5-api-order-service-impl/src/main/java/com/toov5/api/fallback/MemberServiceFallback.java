package com.toov5.api.fallback;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toov5.api.entity.UserEntity;
import com.toov5.api.feign.MemberServiceFeign;
import com.toov5.base.BaseApiService;
import com.toov5.base.ResponseBase;

@Component
@RequestMapping("fallback/")   //这个可以防止 容器中有与父类重复的 requestMapping！！！
public class MemberServiceFallback extends BaseApiService implements  MemberServiceFeign {
    
	 @Override
	public ResponseBase getUserInfo() {
		 return setResultError("来自类的提示:系统错误,请稍后重试!");
	}
	 
	@Override
	public UserEntity getMember(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

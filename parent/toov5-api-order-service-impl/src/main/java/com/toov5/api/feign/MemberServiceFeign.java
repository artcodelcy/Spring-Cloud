package com.toov5.api.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.toov5.api.fallback.MemberServiceFallback;
import com.toov5.api.service.IMemberService;
@FeignClient(value="app-toov5-member",fallback = MemberServiceFallback.class)
public interface MemberServiceFeign extends IMemberService {
  
}
 
package com.toov5.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="app-toov5-member")   //name���Ƿ�������
public interface MemberFeign {
   //Feign��д��ʽ ��Spring mvc�ӿ���ʽ��д
	
	@RequestMapping("/getMember") 
	public String getMember();  //�ײ��Զ�ת����httpЭ��ʵ��rpcԶ�̵���
	
}

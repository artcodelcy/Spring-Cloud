package com.toov5.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class TokenFilter extends ZuulFilter {
    @Value("${server.port}")
    private String serverPort;
    
	public boolean shouldFilter() {   //�жϹ������Ƿ���Ч
		// TODO Auto-generated method stub
		return true;
	}

	public Object run() throws ZuulException {
		  //��д����������ҵ���߼�����
//		// �������������ж�����ӿڣ��жϷ���ӿ����Ƿ��д���userToekn����
//		//��ȡ������
//		RequestContext currentContext = RequestContext.getCurrentContext();
//		//��ȡrequest����
//		HttpServletRequest request = currentContext.getRequest();
//		//��֤tokenʱ�� token�Ĳ��� ������ͷ��ȡ
//	  String userToken = request.getParameter("userToken");
//	  if (StringUtils.isEmpty(userToken)) {
//		//���ش�����ʾ
//		  currentContext.setSendZuulResponse(false);  //false  �����������ִ�� ������÷���ӿ��� ����ֱ����Ӧ���ͻ���
//		  currentContext.setResponseBody("no no no  you have not userToken");
//		  currentContext.setResponseStatusCode(401);
//		  return null;
//	}
//       //��������ִ�� ���÷���ӿ�...	
//	  System.out.println("���صĶ˿ں�"+serverPort);
	   return null;
	}

	@Override
	public String filterType() {     //������������
		// TODO Auto-generated method stub 
		return "pre";   //��ʾ������֮ǰִ��
	}  

	@Override 
	public int filterOrder() {  //������ִ�е�˳�� һ��������ͬһ���׶δ��ڶ��������ʱ�򣬶��������ִ��˳������ 
		// TODO Auto-generated method stub
		return 0;
	}
   //���ص�filter������
}

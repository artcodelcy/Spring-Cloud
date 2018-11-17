package com.toov5;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.spring4all.swagger.EnableSwagger2Doc;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy  //�������ش���
@EnableSwagger2Doc  //����swagger
public class AppGateway {
   public static void main(String[] args) {
   SpringApplication.run(AppGateway.class, args);	 
}

	// zuul�����ܹ�ʹ��configʵ��ʵʱ����
	@RefreshScope
	@ConfigurationProperties("zuul")
	public ZuulProperties zuulProperties() {
		return new ZuulProperties();
	}

   
   	// ����ĵ���Դ
   	@Component
   	@Primary
   	class DocumentationConfig implements SwaggerResourcesProvider {
   		public List<SwaggerResource> get() {
   			List resources = new ArrayList<>();
   			  //app-itmayiedu-order            
   			resources.add(swaggerResource("app-toov5-member����ӿ���Ϣ", "/api-member/v2/api-docs", "2.0")); // ��һ�������������д �ڶ����ο�yml��Ӧ
//   			resources.add(swaggerResource("app-toov5-order����ӿ���Ϣ", "/api-order/v2/api-docs", "2.0"));
   			return resources;
   		}

   		private SwaggerResource swaggerResource(String name, String location, String version) {
   			SwaggerResource swaggerResource = new SwaggerResource();
   			swaggerResource.setName(name);
   			swaggerResource.setLocation(location);
   			swaggerResource.setSwaggerVersion(version);
   			return swaggerResource;
   		}
   	}

   }

   
   


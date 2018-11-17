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
@EnableZuulProxy  //开启网关代理
@EnableSwagger2Doc  //开启swagger
public class AppGateway {
   public static void main(String[] args) {
   SpringApplication.run(AppGateway.class, args);	 
}

	// zuul配置能够使用config实现实时更新
	@RefreshScope
	@ConfigurationProperties("zuul")
	public ZuulProperties zuulProperties() {
		return new ZuulProperties();
	}

   
   	// 添加文档来源
   	@Component
   	@Primary
   	class DocumentationConfig implements SwaggerResourcesProvider {
   		public List<SwaggerResource> get() {
   			List resources = new ArrayList<>();
   			  //app-itmayiedu-order            
   			resources.add(swaggerResource("app-toov5-member服务接口信息", "/api-member/v2/api-docs", "2.0")); // 第一个参数可以随便写 第二个参考yml对应
//   			resources.add(swaggerResource("app-toov5-order服务接口信息", "/api-order/v2/api-docs", "2.0"));
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

   
   


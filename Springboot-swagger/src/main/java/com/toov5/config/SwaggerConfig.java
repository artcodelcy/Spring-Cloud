package com.toov5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2   //开启swagger
public class SwaggerConfig {

	@Bean  //配置bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				// api扫包  配置生成api的扫包范围
				.apis(RequestHandlerSelectors.basePackage("com.toov5.api")).paths(PathSelectors.any()).build();
	}
   //创建api文档信息
	private ApiInfo apiInfo() {
		 //文档标题   描述   官网  版本号
		return new ApiInfoBuilder().title("微服务电商系统Test").description("Java分布式练习")
				.termsOfServiceUrl("http://www.toov5.com")
				// .contact(contact)
				.version("1.0").build();
	}

}

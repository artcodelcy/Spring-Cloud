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
@EnableSwagger2   //����swagger
public class SwaggerConfig {

	@Bean  //����bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				// apiɨ��  ��������api��ɨ����Χ
				.apis(RequestHandlerSelectors.basePackage("com.toov5.api")).paths(PathSelectors.any()).build();
	}
   //����api�ĵ���Ϣ
	private ApiInfo apiInfo() {
		 //�ĵ�����   ����   ����  �汾��
		return new ApiInfoBuilder().title("΢�������ϵͳTest").description("Java�ֲ�ʽ��ϰ")
				.termsOfServiceUrl("http://www.toov5.com")
				// .contact(contact)
				.version("1.0").build();
	}

}

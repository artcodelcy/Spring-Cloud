package com.toov5.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {
	@Value("${motto}")   //≈‰÷√µƒkey
  private String motto;
	
	@RequestMapping("/getMotto")
	public String getMotto() {
		return motto;
	}
}

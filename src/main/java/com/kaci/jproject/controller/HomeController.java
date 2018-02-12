package com.kaci.jproject.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaci.jproject.service.HomeService;

@RestController
@Api(value = "/Test", description = "Test Swagger")
public class HomeController {
	
	@Autowired
	HomeService homeService;
	
	@GetMapping("/message")
	@ResponseBody
	@ApiOperation("Message Endpoint")
	public String getMessage() {
		return homeService.getMessage();
	}

}

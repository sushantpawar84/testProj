package com.test.spring.service2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloWorldSrv2Controller {

	@RequestMapping("/hello")
	String home() {
		return "Hello World from Service 2";
	}

}

package com.test.spring.service3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloWorldSrv3Controller {

	/**
	 * Main calling method of Service 2
	 * @return
	 */
	@RequestMapping("/hello")
	String home() {
		return "Hello World from Service 3";
	}

}

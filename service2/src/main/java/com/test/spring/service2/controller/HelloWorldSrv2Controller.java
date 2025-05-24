package com.test.spring.service2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloWorldSrv2Controller {

	/**
	 * Eureka Server instance Object Injection.
	 */
	@Autowired
	DiscoveryClient registry;
	
	/**
	 * Main calling method of Service 2
	 * @return
	 */
	@RequestMapping("/hello")
	String home() {
		String service2Str = "Hello World from Service 2 ";
		String service3Str = getHelloClient();
		String finalStr = service2Str.concat(" | ").concat(service3Str);
		return finalStr;
	}
	
	private String getHelloClient() {

		List<ServiceInstance> instances = registry.getInstances("service3");
		System.out.println("instances {} : " + instances);
		System.out.println("instance Uri : " + instances.get(0).getUri());
		System.out.println("instance Host : " + instances.get(0).getHost());

		/* "http://localhost:8081/hello"; */
		 String url = instances.get(0).getUri().toString(); 
		 url = url + "/hello";
		 RestTemplate restTemplate = new RestTemplate(); 
		 String result = restTemplate.getForObject(url, String.class);
		 
		return result;
	}

}

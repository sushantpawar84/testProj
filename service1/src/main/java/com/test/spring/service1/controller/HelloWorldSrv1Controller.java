package com.test.spring.service1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloWorldSrv1Controller {

	/**
	 * Eureka Server instance Object Injection.
	 */
	@Autowired
	DiscoveryClient registry;

	/**
	 * Main calling method of Service 1
	 * @return
	 */
	@RequestMapping("/hello")
	String home() {
		String service1Str = "Hello World from Service 1 ";
		String service2Str = getHelloClient();
		String finalStr = service1Str.concat(" | ").concat(service2Str);
		return finalStr;
	}

	private String getHelloClient() {

		List<ServiceInstance> instances = registry.getInstances("service2");
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

package com.test.spring.service2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableEurekaClient
public class MainSrv2 {
	public static void main(String[] args) {
		SpringApplication.run(MainSrv2.class, args);
	}
}

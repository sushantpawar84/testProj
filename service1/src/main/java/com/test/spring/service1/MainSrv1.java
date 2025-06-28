package com.test.spring.service1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableDiscoveryClient
public class MainSrv1 {
	public static void main(String[] args) {
		SpringApplication.run(MainSrv1.class, args);
	}
}

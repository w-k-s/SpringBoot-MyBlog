package com.tribalscale.wks.myvlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MyvlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyvlogApplication.class, args);
	}

}

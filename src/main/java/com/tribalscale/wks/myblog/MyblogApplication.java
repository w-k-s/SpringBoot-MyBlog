package com.tribalscale.wks.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
		"com.tribalscale.wks.myblog.blogs",
		"com.tribalscale.wks.myblog.location",
		"com.tribalscale.wks.myblog.config",
		"com.tribalscale.wks.myblog.data"
})
@SpringBootApplication
public class MyblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyblogApplication.class, args);
	}

}

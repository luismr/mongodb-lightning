package com.aurea.cam.lightning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {
		"com.aurea.cam.lightning"
})
public class LightningApplication {

	public static void main(String[] args) {
		SpringApplication.run(LightningApplication.class, args);
	}
}

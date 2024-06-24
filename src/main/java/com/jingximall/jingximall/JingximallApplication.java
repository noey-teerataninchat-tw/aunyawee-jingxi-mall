package com.jingximall.jingximall;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.jingximall.jingximall.model")
public class JingximallApplication {

	public static void main(String[] args) {
		SpringApplication.run(JingximallApplication.class, args);
	}

}

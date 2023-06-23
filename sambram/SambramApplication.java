package com.webapp.sambram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.webapp"})
public class SambramApplication {

	public static void main(String[] args) {
		SpringApplication.run(SambramApplication.class, args);
	}

}

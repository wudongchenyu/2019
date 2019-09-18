package com.llz.hikaris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.llz")
public class HikarisApplication {

	public static void main(String[] args) {
		SpringApplication.run(HikarisApplication.class, args);
	}

}

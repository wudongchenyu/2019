package com.llz.mybatisplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.llz")
public class MybatisplusApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisplusApplication.class, args);
	}

}

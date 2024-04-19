package com.recuritportal.jspwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan

@SpringBootApplication
public class RecuritPortalApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RecuritPortalApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(RecuritPortalApplication.class, args);
	}

}

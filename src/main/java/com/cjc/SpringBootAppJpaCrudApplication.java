package com.cjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cjc.service.EmployeeService;

@SpringBootApplication
public class SpringBootAppJpaCrudApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootAppJpaCrudApplication.class, args);
		EmployeeService service = context.getBean(EmployeeService.class);
		service.check();
	}

}

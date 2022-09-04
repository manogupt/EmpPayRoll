package com.Bridgelabz.EmpPayRoll;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmpPayRollApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmpPayRollApplication.class, args);
		
		
	}

}
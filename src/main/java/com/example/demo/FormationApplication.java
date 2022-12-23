package com.example.demo;


import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class FormationApplication implements ApplicationRunner {
	private static final Logger logger = LogManager.getLogger(FormationApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FormationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.debug("debug message "); // ce message ne s'affiche pas car dons log4j2.xml notre level='info' and debug<info
		logger.info("starter application debugger success");
		logger.error("error message");
	}
}

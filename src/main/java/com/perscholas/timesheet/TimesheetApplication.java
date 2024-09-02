package com.perscholas.timesheet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimesheetApplication {

	private static final Logger logger = LoggerFactory.getLogger(TimesheetApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(TimesheetApplication.class, args);
	}

	CommandLineRunner runner() {
		return args -> {

			logger.info("Timesheet Application up and running");
			logger.warn("I am warning youuu !!!!!!");
			logger.error("error");

		};
	}

}

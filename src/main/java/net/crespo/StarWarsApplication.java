package net.crespo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarWarsApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(StarWarsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StarWarsApplication.class, args);
		LOGGER.info("Han Solo!");
	}
}

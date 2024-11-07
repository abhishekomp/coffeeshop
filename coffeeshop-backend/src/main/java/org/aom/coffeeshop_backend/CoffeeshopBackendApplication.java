package org.aom.coffeeshop_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
//@EnableConfigurationProperties(ApplicationProperties.class)
@ConfigurationPropertiesScan
public class CoffeeshopBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeshopBackendApplication.class, args);
	}

}

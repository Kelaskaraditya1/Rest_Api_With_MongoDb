package com.StarkIndustries.RestApiWithMongoDb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})
public class RestApiWithMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiWithMongoDbApplication.class, args);
	}

}


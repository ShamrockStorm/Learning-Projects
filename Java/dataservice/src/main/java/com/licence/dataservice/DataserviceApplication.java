package com.licence.dataservice;

import com.licence.dataservice.persistance.DatabaseMappingTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DataserviceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DataserviceApplication.class, args);
		//DatabaseMappingTest test = context.getBean(DatabaseMappingTest.class);
		//test.persistEntities();
	}

}

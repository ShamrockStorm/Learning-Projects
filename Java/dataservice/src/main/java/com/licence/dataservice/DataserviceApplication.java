package com.licence.dataservice;

import com.licence.dataservice.locationhandleing.DeliveryRouteCalculator;
import com.licence.dataservice.persistance.DatabaseMappingTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class DataserviceApplication {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(DataserviceApplication.class, args);
		//DatabaseMappingTest test = context.getBean(DatabaseMappingTest.class);
		//test.persistEntities();
		//DeliveryRouteCalculator drc = new DeliveryRouteCalculator();
		//drc.GetDeliveryRoute();
	}

}

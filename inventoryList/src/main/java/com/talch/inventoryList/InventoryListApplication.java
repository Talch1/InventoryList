package com.talch.inventoryList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Talch
 *
 */

@EnableSwagger2
@SpringBootApplication
public class InventoryListApplication {

	public static void main(String[] args) {
	
		ConfigurableApplicationContext ctx = SpringApplication.run(InventoryListApplication.class, args);
		System.out.println("start");
	}

}

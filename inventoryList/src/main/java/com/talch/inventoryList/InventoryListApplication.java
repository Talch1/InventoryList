package com.talch.inventoryList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
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

		
		
		class SwaggerConfig {
			@Bean
			public Docket api() {
				return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
						.paths(PathSelectors.regex("/list.*")).build();
			}
		}
	}

}

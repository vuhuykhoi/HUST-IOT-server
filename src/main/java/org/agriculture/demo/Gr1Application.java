package org.agriculture.demo;

import org.agriculture.demo.services.SubscribeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Gr1Application {

	public static void main(String[] args) {
		SpringApplication.run(Gr1Application.class, args);
		SubscribeService subscribeService = new SubscribeService();
		subscribeService.subscribe("temperature");
	}
}

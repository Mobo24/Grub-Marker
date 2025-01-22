package dev.GrubMarker;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.GrubMarker.foodtruck.FoodTruck;
import dev.GrubMarker.foodtruck.FoodTruckRepository;
import dev.GrubMarker.foodtruck.FoodType;
import dev.GrubMarker.user; 

@SpringBootApplication
public class Application {
	private static Logger log = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.info("Welcome to GrubMarker!");
	}

	@Bean
	CommandLineRunner runner(UserRestClient restclient) {
		return args -> {
			
		};
	}
}

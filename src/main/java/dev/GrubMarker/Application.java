package dev.GrubMarker;

import java.sql.Time;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.GrubMarker.location.Location;
import dev.GrubMarker.location.LocationType;

@SpringBootApplication
public class Application {
	private static Logger log = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.info("Welcome to GrubMarker!");
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			Location location = new Location(37.7749, 122.4194, LocalTime.now(), LocationType.RESIDENTIAL_AREA);
			log.info("We are GrubMaking !" + location);
		};
	}
}

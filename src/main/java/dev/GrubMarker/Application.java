package dev.GrubMarker;
import java.time.LocalTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import dev.GrubMarker.user.User;
import dev.GrubMarker.user.UserHttpClient;
import dev.GrubMarker.user.UserRestClient; 

@SpringBootApplication
public class Application {
	private static Logger log = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.info("Welcome to GrubMarker!");
	}

	@Bean
	UserHttpClient userHttpClient() {
	    RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
	    HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
	    return factory.createClient(UserHttpClient.class);
	}
	@Bean
	CommandLineRunner runner(UserRestClient restclient) {
		return args -> {
			List <User> user = restclient.findAll();
			user.forEach(System.out::println);

			User user1 =restclient.findById(1);
			System.out.println(user1);
		};
	}
}

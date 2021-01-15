package com.udacity.ConsumingRestApi;

import com.udacity.ConsumingRestApi.Entity.Joke;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@SpringBootApplication
public class ConsumingRestApiApplication {

	private static final Logger log = (Logger) LoggerFactory.getLogger(ConsumingRestApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApiApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate){
		return args -> {
			Joke joke = restTemplate.getForObject("https://api.icndb.com/jokes/random", Joke.class);
			log.info(joke.toString());
		};
	}
}
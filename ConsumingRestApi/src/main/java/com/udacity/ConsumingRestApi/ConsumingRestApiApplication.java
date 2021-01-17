package com.udacity.ConsumingRestApi;

import com.udacity.ConsumingRestApi.Entity.Joke;
import com.udacity.ConsumingRestApi.Entity.Response;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;

@SpringBootApplication
public class ConsumingRestApiApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumingRestApiApplication.class);

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
			Response response = restTemplate.getForObject("https://api.icndb.com/jokes/random", Response.class);
//			Joke joke = restTemplate.getForObject("https://api.icndb.com/jokes/random", Joke.class);
			log.info(response.getValue().toString());
		};
	}
}

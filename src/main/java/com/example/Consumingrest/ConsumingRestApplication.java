package com.example.Consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingRestApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApplication.class, args);
	}



	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate x) throws Exception{
		return args -> {Quote quote = x.getForObject("https://gturnquist-quoters.cfapps.io/api/random",Quote.class);
		log.info(quote.toString());
		log.info("Hello we can write anything to command line and my name is sai kishore");
		};

	}



}

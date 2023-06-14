
package com.microservice.city;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaServer // enables this application to act as service-discovery
@EnableZuulProxy
public class MovieTestApplicationStart {

	public static void main(String[] args) {
		SpringApplication.run(MovieTestApplicationStart.class, args);
	}

}
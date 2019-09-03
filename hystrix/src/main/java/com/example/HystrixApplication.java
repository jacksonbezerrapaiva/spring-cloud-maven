package com.example;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableHystrix
@SpringBootApplication
@RestController
public class HystrixApplication {

	@HystrixCommand(fallbackMethod = "defaultName")
	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET, produces = "application/json")
	public String getName(@PathVariable String name) {
		return new RestTemplate()
				.getForObject("http://localhost:7777/test/{username}",
						String.class, name);
	}

	private String defaultName(String name) {
		return "Off";
	}

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }
}

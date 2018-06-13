package com.enhinck.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.client.RestTemplate;

import feign.Request;

@EnableDiscoveryClient
@ImportResource({ "classpath*:applicationContext.xml" })
@EnableFeignClients(basePackages = "com.enhinck.demo.service")
@SpringBootApplication
public class DemoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApiApplication.class, args);
	}

	@Configuration
	class Config {
		@LoadBalanced
		public RestTemplate restTemplate() {
			return new RestTemplate();
		}

	}

	@Bean
	public static Request.Options requestOptions(ConfigurableEnvironment env) {
		int ribbonReadTimeout = env.getProperty("ribbon.ReadTimeout", int.class, 70000);
		int ribbonConnectionTimeout = env.getProperty("ribbon.ConnectTimeout", int.class, 60000);
		return new Request.Options(ribbonConnectionTimeout, ribbonReadTimeout);
	}
}

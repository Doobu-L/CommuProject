package com.ks.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CommunityApplication extends SpringBootServletInitializer {

	static {
		System.setProperty("spring.config.location", "classpath:/application.yml,classpath:/commu.yml");
	}

	public static void main(String[] args) {
		SpringApplication.run(CommunityApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CommunityApplication.class);
	}

}

package com.ks.community;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommunityApplicationTests {

	static {
		System.setProperty("spring.config.location", "classpath:/application.yml,classpath:/befit.yml");
	}

	@Test
	void contextLoads() {
	}

}

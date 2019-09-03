package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HystrixApplication.class)
@WebAppConfiguration
public class HystrixApplicationTests {

	@Test
	public void contextLoads() {
	}

}

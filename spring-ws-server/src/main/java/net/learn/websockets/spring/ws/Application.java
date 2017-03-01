package net.learn.websockets.spring.ws;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(final String args[]) {
		final ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

		System.out.println("Let's inspect the beans provided by Spring Boot:");

		final String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (final String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
}

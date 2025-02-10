package io.github.niveastelmam.springarchitecture;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		//SpringApplication.run(Application.class, args);

		// Another way to start the application
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);

		// builder.bannerMode(Banner.Mode.OFF); // disable Spring banner
		builder.profiles("producer", "hml"); // activate a development profile
		builder.run(args);


		ConfigurableApplicationContext applicationContext = builder.context();

		//var produtoRepository = applicationContext.getBean("productRepository");

		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String applicationName = environment.getProperty("spring.application.name");
		System.out.println("Application name: " + applicationName);

	}

}

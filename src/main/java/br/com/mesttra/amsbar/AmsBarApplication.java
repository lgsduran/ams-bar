package br.com.mesttra.amsbar;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class AmsBarApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmsBarApplication.class, args);
	}

}

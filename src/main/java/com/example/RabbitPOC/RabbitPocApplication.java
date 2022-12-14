package com.example.RabbitPOC;

import com.example.RabbitPOC.pub_sub.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitPocApplication implements CommandLineRunner {
	@Autowired
	private Sender sender;

	public static void main(String[] args) {
		SpringApplication.run(RabbitPocApplication.class, args);
	}

	@Override
	public void run(String... args) {
		for (int i = 0; i < 10; i++) {
			sender.send(i*100);
		}
	}
}

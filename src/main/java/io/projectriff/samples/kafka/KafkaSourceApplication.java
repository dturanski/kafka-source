package io.projectriff.samples.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaSourceApplication {
	public static void main(String[] args) {
		SpringApplication.run(KafkaSourceApplication.class, args).close();
	}
}
package com.bilginyuksel.kafkalogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;

@SpringBootApplication
public class KafkaLoggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaLoggerApplication.class, args);
    }

    @KafkaListener(topics = "test", groupId = "group")
    public void listen(String message) throws IOException {
	// Write class hieararcy here. and parse this string to that class.
	// So you have to write a deserializer.
        System.out.println("Message : "+ message);
    }
}

package com.bilginyuksel.kafkalogger;

import com.bilginyuksel.kafkalogger.model.KafkaLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;

@SpringBootApplication
public class KafkaLoggerApplication {


    public static void main(String[] args) {
        SpringApplication.run(KafkaLoggerApplication.class, args);
    }


    @KafkaListener(topics = "kartaca_bilginyuksel", groupId = "group")
    public void listen(String message) throws IOException {

        message = message.replace("json:","");

        ObjectMapper objectMapper = new ObjectMapper();
        KafkaLog aLog = objectMapper.readValue(message, KafkaLog.class);
        System.out.println("Message : "+ message);
        System.out.println(aLog);

    }
}

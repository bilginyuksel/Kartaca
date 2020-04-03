package com.bilginyuksel.kafkalogger;

import com.bilginyuksel.kafkalogger.model.KafkaLog;
import com.bilginyuksel.kafkalogger.model.User;
import com.bilginyuksel.kafkalogger.service.FileServiceImpl;
import com.bilginyuksel.kafkalogger.service.IFileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class KafkaLoggerApplication {


    @Autowired private IFileService fileService;


    public static void main(String[] args) {
        SpringApplication.run(KafkaLoggerApplication.class, args);
    }



    @KafkaListener(topics = "sarama_topic", groupId = "group")
    public void listen(String message) throws IOException {
        message = message.replace("json:","");
        ObjectMapper objectMapper = new ObjectMapper();
        KafkaLog aLog = null;
        try {
            aLog = objectMapper.readValue(message, KafkaLog.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Logger log = Logger.getAnonymousLogger();
        log.log(Level.INFO, aLog.toString());

        // System.out.println(aLog);

        /*
         * In file logging system.
         * For every user a file where the messages are logged is created.
         * So an example of a file.
         * user00001 ->
         * 1-UserviewedPost1
         * 2-UserviewedPost2*/

        String fileName = "user-"+ aLog.getMessage().getViewed_by().getUsername();
        try {
            fileService.writeString(fileName, message+"\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

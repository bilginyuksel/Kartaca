package com.bilginyuksel.kafkalogger;

import com.bilginyuksel.kafkalogger.model.AgendaLog;
import com.bilginyuksel.kafkalogger.serializer.IAgendaSerializer;
import com.bilginyuksel.kafkalogger.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;

@SpringBootApplication
public class KafkaLoggerApplication {

    @Autowired private IAgendaSerializer serializer;
    @Autowired private IFileService fileService;

    public static void main(String[] args) {
        SpringApplication.run(KafkaLoggerApplication.class, args);
    }


    @KafkaListener(topics = "kartaca_bilginyuksel", groupId = "group")
    public void listen(String message) throws IOException {
	    // Write class hieararcy here. and parse this string to that class.
	    // So you have to write a deserializer.
        AgendaLog agendaLog = serializer.deserialize(message);
        if(fileService.isWritable("fileName")) fileService.write("path", agendaLog);

        System.out.println("Message : "+ message);
    }
}

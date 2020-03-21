package com.bilginyuksel.logger;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;

@KafkaListener(id="pk", topics="test")
public class Listener {


    @KafkaHandler(isDefault = true)
    public void listen(Object obj){
        System.out.println(obj.toString());
    }

}

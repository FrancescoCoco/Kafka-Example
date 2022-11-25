package com.producer.kafkaproducer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    //Kafka listener to receive data
    //If you have more listener group id is unique
    @KafkaListener(topics="example_topic", groupId = "groupId")
    void listener(String data){
     System.out.println(("Listener received: "+ data + " "));
    }
}

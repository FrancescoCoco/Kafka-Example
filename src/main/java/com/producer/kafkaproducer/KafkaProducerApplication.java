package com.producer.kafkaproducer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }


    //Define a command line runner which receive the kafka template
    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String,String> kafkaTemplate){
        return args -> {
            //If you use topic and data you need to specify the topic and data but you can use also partioning
            kafkaTemplate.send("example_topic","Is there new consumer (Sorry for the english) ");
        };
    }
}

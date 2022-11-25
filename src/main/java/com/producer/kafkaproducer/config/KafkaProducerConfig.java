package com.producer.kafkaproducer.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/*Producer configurations */
@Configuration
public class KafkaProducerConfig {

    //bootstrap servers url
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    /*This method allow us to set the config of a producer */
    public Map<String,Object> producerConfig(){
        Map<String,Object> props = new HashMap<>();
        //Put configuration props
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        /*Key and value are string */
        //Define serializer for key
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        //Define serializer for value
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }

    /*These method allows us to build a producer with the producer config */
    //Key and value are String if you want to send a Json Object you can substitute second String with Json Object
    @Bean
    public ProducerFactory<String,String> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    /*Kafka template to sent message*/
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String,String>producerFactory){
        return new KafkaTemplate<>(producerFactory);
    }


}

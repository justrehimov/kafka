package io.desofme.kafkaconsumer.service;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ConsumerService {

    @KafkaListener(topics = Topic.DEMO_TOPIC)
    public void consume(ConsumerRecord<String, String> data) {
        log.info("Message from topic: {} message: {}",
                Topic.DEMO_TOPIC, data.value());
    }

    static class Topic {
        public static final String DEMO_TOPIC = "DEMO_TOPIC";
    }

}
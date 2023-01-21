package io.desofme.kafkaconsumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class ConsumerService {

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = Topic.MESSAGE_TOPIC, groupId = "groupID")
    public void consume(ConsumerRecord<String, Object> data) throws Exception {
        log.info("Message from topic: {} message: {}",
                Topic.MESSAGE_TOPIC, objectMapper.writeValueAsString(data.value()));
    }

    static class Topic {
        public static final String MESSAGE_TOPIC = "MESSAGE_TOPIC";
    }

}
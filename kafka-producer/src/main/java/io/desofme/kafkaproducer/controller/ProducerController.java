package io.desofme.kafkaproducer.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.desofme.kafkaproducer.config.properties.KafkaProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import static io.desofme.kafkaproducer.config.properties.KafkaProperties.DEMO_TOPIC;

@Slf4j
@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @PostMapping("/produce")
    public void produce(@RequestBody Dummy data) throws JsonProcessingException {
        kafkaTemplate.send(DEMO_TOPIC, objectMapper.writeValueAsString(data));
        log.info("Message sent to topic: {}", DEMO_TOPIC);
    }

    @Data
    static class Dummy {
        private String id;
        private String code;

        @JsonFormat(pattern = "dd.MM.yyyy")
        private LocalDate time;
    }

}
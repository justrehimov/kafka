package io.desofme.kafkaproducer.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProducerController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/produce")
    public void produce(@RequestBody Dummy data) {
        kafkaTemplate.send(Topic.MESSAGE_TOPIC.name(), data);
        log.info("Message sent to topic: {}", Topic.MESSAGE_TOPIC);
    }

    @Data
    static class Dummy {
        private String id;
        private String code;

        @JsonFormat(pattern = "dd.MM.yyyy")
        private LocalDate time;
    }

    enum Topic {
        MESSAGE_TOPIC
    }

}
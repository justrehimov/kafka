package io.desofme.kafkaproducer.config;

import io.desofme.kafkaproducer.config.properties.KafkaProperties;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder
                .name(KafkaProperties.DEMO_TOPIC)
                .partitions(5)
                .replicas(1)
                .build();
    }

}
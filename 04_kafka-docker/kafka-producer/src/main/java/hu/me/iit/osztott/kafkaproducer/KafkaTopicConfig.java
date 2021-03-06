package hu.me.iit.osztott.kafkaproducer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    NewTopic configKafka() {
        return TopicBuilder.name("chat-rooms")
                .partitions(1)
                .replicas(1)
                .build();
    }
}

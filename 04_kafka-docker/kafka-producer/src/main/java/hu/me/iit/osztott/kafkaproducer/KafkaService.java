package hu.me.iit.osztott.kafkaproducer;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface KafkaService {
    void sendMessage(MessageDto message) throws JsonProcessingException;
}

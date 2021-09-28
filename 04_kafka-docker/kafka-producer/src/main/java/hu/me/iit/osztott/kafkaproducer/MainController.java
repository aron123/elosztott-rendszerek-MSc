package hu.me.iit.osztott.kafkaproducer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final KafkaService kafkaService;

    public MainController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping("/send-message")
    void main(@RequestBody MessageDto message) throws JsonProcessingException {
        kafkaService.sendMessage(message);
    }
}

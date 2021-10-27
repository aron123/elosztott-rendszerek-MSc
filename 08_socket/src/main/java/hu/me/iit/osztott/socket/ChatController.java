package hu.me.iit.osztott.socket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/chat")
    @SendTo("/chat/message")
    public OutgoingChatMessage greeting(IncomingChatMessage message) throws InterruptedException {
        Thread.sleep(1000);
        return new OutgoingChatMessage(message);
    }
}

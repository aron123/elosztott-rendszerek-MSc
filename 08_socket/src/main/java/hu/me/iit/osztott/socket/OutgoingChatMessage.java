package hu.me.iit.osztott.socket;

import lombok.Data;

@Data
public class OutgoingChatMessage {
    private String arrivedMessage;
    private String sender;
    private String target;

    public OutgoingChatMessage(IncomingChatMessage incomingChatMessage) {
        this.arrivedMessage = incomingChatMessage.getMessage();
        this.sender = incomingChatMessage.getSender();
        this.target = incomingChatMessage.getTarget();
    }
}

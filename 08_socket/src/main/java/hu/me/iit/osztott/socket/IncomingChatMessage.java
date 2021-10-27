package hu.me.iit.osztott.socket;

import lombok.Data;

@Data
public class IncomingChatMessage {
    private String message;

    private String sender;

    private String target;
}

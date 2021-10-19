package hu.me.iit.osztott.elastic;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class ChatMessageDto {
    @NotBlank
    private String id;

    @NotBlank
    private String message;

    @NotBlank
    private String sender;

    @NotBlank
    private String roomId;

    @NotBlank
    private String roomName;

    public ChatMessage toDocument() {
        return ChatMessage.builder()
                .id(this.id)
                .message(this.message)
                .sender(this.sender)
                .roomId(this.roomId)
                .roomName(this.roomName)
                .build();
    }
}

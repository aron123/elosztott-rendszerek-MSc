package hu.me.iit.osztott.elastic;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {

    private final ChatMessageRepository chatMessageRepository;

    @PostMapping
    public void newData(@RequestBody @Valid ChatMessageDto messageDto) {
        chatMessageRepository.save(messageDto.toDocument());
    }

    @GetMapping
    public Page<ChatMessage> findMessage(@RequestParam @Valid String query) {
        return chatMessageRepository.findBySender(query, PageRequest.of(0, 10));
    }

    @GetMapping("/find")
    public Page<ChatMessage> findBySenderOrMessageOrRoomName(@RequestParam @Valid String query) {
        return chatMessageRepository.findBySenderOrMessageOrRoomName(
                query, query, query, PageRequest.of(0, 10));
    }
}

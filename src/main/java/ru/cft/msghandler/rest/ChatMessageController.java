package ru.cft.msghandler.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.cft.msghandler.model.ChatMessageState;
import ru.cft.msghandler.rest.dto.ChatMessageDto;
import ru.cft.msghandler.service.ChatMessagesService;

@RestController
@RequestMapping("/messages")
public class ChatMessageController {

    @Autowired
    private ChatMessagesService service;

    @GetMapping("/{state}")
    public Flux<ChatMessageDto> getByState(@PathVariable("state") ChatMessageState state) {
        return service.findByState(state)
                .map(m -> new ChatMessageDto(m.getId(), m.getSender(), m.getText(), m.getState()));
    }

}

package ru.cft.msghandler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import ru.cft.msghandler.model.ChatMessage;
import ru.cft.msghandler.model.ChatMessageState;
import ru.cft.msghandler.repository.ChatMessageRepository;

@Service
public class DefaultChatMessagesService implements ChatMessagesService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Override
    public Flux<ChatMessage> findByState(ChatMessageState state) {
        return Flux.just(
                chatMessageRepository
                        .findByState(state)
                        .toArray(new ChatMessage[]{})
        );
    }
}

package ru.cft.msghandler.service;

import reactor.core.publisher.Flux;
import ru.cft.msghandler.model.ChatMessage;
import ru.cft.msghandler.model.ChatMessageState;

public interface ChatMessagesService {
    Flux<ChatMessage> findByState(ChatMessageState state);
}

package ru.cft.msghandler.repository;

import org.springframework.data.repository.CrudRepository;
import ru.cft.msghandler.model.ChatMessage;
import ru.cft.msghandler.model.ChatMessageState;

import java.util.List;

public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {
    List<ChatMessage> findByState(ChatMessageState state);
}

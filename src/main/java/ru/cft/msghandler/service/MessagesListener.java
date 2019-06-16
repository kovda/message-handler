package ru.cft.msghandler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.cft.msghandler.model.ChatMessage;
import ru.cft.msghandler.model.ChatMessageState;
import ru.cft.msghandler.repository.ChatMessageRepository;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class MessagesListener {

    private final static Logger log = LoggerFactory.getLogger(MessagesListener.class);

    @Autowired
    private ChatMessageRepository repository;

    @RabbitListener(queues = {"${rabbit.queue.massages.channel}"})
    public void pullMessage(ChatMessage message) {
        ChatMessageState state = getState();
        message.setState(state);
        log.info("Pull chat message {} with state {}", message, state);
        repository.save(message);
    }

    private ChatMessageState getState() {
        if (ThreadLocalRandom.current().nextInt(2) == 0) {
            return ChatMessageState.BAD;
        } else {
            return ChatMessageState.GOOD;
        }
    }
}

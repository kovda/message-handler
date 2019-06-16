package ru.cft.msghandler.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cft.msghandler.model.ChatMessageState;

public class ChatMessageDto {

    private final Long id;
    private final String sender;
    private final String text;
    private final ChatMessageState state;

    @JsonCreator
    public ChatMessageDto(
            @JsonProperty("id") Long id,
            @JsonProperty("sender") String sender,
            @JsonProperty("text") String text,
            @JsonProperty("state") ChatMessageState state
    ) {
        this.id = id;
        this.sender = sender;
        this.text = text;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    public ChatMessageState getState() {
        return state;
    }
}

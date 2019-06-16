package ru.cft.msghandler.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "messages")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String sender;

    @Column
    private String text;

    @Column
    @Enumerated(EnumType.STRING)
    private ChatMessageState state;

    public ChatMessage() {
    }

    public ChatMessage(String sender, String text, ChatMessageState state) {
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

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ChatMessageState getState() {
        return state;
    }

    public void setState(ChatMessageState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatMessage that = (ChatMessage) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(sender, that.sender) &&
                Objects.equals(text, that.text) &&
                state == that.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sender, text, state);
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", text='" + text + '\'' +
                ", state=" + state +
                '}';
    }
}

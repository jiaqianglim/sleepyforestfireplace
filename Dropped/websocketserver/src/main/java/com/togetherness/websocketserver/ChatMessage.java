package com.togetherness.websocketserver;

public class ChatMessage {
    String content;
    String sender;
    MessageType type;

    public enum MessageType {
        CHAT, LEFT, JOIN
    }
}

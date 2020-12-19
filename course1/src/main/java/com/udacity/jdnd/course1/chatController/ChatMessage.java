package com.udacity.jdnd.course1.chatController;

public class ChatMessage {
    private String username;
    private String messageText;

    public ChatMessage(String username, String messageText) {
        this.username = username;
        this.messageText = messageText;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        String text = "";
        text += String.format("username: %s | message: %s", this.username, this.messageText);
        return text;
    }
}

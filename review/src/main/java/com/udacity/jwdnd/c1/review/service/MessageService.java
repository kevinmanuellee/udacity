package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.MessageMapper;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;


@Service
public class MessageService {
//    private String message;
//
//    public MessageService(String message){
//        this.message=message;
//    }
//
//    public String upperCase(String message){
//        return this.message.toUpperCase();
//    }
//
//    public String lowerCase(String message){
//        return this.message.toLowerCase();
//    }

    private final MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    public void addMessage(ChatForm chatForm){
        ChatMessage newMessage = new ChatMessage();
        String rawText = chatForm.getMessageText();
        String type = chatForm.getMessageType();
        String finalMessage = "";
        String username = chatForm.getUsername();
        switch(type){
            case "Say" :
                finalMessage = rawText;
                break;
            case "Whisper" :
                finalMessage = rawText.toLowerCase();
                break;
            case "Shout" :
                finalMessage = rawText.toUpperCase();
                break;
        }
        newMessage.setMessageText(finalMessage);
        newMessage.setUsername(username);
        messageMapper.addMessage(newMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return messageMapper.getChatMessages();
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Creating MessageService Bean");
    }

}

package com.udacity.jdnd.course1.chatController;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageListService {
    private List<ChatMessage> messageList;

    @PostConstruct
    private void init(){
        this.messageList = new ArrayList<>();
    }

    public void addMessage(ChatMessage message){
        messageList.add(message);
    }

    public List<ChatMessage> getMessageList() {
        return new ArrayList<ChatMessage>(this.messageList);
    }

    public String upperCase(String messageText){
        return messageText.toUpperCase();
    }

    public String lowerCase(String messageText){
        return messageText.toLowerCase();
    }
}

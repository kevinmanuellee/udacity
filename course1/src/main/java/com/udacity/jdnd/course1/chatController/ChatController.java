package com.udacity.jdnd.course1.chatController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {
    private MessageListService messageListService;

    public ChatController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping("/chat")
    public String getMapping(ChatForm chatForm, Model model){
        model.addAttribute("messages", this.messageListService.getMessageList());
        return "chat";
    }

    @PostMapping("/chat")
    public String postMapping(ChatForm chatForm, Model model){
        ChatMessage newMessage;
        switch(chatForm.getMessageType()){
            case "Say" : newMessage = new ChatMessage(chatForm.getUsername(), chatForm.getMessageText());
            break;
            case "Shout" : newMessage = new ChatMessage(chatForm.getUsername(), messageListService.upperCase(chatForm.getMessageText()));
            break;
            case "Whisper" : newMessage = new ChatMessage(chatForm.getUsername(), messageListService.lowerCase(chatForm.getMessageText()));
            break;
            default: newMessage = null;
        }
//        ChatMessage newMessage = new ChatMessage(chatForm.getUsername(), chatForm.getMessageText());
        messageListService.addMessage(newMessage);
        model.addAttribute("messages", this.messageListService.getMessageList());
        chatForm.setMessageText("");
        chatForm.setUsername("");
        return "chat";
    }


}

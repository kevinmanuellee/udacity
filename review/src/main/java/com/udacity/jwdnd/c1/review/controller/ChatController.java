package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import com.udacity.jwdnd.c1.review.model.User;
import com.udacity.jwdnd.c1.review.service.MessageService;
import com.udacity.jwdnd.c1.review.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private MessageService messageService;

    public ChatController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getMessageList(Model model, ChatForm chatForm){
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        return "chat";
    }

    @PostMapping
    public String postChatMessage(Model model, ChatForm chatForm, Authentication authentication){
        chatForm.setUsername(authentication.getPrincipal().toString());
        System.out.println("CHAT FORM = " + chatForm.getUsername());
        this.messageService.addMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes(){
        return new String[] {"Say", "Shout", "Whisper"};
    }

}

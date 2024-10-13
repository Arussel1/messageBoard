package com.example.messageboard.controller;

import com.example.messageboard.model.Message;
import com.example.messageboard.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Message> messages = messageRepository.findAll();
        model.addAttribute("title", "Mini Messageboard");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping("/new")
    public String newMessage(Model model) {
        model.addAttribute("title", "Send a Message");
        return "form";
    }

    @PostMapping("/new")
    public String addMessage(@RequestParam("messageUser") String messageUser,
                             @RequestParam("messageText") String messageText) {
        Message message = new Message(messageText, messageUser, new Date());
        messageRepository.save(message);
        return "redirect:/";
    }
}

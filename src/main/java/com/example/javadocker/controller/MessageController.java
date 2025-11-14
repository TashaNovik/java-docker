package com.example.javadocker.controller;

import com.example.javadocker.entity.Message;
import com.example.javadocker.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        return messageRepository.save(message);
    }

    @GetMapping("/{id}")
    public Message getMessage(@PathVariable Long id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message not found"));
    }

}

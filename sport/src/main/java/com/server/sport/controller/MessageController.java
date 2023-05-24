package com.server.sport.controller;

import com.server.sport.model.Message;
import com.server.sport.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
  @Autowired
  private MessageService messageService;

  @PostMapping("/create")
  public Message createMessage(@RequestBody Message message) {
    return messageService.createMessage(message);
  }

  @GetMapping("/messages/{chatId}")
  public List<Message> getMessagesForChat(@PathVariable Integer chatId) {
    return messageService.getAllMessagesForChat(chatId);
  }
}

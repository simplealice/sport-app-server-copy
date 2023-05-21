package com.server.sport.controller;

import com.server.sport.model.Chat;
import com.server.sport.service.ChatService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {
  @Autowired
  private ChatService chatService;

  @PostMapping("/add")
  public String add(@RequestBody Chat message) {
    chatService.createMessage(message);
    return "Добавлено новое сообщение";
  }

  @GetMapping("/messages/{chatId}")
  public List<Chat> getMessagesByChatId(@PathVariable Integer chatId) {
    List<Chat> messages = chatService.getMessagesByChatId(chatId);
    return messages;
  }

  @GetMapping("/chats/{userId}")
  public List<Chat> getChatsForUser(@PathVariable Integer userId) {
    List<Chat> chats = chatService.getChatsForUser(userId);
    return chats;
  }
}

package com.server.sport.controller;

import com.server.sport.model.Chat;
import com.server.sport.service.ChatService;
import java.time.LocalDateTime;
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

  @PostMapping("/create")
  public Chat createChat(@RequestBody Chat chat) {
    return chatService.createChat(chat);
  }

  @GetMapping("/chats/{userId}")
  public List<Chat> getChatsForUser(@PathVariable Integer userId) {
    return chatService.getChatsForUser(userId);
  }
}

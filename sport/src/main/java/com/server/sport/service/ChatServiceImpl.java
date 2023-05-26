package com.server.sport.service;

import com.server.sport.model.Chat;
import com.server.sport.repository.ChatRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

  Logger logger = LoggerFactory.getLogger(CoachServiceImpl.class);
  @Autowired
  private ChatRepository chatRepository;

  @Override
  public Chat createChat(Chat chat) {
    List<Chat> existingChats = chatRepository.findByUser1AndUser2OrderByCreatedDateDesc(
        chat.getUser1(), chat.getUser2());
    existingChats.addAll(chatRepository.findByUser1AndUser2OrderByCreatedDateDesc(
        chat.getUser2(), chat.getUser1()));
    if (existingChats.isEmpty()) {
      logger.info("CREATED CHAT");
      chat.setCreatedDate(LocalDateTime.now());
      return chatRepository.save(chat);
    }
    else {
      // chat already exists, handle accordingly
      logger.info("CHAT IS ALREADY ALIVE");
      return existingChats.get(0);
    }
  }

  @Override
  public List<Chat> getChatsForUser(Integer userId) {
    // Code to retrieve chats for a user from the database
    return chatRepository.findByUser1OrUser2OrderByCreatedDateDesc(userId, userId);
  }
}

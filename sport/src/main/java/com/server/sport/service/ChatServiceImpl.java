package com.server.sport.service;

import com.server.sport.model.Chat;
import com.server.sport.repository.ChatRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

  @Autowired
  private ChatRepository chatRepository;

  @Override
  public Chat createMessage(Chat message) {
    return chatRepository.save(message);
  }

  @Override
  public List<Chat> getMessagesByChatId(Integer chatId) {
    return chatRepository.findByChatId(chatId);
  }

  @Override
  public List<Chat> getChatsForUser(Integer userId) {
    // Code to retrieve chats for a user from the database
    return chatRepository.findBySenderIdOrRecipientIdOrderByTimestampDesc(userId, userId);
  }
}

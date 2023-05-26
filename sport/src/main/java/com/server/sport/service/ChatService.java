package com.server.sport.service;

import com.server.sport.model.Chat;
import java.util.List;

public interface ChatService {
  Chat createChat(Chat chat);
  List<Chat> getChatsForUser(Integer userId);
}

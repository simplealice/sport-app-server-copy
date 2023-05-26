package com.server.sport.service;

import com.server.sport.model.Message;
import java.util.List;

public interface MessageService {
  Message createMessage(Message message);
  List<Message> getMessagesBySenderAndRecipientId(Integer senderId, Integer recipientId);
  List<Message> getAllMessagesForChat(Integer chatId);
}

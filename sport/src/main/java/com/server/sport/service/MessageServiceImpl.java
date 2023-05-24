package com.server.sport.service;

import com.server.sport.model.Message;
import com.server.sport.repository.MessageRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

  @Autowired
  private MessageRepository messageRepository;

  @Override
  public Message createMessage(Message message) {
    message.setTimestamp(LocalDateTime.now());
    return messageRepository.save(message);
  }

  @Override
  public List<Message> getMessagesBySenderAndRecipientId(Integer senderId, Integer recipientId) {
    return messageRepository.findBySenderIdAndRecipientIdOrderByTimestampAsc(senderId, recipientId);
  }

  @Override
  public List<Message> getAllMessagesForChat(Integer chatId) {
    return messageRepository.findByChatIdOrderByTimestampAsc(chatId);
  }
}

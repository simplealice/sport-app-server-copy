package com.server.sport.repository;

import com.server.sport.model.Message;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
  List<Message> findBySenderIdAndRecipientIdOrderByTimestampAsc(Integer senderId, Integer recipientId);

  List<Message> findByChatIdOrderByTimestampAsc(Integer chatId);
}

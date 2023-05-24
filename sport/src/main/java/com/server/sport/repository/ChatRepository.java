package com.server.sport.repository;

import com.server.sport.model.Chat;
import com.server.sport.user.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
  List<Chat> findByChatId(Integer chatId);

  List<Chat> findBySenderIdOrRecipientIdOrderByTimestampDesc(Integer userId1, Integer userId2);
}

package com.server.sport.repository;

import com.server.sport.model.Chat;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
  List<Chat> findByUser1AndUser2OrderByCreatedDateDesc(Integer user1, Integer user2);
  List<Chat> findByUser1OrUser2OrderByCreatedDateDesc(Integer user1, Integer user2);
}

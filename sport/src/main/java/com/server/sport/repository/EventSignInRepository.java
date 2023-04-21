package com.server.sport.repository;

import com.server.sport.model.EventSignIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventSignInRepository extends JpaRepository<EventSignIn, Integer> {
  boolean existsEventSignInByEmail (String email);

}
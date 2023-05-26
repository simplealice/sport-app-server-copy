package com.server.sport.repository;

import com.server.sport.model.TimeSignIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSignInRepository extends JpaRepository<TimeSignIn, Integer> {
//  List<TimeSignIn> findByEventIdOrderBySignDate(Integer eventId);
}

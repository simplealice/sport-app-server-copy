package com.server.sport.service;

import com.server.sport.model.EventSignIn;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface EventSignInService {
  ResponseEntity<EventSignIn> saveEventSignIn(EventSignIn eventSignIn);
  List<EventSignIn> getAllEventsSignIn();
  EventSignIn getEventSignIn(Integer id);
}

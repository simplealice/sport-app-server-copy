package com.server.sport.service;

import com.server.sport.model.EventSignIn;
import com.server.sport.repository.EventSignInRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EventSignInServiceImpl implements EventSignInService {
  @Autowired
  private EventSignInRepository eventSignInRepository;

  @Override
  public ResponseEntity<EventSignIn> saveEventSignIn(EventSignIn eventSignIn) {
    if(!eventSignInRepository.existsEventSignInByEmail(eventSignIn.getEmail())) {
      return ResponseEntity.ok(eventSignInRepository.save(eventSignIn));
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  @Override
  public List<EventSignIn> getAllEventsSignIn() {
    return eventSignInRepository.findAll();
  }
}

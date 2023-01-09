package com.server.sport.service;

import com.server.sport.model.Event;
import com.server.sport.repository.EventRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

  @Autowired
  private EventRepository eventRepository;

  @Override
  public Event saveEvent(Event event) {
    return eventRepository.save(event);
  }

  @Override
  public List<Event> getAllEvents() {
    return eventRepository.findAll();
  }
}

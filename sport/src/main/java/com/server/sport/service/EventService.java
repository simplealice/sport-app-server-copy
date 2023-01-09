package com.server.sport.service;

import com.server.sport.model.Event;
import java.util.List;

public interface EventService {
  public Event saveEvent(Event event);
  public List<Event> getAllEvents();
}

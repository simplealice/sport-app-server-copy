package com.server.sport.service;

import com.server.sport.model.Coach;
import com.server.sport.model.Event;
import java.time.LocalDate;
import java.util.List;

public interface EventService {
  public Event saveEvent(Event event);
  public List<Event> getAllEvents();
  Event editEvent(Integer id, LocalDate newDate, String newTitle, String newCity, String newDescription, String newType, String newDiscipline, String newImage);
  void deleteById(Integer id);
}

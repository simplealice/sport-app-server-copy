package com.server.sport.service;

import com.server.sport.model.Event;
import java.time.LocalDate;
import java.util.List;

public interface EventService {
  Event saveEvent(Event event);
  List<Event> getAllEvents();
  Event getEvent(Integer id);
  Event editEvent(Integer id, LocalDate newDate, String newTitle, String newCity, String newDescription, String newType, String newDiscipline, String newImage);
  void deleteById(Integer id);
}

package com.server.sport.service;

import com.server.sport.model.Event;
import com.server.sport.repository.EventRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

  public Event getEvent(Integer id) {
    return eventRepository.findById(id).orElseThrow(
        () -> new UsernameNotFoundException("Event not found")
    );
  }

  @Override
  public Event editEvent(Integer id, LocalDate newDate, String newTitle, String newCity,
      String newDescription, String newType, String newDiscipline, String newImage) {
    Event event = eventRepository.getReferenceById(id);
    if (newDate != null) {
      event.setDate(newDate);
    }
    if (newTitle != null) {
      event.setTitle(newTitle);
    }
    if (newCity != null) {
      event.setCity(newCity);
    }
    if (newDescription != null) {
      event.setDescription(newDescription);
    }
    if (newType != null) {
      event.setType(newType);
    }
    if (newDiscipline != null) {
      event.setDiscipline(newDiscipline);
    }
    if (newImage != null) {
      event.setImage(newImage);
    }
    return eventRepository.save(event);
  }

  @Override
  public void deleteById(Integer id) {
    eventRepository.deleteById(id);
  }
}

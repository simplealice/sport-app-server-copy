package com.server.sport.controller;

import com.server.sport.model.Event;
import com.server.sport.service.EventService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {
  @Autowired
  private EventService eventService;

  @PostMapping("/add")
  public String add(@RequestBody Event event) {
    eventService.saveEvent(event);
    return "Добавлено новое событие";
  }

  @PostMapping("/getAll")
  public List<Event> getAllEvents() {
    return eventService.getAllEvents();
  }
}

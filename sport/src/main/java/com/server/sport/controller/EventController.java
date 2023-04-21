package com.server.sport.controller;

import com.server.sport.model.Event;
import com.server.sport.request.EditEventRequest;
import com.server.sport.service.EventService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping("/getAll")
  public List<Event> getAllEvents() {
    return eventService.getAllEvents();
  }

  @GetMapping(value = "/delete/{id}")
  public String delete(@PathVariable("id") Integer id) {
    eventService.deleteById(id);
    return "Удалено событие " + id;
  }

  @PutMapping("edit/{id}")
  public ResponseEntity<Event> editEvent(@PathVariable Integer id,
      @RequestBody EditEventRequest editEventRequest) {
    Event editEvent = eventService.editEvent(id,
        editEventRequest.getNewDate(),
        editEventRequest.getNewTitle(),
        editEventRequest.getNewCity(),
        editEventRequest.getNewDescription(),
        editEventRequest.getNewType(),
        editEventRequest.getNewDiscipline(),
        editEventRequest.getNewImage());
    return new ResponseEntity<>(editEvent, HttpStatus.OK);
  }
}

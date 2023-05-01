package com.server.sport.controller;

import com.server.sport.model.Coach;
import com.server.sport.model.EventSignIn;
import com.server.sport.service.EventSignInService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventSignIn")
public class EventSignInController {
  @Autowired
  private EventSignInService eventSignInService;

  @PostMapping("/add")
  public String add(@RequestBody EventSignIn eventSignIn) {
    eventSignInService.saveEventSignIn(eventSignIn);
    return "Добавлена новая запись на событие";
  }

  @GetMapping("/getAll")
  public List<EventSignIn> getAllEventsSignIn() {
    return eventSignInService.getAllEventsSignIn();
  }

  @PostMapping(value = "/get/{id}")
  public EventSignIn getEventSignIn(@PathVariable("id") Integer id) {
    return eventSignInService.getEventSignIn(id);
  }
}

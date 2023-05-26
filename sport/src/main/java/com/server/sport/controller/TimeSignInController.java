package com.server.sport.controller;

import com.server.sport.model.TimeSignIn;
import com.server.sport.service.TimeSignInService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timeSignIn")
public class TimeSignInController {
  @Autowired
  private TimeSignInService timeSignInService;

  @PostMapping("/add")
  public String add(@RequestBody TimeSignIn timeSignIn) {
    timeSignInService.saveTimeSignIn(timeSignIn);
    return "Добавлено новое время записи";
  }

  @GetMapping("/getAll")
  public List<TimeSignIn> getAllTimeSignIn() {
    return timeSignInService.getAllTimeSignIn();
  }

  @PostMapping(value = "/get/{id}")
  public TimeSignIn getTimeSignIn(@PathVariable("id") Integer id) {
    return timeSignInService.getTimeSignIn(id);
  }

  @GetMapping(value = "/delete/{id}")
  public String delete(@PathVariable("id") Integer id) {
    timeSignInService.deleteById(id);
    return "Удалено время записи " + id;
  }
}

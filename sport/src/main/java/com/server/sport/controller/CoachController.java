package com.server.sport.controller;

import com.server.sport.model.Coach;
import com.server.sport.service.CoachService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coaches")
public class CoachController {
  @Autowired
  private CoachService coachService;

  @PostMapping("/add")
  public String add(@RequestBody Coach coach) {
    coachService.saveCoach(coach);
    return "Добавлен новый тренер";
  }

  @PostMapping("/getAll")
  public List<Coach> getAllCoaches() {
    return coachService.getAllCoaches();
  }
}

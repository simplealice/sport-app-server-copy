package com.server.sport.controller;

import com.server.sport.model.Coach;
import com.server.sport.model.UserResponse;
import com.server.sport.request.EditCoachRequest;
import com.server.sport.service.CoachService;
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
@RequestMapping("/coaches")
public class CoachController {
  @Autowired
  private CoachService coachService;

  @PostMapping("/add")
  public String add(@RequestBody Coach coach) {
    coachService.saveCoach(coach);
    return "Добавлен новый тренер";
  }

  @GetMapping("/getAll")
  public List<Coach> getAllCoaches() {
    return coachService.getAllCoaches();
  }

  @GetMapping(value = "/delete/{id}")
  public String delete(@PathVariable("id") Integer id) {
    coachService.deleteById(id);
    return "Удален тренер " + id;
  }

  @PutMapping("edit/{coachId}")
  public ResponseEntity<Coach> editCoach(@PathVariable Integer coachId,
      @RequestBody EditCoachRequest editCoachRequest) {
    Coach editedUser = coachService.editCoach(coachId,
        editCoachRequest.getNewName(),
        editCoachRequest.getNewSurname(),
        editCoachRequest.getNewPosition(),
        editCoachRequest.getNewDescription(),
        editCoachRequest.getNewPhoto());
    return new ResponseEntity<>(editedUser, HttpStatus.OK);
  }

  @PostMapping(value = "/get/{id}")
  public Coach getCoach(@PathVariable("id") Integer id) {
    return coachService.getCoach(id);
  }

}

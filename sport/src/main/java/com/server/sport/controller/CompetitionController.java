package com.server.sport.controller;

import com.server.sport.model.Competition;
import com.server.sport.request.EditCompetitionRequest;
import com.server.sport.service.CompetitionService;
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
@RequestMapping("/competitions")
public class CompetitionController {

  @Autowired
  private CompetitionService competitionService;

  @PostMapping("/add")
  public String add(@RequestBody Competition competition) {
    competitionService.saveCompetition(competition);
    return "Добавлены новые соревнования";
  }

  @GetMapping("/getAll")
  public List<Competition> getAllCompetitions() {
    return competitionService.getAllCompetitions();
  }

  @PostMapping(value = "/get/{id}")
  public Competition getCompetition(@PathVariable("id") Integer id) {
    return competitionService.getCompetition(id);
  }

  @GetMapping(value = "/delete/{id}")
  public String delete(@PathVariable("id") Integer id) {
    competitionService.deleteById(id);
    return "Удалено соревнование " + id;
  }

  @PutMapping("edit/{id}")
  public ResponseEntity<Competition> editCoach(@PathVariable Integer id,
      @RequestBody EditCompetitionRequest editCompetitionRequest) {
    Competition editCompetition = competitionService.editCompetition(id,
        editCompetitionRequest.getNewTitle(),
        editCompetitionRequest.getNewDate(),
        editCompetitionRequest.getNewDiscipline(),
        editCompetitionRequest.getNewCity(),
        editCompetitionRequest.getNewDescription(),
        editCompetitionRequest.getNewImage());
    return new ResponseEntity<>(editCompetition, HttpStatus.OK);
  }
}

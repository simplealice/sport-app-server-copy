package com.server.sport.controller;

import com.server.sport.model.Competition;
import com.server.sport.service.CompetitionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}

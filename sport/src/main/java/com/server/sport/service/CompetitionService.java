package com.server.sport.service;

import com.server.sport.model.Competition;
import java.time.LocalDate;
import java.util.List;

public interface CompetitionService {
  public Competition saveCompetition(Competition competition);
  public List<Competition> getAllCompetitions();
  Competition editCompetition(Integer id, String newTitle, LocalDate newDate, String newDiscipline, String newCity, String newDescription, String newImage);
  void deleteById(Integer id);
}

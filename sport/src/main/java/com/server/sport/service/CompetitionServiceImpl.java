package com.server.sport.service;

import com.server.sport.model.Coach;
import com.server.sport.model.Competition;
import com.server.sport.repository.CompetitionRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetitionServiceImpl implements CompetitionService {

  @Autowired
  private CompetitionRepository competitionRepository;

  @Override
  public Competition saveCompetition(Competition competition) {
    return competitionRepository.save(competition);
  }

  @Override
  public List<Competition> getAllCompetitions() {
    return competitionRepository.findAll();
  }

  @Override
  public Competition editCompetition(Integer id, String newTitle, LocalDate newDate,
      String newDiscipline, String newCity, String newDescription, String newImage) {
    Competition competition = competitionRepository.getReferenceById(id);

    if (newTitle != null) {
      competition.setTitle(newTitle);
    }
    if (newDate != null) {
      competition.setDate(newDate);
    }
    if (newDiscipline != null) {
      competition.setDiscipline(newDiscipline);
    }
    if (newCity != null) {
      competition.setCity(newCity);
    }
    if (newDescription != null) {
      competition.setDescription(newDescription);
    }
    if (newImage != null) {
      competition.setImage(newImage);
    }
    return competitionRepository.save(competition);
  }

  @Override
  public void deleteById(Integer id) {
    competitionRepository.deleteById(id);
  }
}

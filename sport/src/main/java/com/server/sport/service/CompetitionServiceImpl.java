package com.server.sport.service;

import com.server.sport.model.Competition;
import com.server.sport.repository.CompetitionRepository;
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
}

package com.server.sport.service;

import com.server.sport.model.Competition;
import java.util.List;

public interface CompetitionService {
  public Competition saveCompetition(Competition competition);
  public List<Competition> getAllCompetitions();
}

package com.server.sport.service;

import com.server.sport.model.Coach;
import com.server.sport.repository.CoachRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachServiceImpl implements CoachService {

  @Autowired
  private CoachRepository coachRepository;

  @Override
  public Coach saveCoach(Coach coach) {
    return coachRepository.save(coach);
  }

  @Override
  public List<Coach> getAllCoaches() {
    return coachRepository.findAll();
  }
}

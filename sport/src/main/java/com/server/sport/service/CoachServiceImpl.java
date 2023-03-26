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

  public Coach editCoach(Long userId, String newName, String newSurname,
      String newPosition, String newDescription, String newPhoto) {
    Coach coach = coachRepository.findById(userId);
    
    if (newName != null) {
      coach.setName(newName);
    }
    if (newSurname != null) {
      coach.setSurname(newSurname);
    }
    if (newPosition != null) {
      coach.setPosition(newPosition);
    }
    if (newDescription != null) {
      coach.setDescription(newDescription);
    }
    if (newPhoto != null) {
      coach.setImage(newPhoto);
    }

    return coachRepository.save(coach);
  }
}

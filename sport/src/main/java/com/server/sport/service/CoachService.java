package com.server.sport.service;

import com.server.sport.model.Coach;
import java.util.List;

public interface CoachService {
  public Coach saveCoach(Coach coach);
  public List<Coach> getAllCoaches();
}

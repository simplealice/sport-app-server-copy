package com.server.sport.service;

import com.server.sport.model.Coach;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface CoachService {
  Coach saveCoach(Coach coach);
  List<Coach> getAllCoaches();
  Coach editCoach(Integer coachId, String newName, String newSurname, String newPosition, String newDescription, String newPhoto);
  void deleteById(Integer id);
  Coach getCoach(Integer id);

  Coach addCoachImage(Integer coachId, MultipartFile data);
}

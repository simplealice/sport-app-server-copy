package com.server.sport.service;

import com.server.sport.model.Curriculum;
import java.util.List;

public interface CurriculumService {
  public Curriculum saveCurriculum(Curriculum curriculum);
  public List<Curriculum> getCurriculum();
  Curriculum editCurriculum(Integer id, String newGroupNumber, String newCoach, String newDayOfWeek, String newTimeFromTo);
  void deleteById(Integer id);
}

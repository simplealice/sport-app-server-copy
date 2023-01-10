package com.server.sport.service;

import com.server.sport.model.Curriculum;
import java.util.List;

public interface CurriculumService {
  public Curriculum saveCurriculum(Curriculum curriculum);
  public List<Curriculum> getCurriculum();
}

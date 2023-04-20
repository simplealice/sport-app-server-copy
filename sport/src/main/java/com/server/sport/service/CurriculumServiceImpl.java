package com.server.sport.service;

import com.server.sport.model.Competition;
import com.server.sport.model.Curriculum;
import com.server.sport.repository.CurriculumRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurriculumServiceImpl implements CurriculumService {

  @Autowired
  private CurriculumRepository curriculumRepository;

  @Override
  public Curriculum saveCurriculum(Curriculum curriculum) {
    return curriculumRepository.save(curriculum);
  }

  @Override
  public List<Curriculum> getCurriculum() {
    return curriculumRepository.findAll();
  }

  @Override
  public Curriculum editCurriculum(Integer id, String newGroupNumber, String newCoach,
      String newDayOfWeek, String newTimeFromTo) {
    Curriculum curriculum = curriculumRepository.getReferenceById(id);

    if (newGroupNumber != null) {
      curriculum.setGroupNumber(newGroupNumber);
    }
    if (newCoach != null) {
      curriculum.setCoach(newCoach);
    }
    if (newDayOfWeek != null) {
      curriculum.setDayOfWeek(newDayOfWeek);
    }
    if (newTimeFromTo != null) {
      curriculum.setTimeFromTo(newTimeFromTo);
    }
    return curriculumRepository.save(curriculum);
  }

  @Override
  public void deleteById(Integer id) {
    curriculumRepository.deleteById(id);
  }
}

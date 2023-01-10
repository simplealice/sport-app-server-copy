package com.server.sport.service;

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
}

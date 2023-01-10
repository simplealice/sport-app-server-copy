package com.server.sport.controller;

import com.server.sport.model.Curriculum;
import com.server.sport.model.Curriculum;
import com.server.sport.service.CurriculumService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curriculum")
public class CurriculumController {

  @Autowired
  private CurriculumService curriculumService;

  @PostMapping("/add")
  public String add(@RequestBody Curriculum curriculum) {
    curriculumService.saveCurriculum(curriculum);
    return "Добавлено новое расписание";
  }

  @PostMapping("/get")
  public List<Curriculum> getCurriculum() {
    return curriculumService.getCurriculum();
  }
}

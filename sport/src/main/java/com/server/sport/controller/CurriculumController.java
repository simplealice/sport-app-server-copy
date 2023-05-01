package com.server.sport.controller;

import com.server.sport.model.Coach;
import com.server.sport.model.Curriculum;
import com.server.sport.request.EditCurriculumRequest;
import com.server.sport.service.CurriculumService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping("/get")
  public List<Curriculum> getCurriculum() {
    return curriculumService.getCurriculum();
  }

  @PostMapping(value = "/get/{id}")
  public Curriculum getCurriculum(@PathVariable("id") Integer id) {
    return curriculumService.getCurriculum(id);
  }

  @GetMapping(value = "/delete/{id}")
  public String delete(@PathVariable("id") Integer id) {
    curriculumService.deleteById(id);
    return "Удалено расписание " + id;
  }

  @PutMapping("edit/{id}")
  public ResponseEntity<Curriculum> editCurriculum(@PathVariable Integer id,
      @RequestBody EditCurriculumRequest editCurriculumRequest) {
    Curriculum editCurriculum = curriculumService.editCurriculum(id,
        editCurriculumRequest.getNewGroupNumber(),
        editCurriculumRequest.getNewCoach(),
        editCurriculumRequest.getNewDayOfWeek(),
        editCurriculumRequest.getNewTimeFromTo());
    return new ResponseEntity<>(editCurriculum, HttpStatus.OK);
  }
}

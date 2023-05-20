package com.server.sport.controller;

import com.server.sport.model.IndividualClass;
import com.server.sport.service.IndividualClassService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/individualClasses")
public class IndividualClassController {
  @Autowired
  private IndividualClassService individualClassService;

  @PostMapping("/add")
  public String add(@RequestBody IndividualClass individualClass) {
    individualClassService.saveIndividualClass(individualClass);
    return "Добавлено новое событие";
  }

  @GetMapping("/getAll")
  public List<IndividualClass> getAllIndividualClasses() {
    return individualClassService.getAllIndividualClasses();
  }

  @PostMapping(value = "/get/{id}")
  public IndividualClass getIndividualClass(@PathVariable("id") Integer id) {
    return individualClassService.getIndividualClass(id);
  }
}

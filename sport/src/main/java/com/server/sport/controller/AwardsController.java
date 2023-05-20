package com.server.sport.controller;

import com.server.sport.model.Awards;
import com.server.sport.request.EditAwardRequest;
import com.server.sport.service.AwardsService;
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
@RequestMapping("/awards")
public class AwardsController {
  @Autowired
  private AwardsService awardsService;

  @PostMapping("/add")
  public String add(@RequestBody Awards awards) {
    awardsService.saveAwards(awards);
    return "Добавлена новая награда";
  }

  @GetMapping("/getAll")
  public List<Awards> getAllAwards() {
    return awardsService.getAllAwards();
  }

  @GetMapping(value = "/delete/{id}")
  public String delete(@PathVariable("id") Integer id) {
    awardsService.deleteById(id);
    return "Удалена награда " + id;
  }

  @PutMapping("edit/{awardsId}")
  public ResponseEntity<Awards> editAwards(@PathVariable Integer awardsId,
      @RequestBody EditAwardRequest editAwardRequest) {
    Awards editedAwards = awardsService.editAwards(awardsId,
        editAwardRequest.getNewName(),
        editAwardRequest.getNewDescription(),
        editAwardRequest.getNewImage());
    return new ResponseEntity<>(editedAwards, HttpStatus.OK);
  }

  @PostMapping(value = "/get/{id}")
  public Awards getAwards(@PathVariable("id") Integer id) {
    return awardsService.getAwards(id);
  }
}

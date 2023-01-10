package com.server.sport.controller;

import com.server.sport.model.Event;
import com.server.sport.model.Photo;
import com.server.sport.service.PhotoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/photos")
public class PhotoController {

  @Autowired
  private PhotoService photoService;

  @PostMapping("/add")
  public String add(@RequestBody Photo photo) {
    photoService.savePhoto(photo);
    return "Добавлено новое фото";
  }

  @PostMapping("/getAll")
  public List<Photo> getAllPhotos() {
    return photoService.getAllPhotos();
  }
}

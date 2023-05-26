package com.server.sport.controller;

import com.server.sport.model.Photo;
import com.server.sport.request.EditPhotoRequest;
import com.server.sport.service.PhotoService;
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
@RequestMapping("/photos")
public class PhotoController {

  @Autowired
  private PhotoService photoService;

  @PostMapping("/add")
  public String add(@RequestBody Photo photo) {
    photoService.savePhoto(photo);
    return "Добавлено новое фото";
  }

  @GetMapping("/getAll")
  public List<Photo> getAllPhotos() {
    return photoService.getAllPhotos();
  }

  @PostMapping(value = "/get/{id}")
  public Photo getPhoto(@PathVariable("id") Integer id) {
    return photoService.getPhoto(id);
  }

  @GetMapping(value = "/delete/{id}")
  public String delete(@PathVariable("id") Integer id) {
    photoService.deleteById(id);
    return "Удалено фото " + id;
  }

  @PutMapping("edit/{id}")
  public ResponseEntity<Photo> editPhoto(@PathVariable Integer id,
      @RequestBody EditPhotoRequest editPhotoRequest) {
    Photo editPhoto = photoService.editPhoto(id,
        editPhotoRequest.getNewImage());
    return new ResponseEntity<>(editPhoto, HttpStatus.OK);
  }
}

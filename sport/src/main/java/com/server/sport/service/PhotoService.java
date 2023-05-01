package com.server.sport.service;

import com.server.sport.model.Photo;
import java.util.List;

public interface PhotoService {
  Photo savePhoto(Photo photo);
  List<Photo> getAllPhotos();
  Photo getPhoto(Integer id);
  Photo editPhoto(Integer id, String newImage);
  void deleteById(Integer id);
}

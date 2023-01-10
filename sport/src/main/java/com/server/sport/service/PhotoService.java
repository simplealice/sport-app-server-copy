package com.server.sport.service;

import com.server.sport.model.Photo;
import java.util.List;

public interface PhotoService {
  public Photo savePhoto(Photo photo);
  public List<Photo> getAllPhotos();
}

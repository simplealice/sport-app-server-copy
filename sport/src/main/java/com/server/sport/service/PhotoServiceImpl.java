package com.server.sport.service;

import com.server.sport.model.Photo;
import com.server.sport.repository.PhotoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements PhotoService {

  @Autowired
  private PhotoRepository photoRepository;

  @Override
  public Photo savePhoto(Photo photo) {
    return photoRepository.save(photo);
  }

  @Override
  public List<Photo> getAllPhotos() {
    return photoRepository.findAll();
  }

  @Override
  public Photo getPhoto(Integer id) {
    return photoRepository.findById(id).orElseThrow(
        () -> new UsernameNotFoundException("Photo not found")
    );
  }

  @Override
  public Photo editPhoto(Integer id, String newImage) {
    Photo photo = photoRepository.getReferenceById(id);
    if (newImage != null) {
      photo.setImage(newImage);
    }
    return photoRepository.save(photo);
  }

  @Override
  public void deleteById(Integer id) {
    photoRepository.deleteById(id);
  }
}

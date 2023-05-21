package com.server.sport.service;

import com.server.sport.config.FileStorageUtil;
import com.server.sport.model.Coach;
import com.server.sport.repository.CoachRepository;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CoachServiceImpl implements CoachService {

  Logger logger = LoggerFactory.getLogger(CoachServiceImpl.class);

  @Autowired
  private CoachRepository coachRepository;

  @Override
  public Coach saveCoach(Coach coach) {
    return coachRepository.save(coach);
  }

  @Override
  public List<Coach> getAllCoaches() {
    return coachRepository.findAll();
  }

  public Coach getCoach(Integer id) {
    return coachRepository.findById(id).orElseThrow(
        () -> new UsernameNotFoundException("Coach not found")
    );
  }

  @Override
  public Coach addCoachImage(Integer coachId, MultipartFile data) {
    Coach coach = coachRepository.getReferenceById(coachId);
    try {
      coach.setFilebyte(FileStorageUtil.compressFile(data.getBytes()));
      logger.info(String.valueOf(FileStorageUtil.compressFile(data.getBytes()).length));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return coachRepository.save(coach);
  }

  @Override
  public Coach editCoach(Integer userId, String newName, String newSurname,
      String newPosition, String newDescription, String newPhoto) {
    Coach coach = coachRepository.getReferenceById(userId);

    if (newName != null) {
      coach.setName(newName);
    }
    if (newSurname != null) {
      coach.setSurname(newSurname);
    }
    if (newPosition != null) {
      coach.setPosition(newPosition);
    }
    if (newDescription != null) {
      coach.setDescription(newDescription);
    }
    if (newPhoto != null) {
      coach.setImage(newPhoto);
    }

    return coachRepository.save(coach);
  }

  @Override
  public void deleteById(Integer id) {
    coachRepository.deleteById(id);
  }
}

package com.server.sport.service;

import com.server.sport.model.Awards;
import com.server.sport.repository.AwardsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AwardsServiceImpl implements AwardsService {

  @Autowired
  private AwardsRepository awardsRepository;

  @Override
  public Awards saveAwards(Awards awards) {
    return awardsRepository.save(awards);
  }

  @Override
  public List<Awards> getAllAwards() {
    return awardsRepository.findAll();
  }

  @Override
  public Awards editAwards(Integer awardId, String newName, String newDescription,
      String newImage) {
    Awards awards = awardsRepository.getReferenceById(awardId);
    if (newName != null) {
      awards.setName(newName);
    }
    if (newDescription != null) {
      awards.setDescription(newDescription);
    }
    if (newImage != null) {
      awards.setImage(newImage);
    }
    return awardsRepository.save(awards);
  }

  @Override
  public void deleteById(Integer id) {
    awardsRepository.deleteById(id);
  }

  @Override
  public Awards getAwards(Integer id) {
    return awardsRepository.findById(id).orElseThrow(
        () -> new UsernameNotFoundException("Awards not found")
    );
  }
}

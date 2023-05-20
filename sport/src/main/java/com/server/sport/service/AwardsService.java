package com.server.sport.service;

import com.server.sport.model.Awards;
import com.server.sport.model.Coach;
import java.util.List;

public interface AwardsService {
  Awards saveAwards(Awards awards);
  List<Awards> getAllAwards();
  Awards editAwards(Integer awardId, String newName, String newDescription, String newImage);
  void deleteById(Integer id);
  Awards getAwards(Integer id);
}

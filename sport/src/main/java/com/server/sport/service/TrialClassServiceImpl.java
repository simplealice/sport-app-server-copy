package com.server.sport.service;

import com.server.sport.model.TrialClass;
import com.server.sport.repository.TrialClassRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrialClassServiceImpl implements TrialClassService {

  @Autowired
  private TrialClassRepository trialClassRepository;

  @Override
  public TrialClass saveTrialClass(TrialClass trialClass) {
    return trialClassRepository.save(trialClass);
  }

  @Override
  public List<TrialClass> getAllTrialClasses() {
    return trialClassRepository.findAll();
  }
}

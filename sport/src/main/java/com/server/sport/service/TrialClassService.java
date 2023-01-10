package com.server.sport.service;

import com.server.sport.model.TrialClass;
import java.util.List;

public interface TrialClassService {
  public TrialClass saveTrialClass(TrialClass trialClass);
  public List<TrialClass> getAllTrialClasses();
}

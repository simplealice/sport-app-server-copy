package com.server.sport.service;

import com.server.sport.model.TrialClass;
import java.util.List;

public interface TrialClassService {
  TrialClass saveTrialClass(TrialClass trialClass);
  List<TrialClass> getAllTrialClasses();
  TrialClass getTrialClass(Integer id);
}

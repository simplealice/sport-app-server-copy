package com.server.sport.service;

import com.server.sport.model.IndividualClass;
import java.util.List;

public interface IndividualClassService {
  IndividualClass saveIndividualClass(IndividualClass individualClass);
  List<IndividualClass> getAllIndividualClasses();
  IndividualClass getIndividualClass(Integer id);
}

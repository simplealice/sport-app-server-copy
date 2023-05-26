package com.server.sport.service;

import com.server.sport.model.IndividualClass;
import com.server.sport.repository.IndividualClassRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class IndividualClassServiceImpl implements IndividualClassService {

  @Autowired
  private IndividualClassRepository individualClassRepository;

  @Override
  public IndividualClass saveIndividualClass(IndividualClass individualClass) {
    return individualClassRepository.save(individualClass);
  }

  @Override
  public List<IndividualClass> getAllIndividualClasses() {
    return individualClassRepository.findAll();
  }

  @Override
  public IndividualClass getIndividualClass(Integer id) {
    return individualClassRepository.findById(id).orElseThrow(
        () -> new UsernameNotFoundException("Individual class not found")
    );
  }

  @Override
  public void deleteById(Integer id) {
    individualClassRepository.deleteById(id);
  }
}

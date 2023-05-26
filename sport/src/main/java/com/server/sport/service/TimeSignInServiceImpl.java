package com.server.sport.service;

import com.server.sport.model.TimeSignIn;
import com.server.sport.repository.TimeSignInRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TimeSignInServiceImpl implements TimeSignInService {
  @Autowired
  private TimeSignInRepository timeSignInRepository;

  @Override
  public TimeSignIn saveTimeSignIn(TimeSignIn timeSignIn) {
    return timeSignInRepository.save(timeSignIn);
  }

  @Override
  public List<TimeSignIn> getAllTimeSignIn() {
    return timeSignInRepository.findAll();
  }

  @Override
  public TimeSignIn getTimeSignIn(Integer id) {
    return timeSignInRepository.findById(id).orElseThrow(
        () -> new UsernameNotFoundException("Time sign in not found")
    );
  }

  @Override
  public void deleteById(Integer id) {
    timeSignInRepository.deleteById(id);
  }
}

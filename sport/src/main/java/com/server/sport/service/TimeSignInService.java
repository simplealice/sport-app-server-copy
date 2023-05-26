package com.server.sport.service;

import com.server.sport.model.TimeSignIn;
import java.util.List;

public interface TimeSignInService {
  TimeSignIn saveTimeSignIn(TimeSignIn timeSignIn);
  List<TimeSignIn> getAllTimeSignIn();
//  List<TimeSignIn> getAllTimeSignInForEvent(Integer eventId);
  TimeSignIn getTimeSignIn(Integer id);
  void deleteById(Integer id);
}

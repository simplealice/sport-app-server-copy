package com.server.sport.service;

import com.server.sport.model.Feedback;
import java.util.List;

public interface FeedbackService {
  Feedback saveFeedback(Feedback feedback);
  List<Feedback> getAllFeedbacks();
  Feedback getFeedback(Integer id);
}

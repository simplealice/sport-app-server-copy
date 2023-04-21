package com.server.sport.service;

import com.server.sport.model.Feedback;
import com.server.sport.repository.FeedbackRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {

  @Autowired
  private FeedbackRepository feedbackRepository;

  @Override
  public Feedback saveFeedback(Feedback feedback) {
    return feedbackRepository.save(feedback);
  }

  @Override
  public List<Feedback> getAllFeedbacks() {
    return feedbackRepository.findAll();
  }
}

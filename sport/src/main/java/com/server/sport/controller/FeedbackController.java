package com.server.sport.controller;

import com.server.sport.model.Feedback;
import com.server.sport.service.FeedbackService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
  @Autowired
  private FeedbackService feedbackService;

  @PostMapping("/add")
  public String add(@RequestBody Feedback feedback) {
    feedbackService.saveFeedback(feedback);
    return "Добавлен новый отзыв";
  }

  @GetMapping("/getAll")
  public List<Feedback> getAllFeedbacks() {
    return feedbackService.getAllFeedbacks();
  }
}
